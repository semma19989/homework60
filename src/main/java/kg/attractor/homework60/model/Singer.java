package kg.attractor.homework60.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Singer {

    @Id
    private String id;
    @Indexed
    private String name;
    @DBRef
    private List<Album>albumList = new ArrayList<>();

    public Singer(String name) {
        this.name = name;
    }
}
