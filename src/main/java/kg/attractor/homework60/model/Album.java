package kg.attractor.homework60.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "albumList")
@Data
@CompoundIndex(def = "{'name':1, 'releaseYear':1}")
public class Album {

    @Id
    private String id;
    private String name;
    private int releaseYear;
    @DBRef
    private List<Song> songList = new ArrayList<>();

    public Album(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }
}
