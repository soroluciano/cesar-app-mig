package admin.api.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Serializable> {
	

    public Client findByFirstName(String firstName);
    public List<Client> findByLastName(String lastName);
   public Document findByDni(String firstName);
}
