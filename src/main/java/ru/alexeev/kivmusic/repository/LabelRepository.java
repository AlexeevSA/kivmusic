package ru.alexeev.kivmusic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Label;

public interface LabelRepository extends CrudRepository<Label, Long> {
    Label findByLabel_Name(String Label_Name);
}
