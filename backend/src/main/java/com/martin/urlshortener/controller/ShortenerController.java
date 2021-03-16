package com.martin.urlshortener.controller;

import com.martin.urlshortener.model.Link;
import com.martin.urlshortener.repository.LinkRepository;
import com.martin.urlshortener.service.LinkService;
import com.martin.urlshortener.util.Encoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@RestController
@RequestMapping("/api/shorten")
public class ShortenerController {

    private final LinkService linkService;

    public ShortenerController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping
    public ResponseEntity<?> getShortenedLink(@RequestParam(name = "link") String linkString) throws Exception {
        linkString = Encoder.encode(linkString);
        Link link = linkService.createIfNotExists(linkString);

        if (link == null)
            throw new Exception("Error creating link occurred");

        return ResponseEntity.ok(link);
    }
}
