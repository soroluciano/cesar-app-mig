package admin.api.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import admin.api.model.Employee;
import admin.api.model.dto.CustomerPostDto;

public interface CustomerRepository extends MongoRepository<Employee, String> {

    public Employee findByFirstName(String firstName);
    public List<Employee> findByLastName(String lastName);
	public void save(CustomerPostDto dto);

}
