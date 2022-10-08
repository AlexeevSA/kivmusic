package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Фамилия должена быть больше 2 символов")
    private String Last_Name;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Имя должено быть больше 2 символов")
    private String First_Name;
    private String Middle_Name;
    @NotBlank
    @Email
    private String Email;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Имя пользователя должено быть больше 5 символов")
    private String Username;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 8, message = "Пароль должен быть больше 8 символов")
    private String Password;
    @NotNull(message = "Выберите файл")
    private String Avatar;
    private Boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    private Collection<Playlist> playlists;

    public User() {
    }

    public User(String last_Name, String first_Name, String middle_Name, String email, String username, String password, String avatar, Boolean active, Set<Role> roles, Collection<Playlist> playlists) {
        Last_Name = last_Name;
        First_Name = first_Name;
        Middle_Name = middle_Name;
        Email = email;
        Username = username;
        Password = password;
        Avatar = avatar;
        this.active = active;
        this.roles = roles;
        this.playlists = playlists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getMiddle_Name() {
        return Middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        Middle_Name = middle_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Collection<Playlist> playlists) {
        this.playlists = playlists;
    }
}
