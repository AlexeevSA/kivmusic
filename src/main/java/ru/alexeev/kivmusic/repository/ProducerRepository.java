package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Producer;

public interface ProducerRepository extends CrudRepository<Producer, Long> {
    Producer findByLastname(String Last_Name);
}
