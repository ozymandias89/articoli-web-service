package com.xantrix.webapp.repository;

import com.xantrix.webapp.entities.Barcode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeRepository extends JpaRepository<Barcode, Integer> {
    
    Barcode findByBarcode(String barcode);

}