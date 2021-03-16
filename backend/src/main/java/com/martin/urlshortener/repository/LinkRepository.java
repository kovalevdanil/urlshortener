package com.martin.urlshortener.repository;

import com.martin.urlshortener.model.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class LinkRepository {
    private final MongoTemplate template;

    @Autowired
    public LinkRepository(MongoTemplate template) {
        this.template = template;
    }

    public List<Link> findAll(){
        return template.findAll(Link.class);
    }

    public Optional<Link> findById(Long id){
        return Optional.ofNullable(template.findOne(new Query(where("id").is(id)), Link.class));
    }

    public List<Link> findByLink(String link){
        return template.find(new Query(where("full").is(link)), Link.class);
    }

    public List<Link> findByShortened(String shortened){
        return template.find(new Query(where("shortened").is(shortened)), Link.class);
    }

    public Link save(Link link){
        return template.save(link);
    }

    public boolean existsByFull(String fullLink){
        return template.exists(new Query(where("full").is(fullLink)), Link.class);
    }

    public boolean existsByShortened(String shortened){
        return template.exists(new Query(where("shortened").is(shortened)), Link.class);
    }
}
