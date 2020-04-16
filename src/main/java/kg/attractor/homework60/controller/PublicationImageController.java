package kg.attractor.homework60.controller;


import kg.attractor.homework60.dto.ImageDTO;
import kg.attractor.homework60.service.PublicationImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class PublicationImageController {
    private final PublicationImageService pis;

    public PublicationImageController(PublicationImageService pis) {
        this.pis = pis;
    }

    @PostMapping
    public ImageDTO addPubImage(@RequestParam("file") MultipartFile file) {
        return pis.addImage(file);
    }

    @GetMapping("/id/{imageId}")
    public ResponseEntity<Resource> serveFile(@PathVariable String imageId) {
        Resource resource = pis.getById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }
}
