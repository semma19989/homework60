package kg.attractor.homework60.model;

import kg.attractor.homework60.util.Generator;
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

    public Publication(String id, String des, String imagePath, LocalDateTime now, String userId) {
    }

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
