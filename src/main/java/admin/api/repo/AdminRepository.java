package admin.api.repo;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import admin.api.model.Employee;



public interface AdminRepository extends CrudRepository<Employee, Long> {
	
//    public Customer findByFirstName(String firstName);
//    public List<Customer> findByLastName(String lastName);
//    public void save(String id , String firstName,String name);
//	@Procedure(name = "Conciliacion.check")
//    String check(Integer p_ente,  Integer p_cuenta, LocalDate p_fecha, Integer p_monto, String p_user);
}