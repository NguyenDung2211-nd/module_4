package com.example.song.service.impl;

import com.example.song.entity.Song;
import com.example.song.exception.SongNotFoundException;
import com.example.song.repository.SongRepository;
import com.example.song.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements IService {

    @Autowired
    private SongRepository songRepository;


    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        Optional<Song> existingSong = songRepository.findById(id);
        if (existingSong.isPresent()) {
            songRepository.deleteById(id);
        }else{
            throw new SongNotFoundException("Song with ID " + id + " not found");
        }
    }

    @Override
    public void update(Integer id, Song song) {
        Optional<Song> existingSong = songRepository.findById(id);
        if (existingSong.isPresent()) {
            Song songUpdate = existingSong.get();
            songUpdate.setName(song.getName());
            songUpdate.setArtist(song.getArtist());
            songUpdate.setGenre(song.getGenre());
            songRepository.save(songUpdate);
        }else {
            throw new SongNotFoundException("Song with ID " + id + " not found");
        }
    }


}


