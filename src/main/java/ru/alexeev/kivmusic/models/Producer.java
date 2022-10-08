package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Producer {
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
    @NotNull(message = "Выберите файл")
    private String Avatar;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    private Collection<Producer> producers;

    public Producer() {
    }

    public Producer(String last_Name, String first_Name, String middle_Name, String avatar, Collection<Producer> producers) {
        Last_Name = last_Name;
        First_Name = first_Name;
        Middle_Name = middle_Name;
        Avatar = avatar;
        this.producers = producers;
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

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public Collection<Producer> getProducers() {
        return producers;
    }

    public void setProducers(Collection<Producer> producers) {
        this.producers = producers;
    }
}
