package org.example.springsecurityjwt.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.springsecurityjwt.models.RefreshToken;
import org.example.springsecurityjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional <User> findByUsername(String username);

    boolean existsByUsername(@NotBlank @Size(min = 3, max = 20) String username);

    boolean existsByEmail(@NotBlank @Size(max = 50) @Email String email);

    @Repository
   interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
       Optional<RefreshToken> findByToken(String token);
   }
}
