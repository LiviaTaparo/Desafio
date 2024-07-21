package com.deafio.apiLinkAggregator.Service;

import com.deafio.apiLinkAggregator.domain.links.Links;
import com.deafio.apiLinkAggregator.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceLink{
    Links createLink(Links link);
    List<Links> getAllLinks();
    Links updateLink(Long id, Links link);
    void deleteLink(Long id);
}


