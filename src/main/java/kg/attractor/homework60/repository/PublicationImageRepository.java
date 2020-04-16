package kg.attractor.homework60.repository;


import kg.attractor.homework60.model.PublicationImage;
import org.springframework.data.repository.CrudRepository;

public interface PublicationImageRepository extends CrudRepository<PublicationImage,String> {
    PublicationImage findPublicationImageById(String id);
}
