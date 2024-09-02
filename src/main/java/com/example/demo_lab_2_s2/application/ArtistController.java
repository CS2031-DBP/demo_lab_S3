package com.example.demo_lab_2_s2.application;

import com.example.demo_lab_2_s2.repository.ArtistRepository;
import com.example.demo_lab_2_s2.domain.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist){
        Artist savedArtist = artistRepository.save(artist);
        return ResponseEntity.ok(savedArtist);
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getArtists(){
        List<Artist> artistas = artistRepository.findAll();
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/test")
    public ResponseEntity<String> getApi(){
        String respuesta = "hola";
        return ResponseEntity.ok(respuesta);
    }
}
