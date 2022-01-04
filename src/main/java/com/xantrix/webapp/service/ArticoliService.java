package com.xantrix.webapp.service;

import java.util.List;

import com.xantrix.webapp.entities.Articoli;

import org.springframework.data.domain.Pageable;

public interface ArticoliService {
    public Iterable<Articoli> selTutti();

    public List<Articoli> selByDescrizione(String descrizione);

    public List<Articoli> selByDescrizione(String descrizione, Pageable pageable);

    public Articoli selByCodArt(String codArt);

    public void delArticolo(Articoli articolo);

    public void insArticolo(Articoli articolo);
}
