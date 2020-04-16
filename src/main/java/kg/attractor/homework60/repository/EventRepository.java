package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository <Event, String> {
    //
}
