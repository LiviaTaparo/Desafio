package com.deafio.apiLinkAggregator.Service;

import com.deafio.apiLinkAggregator.domain.links.Links;
import com.deafio.apiLinkAggregator.repository.LinkRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LinkServiceImpl implements ServiceLink{

    private final LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    @Transactional
    public Links createLink(Links link) {
        return linkRepository.save(link);
    }

    @Override
     public List<Links> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    @Transactional
    public Links updateLink(Long id, Links link) {
        Links existingLink = linkRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Link not found with id: " + id));
        existingLink.setTitle(link.getTitle());
        existingLink.setUrl(link.getUrl());
        existingLink.setDescription(link.getDescription());
        return linkRepository.save(existingLink);
    }

    @Override
    public void deleteLink(Long id) {
        if (!linkRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Link not found with id: " + id);
        }
        linkRepository.deleteById(id);

    }
}
