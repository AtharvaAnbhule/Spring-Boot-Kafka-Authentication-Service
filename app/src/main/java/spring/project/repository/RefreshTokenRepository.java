
package main.java.spring.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import spring.project.model.RefreshToken;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByToken(String token);

}
