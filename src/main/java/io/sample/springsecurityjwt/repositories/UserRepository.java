package io.sample.springsecurityjwt.repositories;

import io.sample.springsecurityjwt.models.JwtUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<JwtUser, String> {
    Optional<JwtUser> findByUsername(String userName);
}
