package kg.attractor.homework60.controller;


import kg.attractor.homework60.model.Publication;
import kg.attractor.homework60.repository.CommentRepository;
import kg.attractor.homework60.repository.LikeRepository;
import kg.attractor.homework60.repository.PublicationRepository;
import kg.attractor.homework60.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    CommentRepository cr;

    /*@Autowired
    EventRepository er;*/

    @Autowired
    LikeRepository lr;

    @Autowired
    PublicationRepository pr;

    @Autowired
    UsersRepository ur;

    @GetMapping("/like/{mail}")
    public boolean checkLikePub(@PathVariable("mail") String mail){
        return lr.existsLikeByUserId(ur.findUsersByMail(mail).getId());
    }

    @GetMapping("/")
    public String demo1(Model model) {
        return "index";
    }

    @GetMapping("/demo")
    public String demo(Model model) {
        return "demo";
    }

    @PostMapping("/demo/post")
    public String postDemo(@RequestParam("login") String login,@RequestParam("password") String password) {
        System.out.println(login);
        System.out.println(password);
        return "redirect:/demo";
    }

    @PostMapping("/post")
    public String rootSave(@RequestParam("des") String des,
                           @RequestParam("id") String id,
                           @RequestParam("userId") String userId,
                           @RequestParam("photo") MultipartFile photo) throws IOException {
        File photoFile = new File("../img/"+photo.getOriginalFilename());
        //photoFile.createNewFile();
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(photo.getBytes());
        os.close();

        Publication publication = new Publication(id,des,"../img/"+photo.getOriginalFilename(),
                LocalDateTime.now(), userId);
        pr.save(publication);

        return "success";

    }

    @PostMapping("/comm")
    public String commSave(@RequestParam("userId") String userId,
                           @RequestParam("postId") String postId,
                           @RequestParam("comment") String comment,
                           @RequestParam("commId") String commId) {

        Comment comment1 = new Comment(commId,comment,LocalDateTime.now(),userId,postId);
        cr.save(comment1);

        return "success";

    }

    @GetMapping("/img/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {
        String path = "../img";
        try {
            InputStream is = new FileInputStream(new File(path) + "/" + name);
            return ResponseEntity
                    .ok()
                    .contentType(name.toLowerCase().contains(".png")? MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                    .body(StreamUtils.copyToByteArray(is));
        } catch (Exception e) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(path) + "/" + name);
                return ResponseEntity
                        .ok()
                        .contentType(name.toLowerCase().contains(".png")?MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                        .body(StreamUtils.copyToByteArray(is));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}