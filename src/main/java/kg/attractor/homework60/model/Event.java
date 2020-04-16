package kg.attractor.homework60.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Event {
    @Id
    private String id;
    private String publUsId;
    private String subUsId;
    private LocalDateTime date;

    public Event(String publUsId, String subUsId, LocalDateTime date) {
        this.publUsId = publUsId;
        this.subUsId = subUsId;
        this.date = date;
    }

}
