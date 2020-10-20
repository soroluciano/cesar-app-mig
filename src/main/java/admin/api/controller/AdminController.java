package admin.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import admin.api.model.Employee;
import admin.api.model.dto.CustomerPostDto;
import admin.api.services.CustomerServiceRest;

	
@RestController
public class AdminController {
	
	@Autowired
	CustomerServiceRest customerServiceRest;

	public AdminController(CustomerServiceRest customerServiceRest) {

		this.customerServiceRest = customerServiceRest;
	}
	@RequestMapping("/saveCustomer")
	//@PostMapping
	public void saveCustomer(@Valid @RequestBody CustomerPostDto dto) {
		 this.customerServiceRest.save(dto);
	}
	@RequestMapping("/findCustomers")
	@ResponseBody
    public List<Employee> findByLastName(@RequestBody CustomerPostDto dto){
		return this.customerServiceRest.findByLastName(dto);
	}

}
