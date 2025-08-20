package main.java.spring.project.services;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import main.java.spring.project.entities.UserInfo;
import main.java.spring.project.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoProducer userInfoProducer;

    public UserDetailsServiceImpl(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            UserInfoProducer userInfoProducer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userInfoProducer = userInfoProducer;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetails(userInfo);
    }

    public UserInfo checkIfUserAlreadyExists(UserInfo userInfo) {
        return userRepository.findByUsername(userInfo.getUsername());
    }

    public Boolean signupUser(UserInfo userInfoDto) {
        if (Objects.nonNull(checkIfUserAlreadyExists(userInfoDto))) {
            return false; // user already exists
        }

        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        String userId = UUID.randomUUID().toString();

        UserInfo savedUser = new UserInfo(userId, userInfoDto.getUsername(),
                userInfoDto.getPassword(), new HashSet<>());

        userRepository.save(savedUser);
        userInfoProducer.sendEventToKafka(savedUser);
        return true;
    }
}
