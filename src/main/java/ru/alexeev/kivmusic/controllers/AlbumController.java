package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.repository.AlbumRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/add")
    public String addAlbum(Model model, Album album){
        return "album-add";
    }

    @PostMapping("/add")
    public String PostaddAlbum(@Valid Album album, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "album-add";
        }
        albumRepository.save(album);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String albumDetails(@PathVariable(value = "id") long id, Model model){
        Album album = albumRepository.findById(id).orElseThrow();
        model.addAttribute("album", album);
        if (!albumRepository.existsById(id)){
            return "redirect:/";
        }
        return "album-details";
    }

    @GetMapping("/{id}/edit")
    public String albumEdit(@PathVariable(value = "id") long id, Model model, Album album){
        if (!albumRepository.existsById(id)){
            return "redirect:/";
        }
        album = albumRepository.findById(id).orElseThrow();
        model.addAttribute("album", album);
        return "album-upd";
    }

    @PostMapping("/{id}/edit")
    public String albumUpd(@PathVariable(value = "id") long id, Model model,
                           @Valid Album album, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "album-upd";
        }
        albumRepository.save(album);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String albumDelete(@PathVariable(value = "id") long id, Model model){
        Album album = albumRepository.findById(id).orElseThrow();
        albumRepository.delete(album);
        return "redirect:/";
    }


}
