package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
    public Comment findCommentByText(String text);

    void  deleteCommentById(String id);
}
