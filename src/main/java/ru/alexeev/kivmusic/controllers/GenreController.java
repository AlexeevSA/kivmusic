package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexeev.kivmusic.models.Genre;
import ru.alexeev.kivmusic.repository.GenreRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/add")
    public String addGenre(Model model, Genre genre){
        return "genre-add";
    }

    @PostMapping("/add")
    public String PostaddGenre(@Valid Genre genre, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "genre-add";
        }
        genreRepository.save(genre);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String genreDetails(@PathVariable(value = "id") long id, Model model){
        Genre genre = genreRepository.findById(id).orElseThrow();
        model.addAttribute("genre", genre);
        if (!genreRepository.existsById(id)){
            return "redirect:/";
        }
        return "genre-details";
    }

    @GetMapping("/{id}/edit")
    public String genreEdit(@PathVariable(value = "id") long id, Model model, Genre genre){
        if (!genreRepository.existsById(id)){
            return "redirect:/";
        }
        genre = genreRepository.findById(id).orElseThrow();
        model.addAttribute("genre", genre);
        return "genre-upd";
    }

    @PostMapping("/{id}/edit")
    public String genreUpd(@PathVariable(value = "id") long id, Model model,
                            @Valid Genre genre, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "artist-upd";
        }
        genreRepository.save(genre);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String genreDelete(@PathVariable(value = "id") long id, Model model){
        Genre genre = genreRepository.findById(id).orElseThrow();
        genreRepository.delete(genre);
        return "redirect:/";
    }
}
