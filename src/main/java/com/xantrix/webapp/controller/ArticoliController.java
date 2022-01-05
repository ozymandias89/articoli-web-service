package com.xantrix.webapp.controller;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.service.BarcodeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xantrix.webapp.exception.NotFoundException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/articoli")
public class ArticoliController {
    private static final Logger logger = LoggerFactory.getLogger(ArticoliController.class);

    @Autowired
    private BarcodeService barcodeService;


    @RequestMapping(value = "/cerca/ean/{barcode}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Articoli> listArtByEan(@PathVariable("barcode") String barcode) throws NotFoundException{
        
        logger.info("****** Otteniamo l'articolo con barcode " + barcode + " *******");

        Articoli articolo;
        Barcode ean =  barcodeService.selByBarcode(barcode);
           
        if (ean == null)
		{
			String ErrMsg = String.format("Il barcode %s non è stato trovato!", barcode);
			
			logger.warn(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
		}
		else
			articolo = ean.getArticolo();

		return new ResponseEntity<Articoli>(articolo, HttpStatus.OK);

    }

}