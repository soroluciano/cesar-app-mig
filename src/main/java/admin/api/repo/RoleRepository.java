package admin.api.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
