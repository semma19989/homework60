package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository <Album,String> {
    public Album findAlbumByName(String name);
    public Album findAlbumByReleaseYear(int releaseYear);
}
