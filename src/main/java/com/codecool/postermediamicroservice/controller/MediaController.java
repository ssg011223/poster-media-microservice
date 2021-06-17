package com.codecool.postermediamicroservice.controller;

import com.codecool.postermediamicroservice.service.MediaService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/media")
@CrossOrigin(origins = "*")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public @ResponseBody byte[] getImage(@PathVariable String id) {
        return mediaService.getImageById(Long.parseLong(id));
    }

    @GetMapping(value = "/default-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] defaultImage() { return mediaService.getDefaultImage(); }
}
