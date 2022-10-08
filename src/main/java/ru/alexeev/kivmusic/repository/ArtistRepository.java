package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Artist findByArtist_Name(String Artist_Name);
}
