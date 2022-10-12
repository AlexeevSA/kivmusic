package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Playlist findByPlaylistname(String Playlist_Name);
}
