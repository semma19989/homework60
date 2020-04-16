package kg.attractor.homework60.dto;


import kg.attractor.homework60.model.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDTO {
    private String id;
    private String text;
    private LocalDateTime date;
    private String userId;

    public static CommentDTO from(Comment com) {
        return builder()
                .id(com.getId())
                .text(com.getText())
                .date(com.getDate())
                .userId(com.getUser().getId())
                .build();
    }
}
