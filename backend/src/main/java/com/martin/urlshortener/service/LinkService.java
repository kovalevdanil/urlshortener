package com.martin.urlshortener.service;

import com.martin.urlshortener.config.AppProperties;
import com.martin.urlshortener.model.Link;
import com.martin.urlshortener.repository.LinkRepository;
import com.martin.urlshortener.util.Hasher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    private final Integer maxShortenedSize;
    private final String baseUrl;

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository, AppProperties props) {
        this.linkRepository = linkRepository;
        this.baseUrl = props.getRedirectBaseUrl();
        this.maxShortenedSize = props.getMaxLength();
    }

    public Link createLink(String linkString){
        Link link = new Link();
        String shortened = Hasher.sha1(linkString, maxShortenedSize);

        while (linkRepository.existsByShortened(shortened)){
            shortened = Hasher.sha1(shortened, maxShortenedSize);
        }

        link.setFull(linkString);
        link.setShortened(shortened);
        link.setFullShortened(baseUrl + link.getShortened());

        return linkRepository.save(link);
    }

    public Link createIfNotExists(String linkString){
        if (!linkRepository.existsByFull(linkString)){
            return this.createLink(linkString);
        }

        return linkRepository.findByLink(linkString).stream().findFirst().orElse(null);
    }

    public List<Link> findByShortened(String shortened){
        return linkRepository.findByShortened(shortened);
    }

    public Optional<Link> findById(Long id){
        return linkRepository.findById(id);
    }
}
