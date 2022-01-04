package com.xantrix.webapp.service;

import java.util.List;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArticoliServiceImpl implements ArticoliService {

    @Autowired
    ArticoliRepository articoliRepository;


    @Override
    public Iterable<Articoli> selTutti() {
        return articoliRepository.findAll();
    }

    @Override
    public List<Articoli> selByDescrizione(String descrizione) {
        return articoliRepository.findByDescrizioneLike(descrizione);
    }

    @Override
    public List<Articoli> selByDescrizione(String descrizione, Pageable pageable) {
        return articoliRepository.findByDescrizioneLike(descrizione, pageable);
    }

    @Override
    public Articoli selByCodArt(String codArt) {
        return articoliRepository.findByCodArt(codArt);
    }

    @Override
    @Transactional
    public void delArticolo(Articoli articolo) {
        articoliRepository.delete(articolo);
        
    }

    @Override
    @Transactional
    public void insArticolo(Articoli articolo) {
        articoliRepository.save(articolo);
    }
    
}
