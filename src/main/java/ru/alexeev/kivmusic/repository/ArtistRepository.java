package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Artist findByArtistname(String Artist_Name);
}
