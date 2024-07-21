package com.deafio.apiLinkAggregator.repository;

import com.deafio.apiLinkAggregator.domain.links.Links;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository <Links, Long> {
}
