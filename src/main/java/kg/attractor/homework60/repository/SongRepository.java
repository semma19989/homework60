package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository <Song,String> {
    public Song findSongByName(String name);
}
