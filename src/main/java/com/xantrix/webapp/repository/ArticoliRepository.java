package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.xantrix.webapp.entities.Articoli;
import org.springframework.data.domain.Pageable;

public interface ArticoliRepository extends PagingAndSortingRepository<Articoli, Long>
{
	List<Articoli> findByDescrizioneLike(String descrizione);

	List<Articoli> findByDescrizioneLike(String descrizione, Pageable pageable);
	
	Articoli findByCodArt(String codArt);
	
}
