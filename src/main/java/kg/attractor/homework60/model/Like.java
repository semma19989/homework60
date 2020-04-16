package kg.attractor.homework60.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Like {
    @Id
    private String id;
    private String userId;
    private String pubId;
    private LocalDateTime date;

    public Like(String userId, String pubId, LocalDateTime date) {
        this.userId = userId;
        this.pubId = pubId;
        this.date = date;
    }

}
