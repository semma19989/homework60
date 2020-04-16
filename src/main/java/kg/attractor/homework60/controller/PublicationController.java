package kg.attractor.homework60.controller;


import kg.attractor.homework60.annotations.ApiPageable;
import kg.attractor.homework60.dto.PublicationDTO;
import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.repository.PublicationRepository;
import kg.attractor.homework60.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@ApiPageable
@RestController
@RequestMapping("/post")
public class PublicationController {
    @Autowired
    PublicationRepository pr;
    PublicationService ps;

    public PublicationController(PublicationService ps) {
        this.ps = ps;
    }


    @DeleteMapping("/delete/{id}")
    public void deletePublication(@PathVariable("id") String id){
        ps.deletePublicationById(id);
    }

    @GetMapping("/all")
    public List<Publication> findAll(){
        return pr.findAll();
    }



    @GetMapping("/id/{id}")
    public PublicationDTO findPubId(@PathVariable("id") String id){
        return ps.findPublicationById(id);
    }

    @GetMapping("/mail/{mail}")
    public List<PublicationDTO> findPubByUsMail(@PathVariable("mail") String mail){
        return ps.findPubByUsMail(mail);
    }
}
