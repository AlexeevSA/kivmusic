package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Track;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long> {
    List<Track> findByTracknameContaining(String Track_Name);
}
