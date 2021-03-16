package com.martin.urlshortener.controller;

import com.martin.urlshortener.exception.ResourceNotFoundException;
import com.martin.urlshortener.model.Link;
import com.martin.urlshortener.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/fwd")
public class ForwardController {

    private final LinkService linkService;

    public ForwardController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{to}")
    public void forwardTo(@PathVariable String to, HttpServletResponse response) throws ResourceNotFoundException, IOException {
        Link link = linkService.findByShortened(to).stream().findFirst().orElseThrow(ResourceNotFoundException::new);
        response.sendRedirect(link.getFull());
    }
}
