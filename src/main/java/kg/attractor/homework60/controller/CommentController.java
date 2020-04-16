package kg.attractor.homework60.controller;


import kg.attractor.homework60.annotations.ApiPageable;
import kg.attractor.homework60.dto.CommentDTO;
import kg.attractor.homework60.service.CommentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@ApiPageable
@RestController
@RequestMapping("/comment")
public class CommentController {
    CommentService cs;

    public CommentController(CommentService cs) {
        this.cs = cs;
    }

    @PostMapping()
    public CommentDTO createComment(@RequestBody CommentDTO com) {
        return cs.createComment(com);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") String id){
        cs.deleteCommentById(id);
    }

    @GetMapping("/all")
    public Slice<CommentDTO> findAll(@ApiIgnore Pageable pageable){
        return cs.findAllCom(pageable);
    }
}
