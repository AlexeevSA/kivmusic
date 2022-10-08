package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexeev.kivmusic.models.Playlist;
import ru.alexeev.kivmusic.repository.PlaylistRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/add")
    public String addPlaylist(Model model, Playlist playlist){
        return "playlist-add";
    }

    @PostMapping("/add")
    public String PostaddPlaylist(@Valid Playlist playlist, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "playlist-add";
        }
        playlistRepository.save(playlist);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String playlistDetails(@PathVariable(value = "id") long id, Model model){
        Playlist playlist = playlistRepository.findById(id).orElseThrow();
        model.addAttribute("playlist", playlist);
        if (!playlistRepository.existsById(id)){
            return "redirect:/";
        }
        return "playlist-details";
    }

    @GetMapping("/{id}/edit")
    public String playlistEdit(@PathVariable(value = "id") long id, Model model, Playlist playlist){
        if (!playlistRepository.existsById(id)){
            return "redirect:/";
        }
        playlist = playlistRepository.findById(id).orElseThrow();
        model.addAttribute("playlist", playlist);
        return "playlist-upd";
    }

    @PostMapping("/{id}/edit")
    public String playlistUpd(@PathVariable(value = "id") long id, Model model,
                           @Valid Playlist playlist, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "playlist-upd";
        }
        playlistRepository.save(playlist);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String labelDelete(@PathVariable(value = "id") long id, Model model){
        Playlist playlist = playlistRepository.findById(id).orElseThrow();
        playlistRepository.delete(playlist);
        return "redirect:/";
    }

}
