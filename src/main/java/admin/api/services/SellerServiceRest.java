package admin.api.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import admin.api.model.Seller;
import admin.api.repo.SellRepository;

public class SellerServiceRest {

	@Autowired
	SellRepository sellRepository;
	
	
	
	public void insertSeller(@Valid Seller seller) {
		// TODO Auto-generated method stub
		
	}

	public Seller findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateSeller(Seller seller) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Seller> findAllSellers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
