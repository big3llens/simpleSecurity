package ru.markelov.simpleSecurity.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.markelov.simpleSecurity.entities.User;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
