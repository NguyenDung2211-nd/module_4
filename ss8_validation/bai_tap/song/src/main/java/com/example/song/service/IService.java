package com.example.song.service;

import com.example.song.entity.Song;

import java.util.List;
import java.util.Optional;

public interface IService {
    List<Song> findAll();
    void save(Song song);
    Optional<Song> findById(Integer id);
    void update (Integer id,Song song);
    void delete(Integer id);

}
