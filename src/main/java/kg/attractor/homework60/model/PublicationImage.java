package kg.attractor.homework60.model;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection="pub_images")
public class PublicationImage {
    public static final PublicationImage NO_IMAGE = PublicationImage.builder().id("-NO-IMAGE-").build();
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Builder.Default
    private Binary pubData = new Binary(new byte[0]);
}
