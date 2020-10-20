package admin.api.model.dto;

import admin.api.model.Employee;

public class CustomerPostToT {

	private static Employee customer;
	//private CustomerPostDto customerPostDto;
	
	public  static final Employee transform(CustomerPostDto dto) {
		
		customer = new Employee();
		customer.firstName = dto.getFirstName();
		customer.lastName = dto.getLastName();
		customer.id = dto.getId();
		
		return customer;
	}
	
	
}
