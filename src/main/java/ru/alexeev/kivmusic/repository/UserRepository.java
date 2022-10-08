package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
