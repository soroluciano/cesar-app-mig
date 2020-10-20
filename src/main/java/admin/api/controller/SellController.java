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
import org.springframework.web.bind.annotation.RestController;

import admin.api.model.Sell;
import admin.api.services.SellServiceRest;

	
@RestController
public class SellController {
	
	@Autowired
	SellServiceRest sellServiceRest;

	public SellController(SellServiceRest sellServiceRest) {

		this.sellServiceRest = sellServiceRest;
	}
	@CrossOrigin()
	@RequestMapping("/saveSell")
	@PostMapping
	public void saveSell(@Valid @RequestBody Sell sell) {
		 this.sellServiceRest.insertSell(sell);
	}
	@CrossOrigin()
	@GetMapping(path="/findBySellId/{id}")
	@ResponseBody
    public Sell findById(@PathVariable("id") String id){
	
		return this.sellServiceRest.findById(id);
	}
	@CrossOrigin()
	@PutMapping(path= {"/updateSell/{id}"})
	@ResponseBody
    public String updateSell(@PathVariable("id") String id,@RequestBody Sell sell){
		 
		return this.sellServiceRest.updateSell(sell);
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllSell")
    public  Map<String, List<Sell>> findAllSells(){
		List<Sell> res = this.sellServiceRest.findAllSell();
		Map<String, List<Sell>> map = new HashMap<String, List<Sell>>();
		map.put("sell", res);
		return map;
	}
	
	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteSell/{id}" })
    public Boolean deleteSell(@PathVariable("id") String id){
		this.sellServiceRest.delete(id);
		
		return Boolean.TRUE;
	}
	
	
	//crea la comision para un vendedor en caso de haberse pagado la primer cuota de un plan de pago
    public void saveComision(){
		//this.sellServiceRest.delete(id);
		
		
	}
}
