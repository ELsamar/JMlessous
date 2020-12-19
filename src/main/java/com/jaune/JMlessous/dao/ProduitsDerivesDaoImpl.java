package com.jaune.JMlessous.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.ProduitsDerives;
import com.jaune.JMlessous.repository.*;

@Repository
public class ProduitsDerivesDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
		@Autowired
	private ProduitsDerivesRepository prodDRepository;
		
	public ProduitsDerives createprodDerives( ProduitsDerives prodDerives) {
		        return prodDRepository.save(prodDerives);
		    } 
	public List<ProduitsDerives> getAllprodDerives() {
        return prodDRepository.findAll();
    }
	  public ResponseEntity<ProduitsDerives> getProdById(int prodDerivesID)
		        throws ResourceNotFoundException {
		  ProduitsDerives prodDerives = prodDRepository.findById(prodDerivesID)
		          .orElseThrow(() -> new ResourceNotFoundException("produit Derivé not found for this id :: " + prodDerivesID));
		        return ResponseEntity.ok().body(prodDerives);
		    }
	  public Map<String, Boolean> deleteProd(int prodId)
		         throws ResourceNotFoundException {
		  ProduitsDerives prodDerives= prodDRepository.findById(prodId)
		       .orElseThrow(() -> new ResourceNotFoundException("produit Derivé not found for this id :: " + prodId));

		  prodDRepository.delete(prodDerives);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
	 
		public List<String> Offres() {
		      Document doc;
		      List<String> oo= new ArrayList<>();

				try {
					doc = Jsoup.connect("https://www.marketscreener.com/analysis/shares-strategies//?language=Java").get();
					
					String selecter="#zbCenter > div > table:nth-child(2) > tbody > tr:nth-child(3) > td:nth-child(1) > div.tabElemNoBor.resp.overfH > div.std_txt.th_inner > table > tbody>tr";
		      Elements coh = doc.select(selecter); 
		      for (Element e:coh) {
						final String type = e.select("td.std_txtB.ptop15.pbottom15.pright10.top.lineh_1_7 >table > tbody > tr:nth-child(1) > td:nth-child(2)").text();
						final String name = e.select("td.std_txtB.ptop15.pbottom15.pright20.lineh_1_7 > a > div").text();
						oo.add("Type d'offre: " +name);
						oo.add("Entreprise : " +type);
		      }			
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	return oo;
		}
}

