package ru.alexeev.kivmusic.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Label_Name;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Название должен быть больше 1 символа")
    private String Legal_Address;

    @OneToMany(mappedBy = "lable", fetch = FetchType.EAGER)
    private Collection<Label> lables;

    public Label() {
    }

    public Label(String label_Name, String legal_Address, Collection<Label> lables) {
        Label_Name = label_Name;
        Legal_Address = legal_Address;
        this.lables = lables;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel_Name() {
        return Label_Name;
    }

    public void setLabel_Name(String label_Name) {
        Label_Name = label_Name;
    }

    public String getLegal_Address() {
        return Legal_Address;
    }

    public void setLegal_Address(String legal_Address) {
        Legal_Address = legal_Address;
    }

    public Collection<Label> getLables() {
        return lables;
    }

    public void setLables(Collection<Label> lables) {
        this.lables = lables;
    }
}
