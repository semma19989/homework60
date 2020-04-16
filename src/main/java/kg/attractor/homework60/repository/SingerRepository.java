package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer,String> {
    public Singer findSingerByName(String name);
}
