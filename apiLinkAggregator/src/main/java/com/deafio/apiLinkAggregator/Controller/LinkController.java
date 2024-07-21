package com.deafio.apiLinkAggregator.Controller;

import com.deafio.apiLinkAggregator.Service.LinkServiceImpl;
import com.deafio.apiLinkAggregator.domain.links.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkServiceImpl linkService;

    @PostMapping
    public ResponseEntity<Links> createLink(@RequestBody Links link) {
        return ResponseEntity.ok(linkService.createLink(link));
    }

    @GetMapping
    public ResponseEntity<List<Links>> getAllLinks() {
        return ResponseEntity.ok(linkService.getAllLinks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Links> updateLink(@PathVariable Long id, @RequestBody Links link) {
        return ResponseEntity.ok(linkService.updateLink(id, link));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLink(@PathVariable Long id) {
        linkService.deleteLink(id);
        return ResponseEntity.noContent().build();
    }
}