package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexeev.kivmusic.models.Artist;
import ru.alexeev.kivmusic.repository.ArtistRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/add")
    public String addArtist(Model model, Artist artist){
        return "artist-add";
    }

    @PostMapping("/add")
    public String PostaddArtist(@Valid Artist artist, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "artist-add";
        }
        artistRepository.save(artist);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String artistDetails(@PathVariable(value = "id") long id, Model model){
        Artist artist = artistRepository.findById(id).orElseThrow();
        model.addAttribute("artist", artist);
        if (!artistRepository.existsById(id)){
            return "redirect:/";
        }
        return "artist-details";
    }

    @GetMapping("/{id}/edit")
    public String artistEdit(@PathVariable(value = "id") long id, Model model, Artist artist){
        if (!artistRepository.existsById(id)){
            return "redirect:/";
        }
        artist = artistRepository.findById(id).orElseThrow();
        model.addAttribute("artist", artist);
        return "artist-upd";
    }

    @PostMapping("/{id}/edit")
    public String artistUpd(@PathVariable(value = "id") long id, Model model,
                           @Valid Artist artist, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "artist-upd";
        }
        artistRepository.save(artist);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String artistDelete(@PathVariable(value = "id") long id, Model model){
        Artist artist = artistRepository.findById(id).orElseThrow();
        artistRepository.delete(artist);
        return "redirect:/";
    }

}
