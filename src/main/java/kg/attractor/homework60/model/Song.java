package kg.attractor.homework60.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songList")
@Data
public class Song {

    @Id
    private String id;
    @Indexed
    private String name;

    public Song(String name) {
        this.name = name;
    }
}
