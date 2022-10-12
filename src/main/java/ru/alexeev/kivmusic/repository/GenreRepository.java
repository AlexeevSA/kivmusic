package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByGenrename(String Genre_Name);
}
