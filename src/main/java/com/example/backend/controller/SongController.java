package com.example.backend.controller;

import com.example.backend.dto.SongDto;
import com.example.backend.model.Song;
import com.example.backend.service.FirebaseService;
import com.example.backend.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/song")
public class SongController {
    private final SongService songService;
    private final FirebaseService firebaseService;

    public SongController(SongService songService, FirebaseService firebaseService) {
        this.songService = songService;
        this.firebaseService = firebaseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable String id) {
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAll() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Song> create(@RequestPart("song") SongDto dto, @RequestPart("audio") MultipartFile audio, @RequestPart("image") MultipartFile image) throws IOException {
        return new ResponseEntity<>(songService.create(dto, audio, image), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> update(@PathVariable String id, @RequestBody SongDto dto) {
        return new ResponseEntity<>(songService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> delete(@PathVariable String id) {
        return new ResponseEntity<>(songService.delete(id), HttpStatus.OK);
    }
}
