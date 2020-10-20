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

import admin.api.model.Client;
import admin.api.services.ClientServiceRest;

	
@RestController
public class ClientController {
	
	@Autowired
	ClientServiceRest clientServiceRest;

	public ClientController(ClientServiceRest clientServiceRest) {

		this.clientServiceRest = clientServiceRest;
	}
	@CrossOrigin()
	@RequestMapping("/saveClient")
	@PostMapping
	public void saveClient(@Valid @RequestBody Client client) {
		
		 this.clientServiceRest.insertClient(client);
	}
	@CrossOrigin()
	@GetMapping(path="/findById/{id}")
	@ResponseBody
    public Client findById(@PathVariable("id") String id){
	
		return this.clientServiceRest.findById(id);
	}
	@CrossOrigin()
	@PutMapping(path= {"/updateClient/{id}"})
	@ResponseBody
    public String updateClient(@PathVariable("id") String id,@RequestBody Client client){
		 
		return this.clientServiceRest.updateClient(client);
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/findAllClients")
    public  Map<String, List<Client>> findAllClients(){
		List<Client> res = this.clientServiceRest.findAllClients();
		Map<String, List<Client>> map = new HashMap<String, List<Client>>();
		map.put("clientes", res);
		return map;
	}
	
	@CrossOrigin()
	@ResponseBody
	@GetMapping("/getNewClientNumber")
    public  String getNewClientNumber(){
		String num = this.clientServiceRest.getNewClientNumber();
		
		return num;
	}
	
	
	@CrossOrigin()
	@ResponseBody	
	@DeleteMapping(path = { "/deleteClient/{id}" })
    public Boolean deleteClient(@PathVariable("id") String id){
		this.clientServiceRest.delete(id);
		
		return Boolean.TRUE;
	}
}
