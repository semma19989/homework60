package kg.attractor.homework60.service;


import kg.attractor.homework60.dto.CommentDTO;
import kg.attractor.homework60.model.Comment;
import kg.attractor.homework60.repository.CommentRepository;
import kg.attractor.homework60.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class CommentService {
    @Autowired
    UsersRepository ur;

    @Autowired
    CommentRepository cr;

    public CommentDTO createComment(CommentDTO commentDTO){
        Comment com = Comment.builder()
                .id(commentDTO.getId())
                .text(commentDTO.getText())
                .date(commentDTO.getDate())
                .user(ur.findUsersById(commentDTO.getUserId()))
                .build();
        cr.save(com);
        return CommentDTO.from(com);
    }

    public void deleteCommentById(String id){
        cr.deleteCommentById(id);
    }

    public Slice<CommentDTO> findAllCom(@ApiIgnore Pageable pageable){
        return cr.findAll(pageable).map(CommentDTO::from);
    }
}
