package com.xantrix.webapp.service;

import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.repository.BarcodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BarcodeServiceImpl implements BarcodeService {

    @Autowired
    BarcodeRepository barcodeRepository;

    @Override
    public Barcode selByBarcode(String barcode) {
        return barcodeRepository.findByBarcode(barcode);
    }
   


}