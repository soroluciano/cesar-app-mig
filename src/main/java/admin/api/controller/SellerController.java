package admin.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.api.model.Seller;
import admin.api.services.SellerServiceRest;

public class SellerController {

	@Autowired
	SellerServiceRest sellerServiceRest;

	public SellerController(SellerServiceRest sellerServiceRest) {

		this.sellerServiceRest = sellerServiceRest;
	}
	@CrossOrigin()
	@RequestMapping("/saveSeller")
	@PostMapping
	public void saveSeller(@Valid @RequestBody Seller seller) {
		 this.sellerServiceRest.insertSeller(seller);
	}
	@CrossOrigin()
	@GetMapping(path="/findById/{id}")
	@ResponseBody
    public Seller findById(@PathVariable("id") String id){
	
		return this.sellerServiceRest.findById(id);
	}
	@CrossOrigin()
	@PutMapping(path= {"/updateSeller/{id}"})
	@ResponseBody
    public String updateSeller(@PathVariable("id") String id,@RequestBody Seller seller){
		 
		return this.sellerServiceRest.updateSeller(seller);
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllSellers")
    public  Map<String, List<Seller>> findAllSellers(){
		List<Seller> res = this.sellerServiceRest.findAllSellers();
		Map<String, List<Seller>> map = new HashMap<String, List<Seller>>();
		map.put("sellers", res);
		return map;
	}
	
	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteSeller/{id}" })
    public Boolean deleteSeller(@PathVariable("id") String id){
		this.sellerServiceRest.delete(id);
		
		return Boolean.TRUE;
	}
	
	
}
