package admin.api.repo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Sell;

@Repository
public interface SellRepository extends MongoRepository<Sell, Serializable> {
	
	public Sell findById(String id);
//    public Sell findByFirstName(String firstName);
//    public List<Sell> findByLastName(String lastName);
//   public Document findByDni(String firstName);
}
