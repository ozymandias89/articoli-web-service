package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.xantrix.webapp.entities.Articoli;
import org.springframework.data.domain.Pageable;

/**
 * Articoli Repository implementata seguendo pedissequamente i test 
 */
public interface ArticoliRepository extends PagingAndSortingRepository<Articoli, Long> {
    List<Articoli> findByDescrizioneLike (String descrizione);

    List<Articoli> findByDescrizioneLike (String descrizione, Pageable page);

    Articoli findByCodArt (String codArt);
}
