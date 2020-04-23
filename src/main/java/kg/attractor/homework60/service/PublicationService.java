package kg.attractor.homework60.service;


import kg.attractor.homework60.dto.ImageDTO;
import kg.attractor.homework60.dto.PublicationDTO;
import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.model.PublicationImage;
import kg.attractor.homework60.model.Users;
import kg.attractor.homework60.repository.PublicationImageRepository;
import kg.attractor.homework60.repository.PublicationRepository;
import kg.attractor.homework60.repository.UsersRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService {

    @Autowired
    PublicationImageRepository pir;

    @Autowired
    PublicationRepository pr;

    @Autowired
    UsersRepository ur;

    public PublicationDTO createPublication(PublicationDTO publicationDTO){
        //PublicationImage img = pir.findPublicationImageById(publicationDTO.getImageId());
        Publication pub = Publication.builder()
                .id(publicationDTO.getId())
                .description(publicationDTO.getDescription())
                .date(publicationDTO.getDate())
                .build();
        pr.save(pub);
        return PublicationDTO.from(pub);
    }

    public void deletePublicationById(String id){
        pr.deletePublicationById(id);
    }

    public Iterable<PublicationDTO> findAllPub(@ApiIgnore Pageable pageable){
        return pr.findAll((org.springframework.data.domain.Pageable) pageable).map(PublicationDTO::from);
    }

    public PublicationDTO findPublicationById (String id) {
        return PublicationDTO.from(pr.findPublicationById(id));
    }

    public List<PublicationDTO> findPubByUsMail(String mail){
        List<Publication> res = new ArrayList<>();
        Users user = ur.findUsersByMail(mail);

        List<PublicationDTO> publicationDTOs=new ArrayList<>();
        for(Publication p : res){
            publicationDTOs.add(PublicationDTO.from(p));
        }
        return publicationDTOs;
    }

    public ImageDTO addImage(MultipartFile file) {
    }

    public Resource getById(String imageId) {
    }
}