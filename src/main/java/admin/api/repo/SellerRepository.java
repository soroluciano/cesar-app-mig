package admin.api.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Seller;

@Repository
public interface SellerRepository extends MongoRepository<Seller, Serializable> {
	

    public Seller findByFirstName(String firstName);
    public List<Seller> findByLastName(String lastName);
    public Seller findByUserEmail(String email);
}
