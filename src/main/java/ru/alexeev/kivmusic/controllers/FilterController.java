package ru.alexeev.kivmusic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexeev.kivmusic.models.Album;
import ru.alexeev.kivmusic.models.Track;
import ru.alexeev.kivmusic.repository.AlbumRepository;
import ru.alexeev.kivmusic.repository.TrackRepository;

import java.util.List;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    TrackRepository trackRepository;

    @GetMapping("/")
    public String filterMain(Model model)
    {
        return "filter";
    }
    @PostMapping("/result")
    public String filterResult(@RequestParam(required = false) String albumname ,
                             @RequestParam(required = false) String trackname, Model model)
    {
        if (albumname != null){
            List<Album> aresult = albumRepository.findByAlbumname(albumname);
            model.addAttribute("aresult", aresult);
        }

        if(trackname != null){
            List<Track> tresult = trackRepository.findByTracknameContaining(trackname);
            model.addAttribute("tresult", tresult);
        }
        return "filter";
    }

}
