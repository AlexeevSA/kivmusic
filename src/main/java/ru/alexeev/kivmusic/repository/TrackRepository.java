package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Track;

public interface TrackRepository extends CrudRepository<Track, Long> {
    Track findByTrack_Name(String Track_Name);
}
