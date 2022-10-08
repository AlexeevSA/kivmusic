package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexeev.kivmusic.models.Producer;
import ru.alexeev.kivmusic.models.Track;
import ru.alexeev.kivmusic.repository.ProducerRepository;
import ru.alexeev.kivmusic.repository.TrackRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackRepository trackRepository;

    @GetMapping("/add")
    public String addTrack(Model model, Track track){
        return "track-add";
    }

    @PostMapping("/add")
    public String PostaddTrack(@Valid Track track, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "track-add";
        }
        trackRepository.save(track);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String trackDetails(@PathVariable(value = "id") long id, Model model){
        Track track = trackRepository.findById(id).orElseThrow();
        model.addAttribute("track", track);
        if (!trackRepository.existsById(id)){
            return "redirect:/";
        }
        return "track-details";
    }

    @GetMapping("/{id}/edit")
    public String trackEdit(@PathVariable(value = "id") long id, Model model, Track track){
        if (!trackRepository.existsById(id)){
            return "redirect:/";
        }
        track = trackRepository.findById(id).orElseThrow();
        model.addAttribute("track", track);
        return "track-upd";
    }

    @PostMapping("/{id}/edit")
    public String trackUpd(@PathVariable(value = "id") long id, Model model,
                              @Valid Track track, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "track-upd";
        }
        trackRepository.save(track);
        return "redirect:/";
    }
    @PostMapping("/{id}/remove")
    public String labelDelete(@PathVariable(value = "id") long id, Model model){
        Track track = trackRepository.findById(id).orElseThrow();
        trackRepository.delete(track);
        return "redirect:/";
    }

}
