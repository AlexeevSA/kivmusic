package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Genre_Name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Collection<Track> tracks;

    public Genre() {
    }

    public Genre(String genre_Name, Collection<Track> tracks) {
        Genre_Name = genre_Name;
        this.tracks = tracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre_Name() {
        return Genre_Name;
    }

    public void setGenre_Name(String genre_Name) {
        Genre_Name = genre_Name;
    }

    public Collection<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Collection<Track> tracks) {
        this.tracks = tracks;
    }
}
