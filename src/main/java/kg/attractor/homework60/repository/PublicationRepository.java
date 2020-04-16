package kg.attractor.homework60.repository;

import kg.attractor.homework60.model.Publication;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PublicationRepository extends PagingAndSortingRepository<Publication, String> {
    Publication findPublicationByDescription(String des);

    @Query("{'id' : {'$ne' : '?0'}}")
    Iterable<Publication> findAllBy(String id);

    void deletePublicationById(String id);

    Publication findPublicationById(String id);

    List<Publication> findAll();
}