package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.User;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> findByAlbumname(String Album_Name);
}
