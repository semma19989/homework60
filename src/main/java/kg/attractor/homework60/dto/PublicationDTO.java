package kg.attractor.homework60.dto;

import kg.attractor.homework60.model.Publication;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PublicationDTO {
    private String id;
    private String description;
    private String image;
    private String userId;
    private LocalDateTime date;

    public static PublicationDTO from(Publication pub) {
        return builder()
                .id(pub.getId())
                .description(pub.getDescription())
                .image(pub.getImagePath())
                .date(pub.getDate())
                .build();
    }
}