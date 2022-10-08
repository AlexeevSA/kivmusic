package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Artist_Name;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Описание должен быть больше 5 символов")
    private String Description;
    @NotNull(message = "Выберите файл")
    private String Avatar;

    @ManyToMany
    @JoinTable (name="artist_album",
            joinColumns=@JoinColumn (name="artist_id"),
            inverseJoinColumns=@JoinColumn(name="album_id"))
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String artist_Name, String description, String avatar, List<Album> albums) {
        Artist_Name = artist_Name;
        Description = description;
        Avatar = avatar;
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist_Name() {
        return Artist_Name;
    }

    public void setArtist_Name(String artist_Name) {
        Artist_Name = artist_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
