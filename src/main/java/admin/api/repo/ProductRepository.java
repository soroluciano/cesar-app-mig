package admin.api.repo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Serializable> {
	

//    public Sell findByFirstName(String firstName);
 //   public List<Sell> findByCategoryId(String id);
//   public Document findByDni(String firstName);
}
