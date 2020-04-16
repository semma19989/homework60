package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository <Like, String> {
    boolean existsLikeByUserId(String id);
}
