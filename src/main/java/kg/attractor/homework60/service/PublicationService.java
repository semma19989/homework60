package kg.attractor.homework60.service;


import kg.attractor.homework60.dto.PublicationDTO;
import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.model.Users;
import kg.attractor.homework60.repository.PublicationImageRepository;
import kg.attractor.homework60.repository.PublicationRepository;
import kg.attractor.homework60.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

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
                .user(ur.findUsersById(publicationDTO.getUserId()))
                .date(publicationDTO.getDate())
                .build();
        pr.save(pub);
        return PublicationDTO.from(pub);
    }

    public void deletePublicationById(String id){
        pr.deletePublicationById(id);
    }

    public Iterable<PublicationDTO> findAllPub(@ApiIgnore Pageable pageable){
        return pr.findAll(pageable).map(PublicationDTO::from);
    }

    public PublicationDTO findPublicationById (String id) {
        return PublicationDTO.from(pr.findPublicationById(id));
    }

    public List<PublicationDTO> findPubByUsMail(String mail){
        List<Publication> res = new ArrayList<>();
        Users user = ur.findUsersByMail(mail);
        List<Users> subs = user.getSubsciptions();
        for (Users s: subs) {
            res.addAll(s.getPublicationList());
        }

        List<PublicationDTO> publicationDTOs=new ArrayList<>();
        for(Publication p : res){
            publicationDTOs.add(PublicationDTO.from(p));
        }
        return publicationDTOs;
    }
}
