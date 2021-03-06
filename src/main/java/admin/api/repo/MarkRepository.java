package admin.api.repo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import admin.api.model.Mark;

@Repository
public interface MarkRepository extends MongoRepository<Mark, Serializable> {

}
