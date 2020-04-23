package kg.attractor.homework60.dto;


import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.model.Users;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String id;
    private String name;
    private String mail;
    private String pass;
    public static UserDTO from(Users user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .mail(user.getMail())
                .pass(user.getPass())
                .build();
    }
}