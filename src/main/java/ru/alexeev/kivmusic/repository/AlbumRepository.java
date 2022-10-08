package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.User;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Album findByAlbum_Name(String Album_Name);
}
