package com.example.demo_lab_s2.controller;

import com.example.demo_lab_s2.domain.Artist;
import com.example.demo_lab_s2.exceptions.ResourceNotFoundException;
import com.example.demo_lab_s2.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.example.demo_lab_s2

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    ArtistRepository artistRepository;

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist){
        Artist savedArtist = artistRepository.save(artist);
        return ResponseEntity.ok(savedArtist);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(){
        List<Artist> allArtists = artistRepository.findAll();
        return ResponseEntity.ok(allArtists);
    }

    @GetMapping("{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id){
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist with id " + id + " not found"));
        return ResponseEntity.ok(artist);
    }



    @GetMapping("/test")
    public ResponseEntity<String> getApi(){
        String respuesta = "Hola";
        return ResponseEntity.ok(respuesta);
    }
}
