package admin.api.services;


import org.springframework.stereotype.Service;

import admin.api.model.dto.CustomerPostDto;
import admin.api.repo.AdminRepository;
import admin.api.repo.CustomerRepository;

@Service
public class ConciliacionServiceRest/* implements ConciliacionService*/{
	
	//private final AdminRepository conciliacionRepository;
	private final CustomerRepository customerRepository;
	
//	public ConciliacionServiceRest(AdminRepository conciliacionRepository) {
//		this.conciliacionRepository = conciliacionRepository;
//	}
	public ConciliacionServiceRest(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	
//	public String check(ConciliacionPostDto dto) {
//		
////		return this.conciliacionRepository.check(dto.getEnte(), dto.getCuenta(), dto.getFecha(), dto.getMonto(), dto.getUser());
//	}

	
}
	