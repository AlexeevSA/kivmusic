package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Playlist_Name;
    @NotNull(message = "Выберите файл")
    private String  Photo;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Playlist playlist;

    @ManyToMany
    @JoinTable (name="track_playlist",
            joinColumns=@JoinColumn (name="playlist_id"),
            inverseJoinColumns=@JoinColumn(name="track_id"))
    private List<Track> tracks;

    public Playlist() {
    }

    public Playlist(String playlist_Name, String photo, Playlist playlist, List<Track> tracks) {
        Playlist_Name = playlist_Name;
        Photo = photo;
        this.playlist = playlist;
        this.tracks = tracks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaylist_Name() {
        return Playlist_Name;
    }

    public void setPlaylist_Name(String playlist_Name) {
        Playlist_Name = playlist_Name;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
