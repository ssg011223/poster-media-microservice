package com.codecool.postermediamicroservice.controller;

import com.codecool.postermediamicroservice.model.Media;
import com.codecool.postermediamicroservice.model.MediaTypeEnum;
import com.codecool.postermediamicroservice.model.PersonMedia;
import com.codecool.postermediamicroservice.repository.MediaRepository;
import com.codecool.postermediamicroservice.repository.PersonMediaRepository;
import com.codecool.postermediamicroservice.service.MediaService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/media")
@CrossOrigin(origins = "*")
public class MediaController {
    @Autowired
    private MediaService mediaService;
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private PersonMediaRepository personMediaRepository;

    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public @ResponseBody byte[] getImage(@PathVariable String id) {
        return mediaService.getImageById(Long.parseLong(id));
    }

    @GetMapping(value = "/default-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] defaultImage() { return mediaService.getDefaultImage(); }

    @PostMapping("/person/{id}")
    public long postPersonMedia(@PathVariable String id,
                                          @RequestParam("file") MultipartFile file) {
        String route = mediaService.submit(file);
        PersonMedia personMedia = PersonMedia.builder()
                .personId(Long.parseLong(id))
                .mediaRoute(route)
                .mediaType(MediaTypeEnum.IMAGE)
                .build();

        personMediaRepository.save(personMedia);

        return personMedia.getId();
    }

    @PostMapping("/post/{id}")
    public long postPostMedia(@PathVariable String id,
                                @RequestParam("file") MultipartFile file) {
        String route = mediaService.submit(file);
        Media media = Media.builder()
                .postId(Long.parseLong(id))
                .mediaRoute(route)
                .mediaType(MediaTypeEnum.IMAGE)
                .build();

        mediaRepository.save(media);

        return media.getId();
    }
}
