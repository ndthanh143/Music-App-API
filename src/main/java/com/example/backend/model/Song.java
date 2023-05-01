package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "song")
public class Song {
    @Id
    private String id;

    private String name;

    private String artist;

    private String source;

    private byte[] srcData;

    private byte[] imageData;

    private String lyrics;
    
    private MusicType type;
}
