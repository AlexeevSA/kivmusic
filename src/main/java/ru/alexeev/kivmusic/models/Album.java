package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Album_Name;

    @NotBlank(message = "Поле не должно быть пустым")
    private Date Release_Date;
    @NotNull(message = "Выберите файл")
    private String Photo;

    @ManyToMany
    @JoinTable (name="artist_album",
            joinColumns=@JoinColumn (name="album_id"),
            inverseJoinColumns=@JoinColumn(name="artist_id"))
    private List<Artist> artists;

    @ManyToMany
    @JoinTable (name="artist_track",
            joinColumns=@JoinColumn (name="album_id"),
            inverseJoinColumns=@JoinColumn(name="track_id"))
    private List<Track> tracks;

    public Album(String album_Name, Date release_Date, String photo, List<Artist> artists, List<Track> tracks) {
        Album_Name = album_Name;
        Release_Date = release_Date;
        Photo = photo;
        this.artists = artists;
        this.tracks = tracks;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbum_Name() {
        return Album_Name;
    }

    public void setAlbum_Name(String album_Name) {
        Album_Name = album_Name;
    }

    public Date getRelease_Date() {
        return Release_Date;
    }

    public void setRelease_Date(Date release_Date) {
        Release_Date = release_Date;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
