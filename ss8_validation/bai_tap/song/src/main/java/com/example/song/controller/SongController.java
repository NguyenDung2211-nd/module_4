package com.example.song.controller;

import com.example.song.entity.Song;
import com.example.song.service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private IService songService;

    @GetMapping("")
    public String listSongs(Model model){
        List<Song> songs = songService.findAll();
        if(songs.isEmpty()){
            model.addAttribute("mess", "Danh sách bài hát rỗng.");
        }else{
            model.addAttribute("songs", songs);
        }
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Song song, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "create";
        }
        songService.save(song);
        model.addAttribute("mess", "Thêm bài hát thành công");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/update")
    public String showEdit(Model model, @PathVariable Integer id) {
        Song song = songService.findById(id).get();
        model.addAttribute("song", song);
        return "update";
    }

    @PostMapping("/{id}/update")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        songService.update(id, song);
        redirectAttributes.addFlashAttribute("mess", "Sửa thông tin thành công.");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        songService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/songs";
    }
}
