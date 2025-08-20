
package main.java.spring.project.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import main.java.spring.project.entities.RefreshToken;
import main.java.spring.project.repository.RefreshTokenRepository;
import main.java.spring.project.repository.UserRepository;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshToken createRefreshToken(Strnig username) {
        UserInfo userInfoExtracted = userRepository.findByUsername(username);
        RefreshToken refreshToken = RefreshToken.builder().userInfo(userInfoExtracted)
                .token(UUID.randomUUID().toString()).expiryDate(Instant.now().plusMillis(600000)).build();

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " is expired. Please make a new sign in request.");
        }
        return token;
    }

    public Optional<RefreshToken> findBYToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
}
