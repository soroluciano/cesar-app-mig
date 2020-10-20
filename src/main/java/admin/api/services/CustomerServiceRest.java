package admin.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import admin.api.model.Employee;
import admin.api.model.Employee;
import admin.api.model.dto.CustomerPostDto;
import admin.api.model.dto.CustomerPostToT;
import admin.api.repo.CustomerRepository;

@Service
public class CustomerServiceRest {
	
	private final CustomerRepository customerRepository;
	
	public CustomerServiceRest (CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void save(CustomerPostDto dto) {
	
	
		this.customerRepository.save(CustomerPostToT.transform(dto));
//	return this.conciliacionRepository.check(dto.getEnte(), dto.getCuenta(), dto.getFecha(), dto.getMonto(), dto.getUser());
	}
	
    public List<Employee> findByLastName(CustomerPostDto dto){
		return this.customerRepository.findByLastName(dto.getLastName());
	}
    
    
	
}
