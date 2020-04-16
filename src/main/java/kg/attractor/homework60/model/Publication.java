package kg.attractor.homework60.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Document(collection = "publicationList")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Publication {
    @Id
    private String id;
    private String description;
    private String imagePath;
    private LocalDateTime date;
    @DBRef
    private Users user;

    /*public Publication(String id, String description, String imagePath){
        Objects.requireNonNull(description);
        Objects.requireNonNull(imagePath);
        this.id = id;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Publication(String id, String description, String imagePath, LocalDateTime date, Users user) {
        this.id = id;
        this.description = description;
        this.imagePath = imagePath;
        this.date = date;
        this.user = user;
    }*/

    /*public Candidate(String name, String photo) {

        this.id = String.valueOf(name.hashCode()); //UUID.randomUUID().toString();
        this.name = name;
        this.photo = photo;
    }*/

    public static Publication addPost(Users user) {
        Random r = new Random();
        return builder()
                .user(user)
                .description(Generator.makeDescription())
                .date(LocalDateTime.now())
                .imagePath("../img/"+(1+r.nextInt(5))+".jpg")
                .build();
    }

}
