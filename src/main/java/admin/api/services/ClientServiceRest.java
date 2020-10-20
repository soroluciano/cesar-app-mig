package admin.api.services;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.validator.GenericValidator;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.UpdateResult;

import admin.api.model.Client;
import admin.api.model.Localization;
import admin.api.model.Mark;
import admin.api.repo.ClientRepository;

@Service
public class ClientServiceRest {
	
//	private MongoTemplate mongoTemplate;
	private Logger logger = LoggerFactory.getLogger(ClientServiceRest.class);
	@Autowired
	ClientRepository clientRepository;
//	@Autowired
//	public void ClientRepository(MongoTemplate mongoTemplate) {
//		
//	}
	
	//private final Logger logger = LoggerFactory.logger(ClientServiceRest.class);
	private MongoClient clientDb;

	public void insertClient(Client client) {

		clientRepository.insert(client);
	}
	
	public Client findByFirstName(String firstName) {
		return clientRepository.findByFirstName(firstName);
	}
	
	public Client findById(String id) {
		 Optional<Client> cli = clientRepository.findById(id);
		 Client client = (Client)cli.get();
		 return client;
	}
	
	
	public List<Client> findAllClients(){

		return clientRepository.findAll();
	}
	public String updateClient(Client client) {

//		Optional<Mark> markById = clientRepository.findById(mark.getId());
//		Mark updateMark = (Mark)markById.get();
//		updateMark.setNombre(mark.getNombre());
//
		Client save = clientRepository.save(client);
		return save.getId();
//		
//		
//		return upMark.getId();
	}
//	public String updateClient(Client client) {
//		
//		  clientDb = new MongoClient("localhost",27017);
//	      MongoDatabase db = clientDb.getDatabase("test");
//	      MongoCollection<Document> collection = db.getCollection("client");
//	      Document query = new Document();
//	      query.append("_id",new ObjectId(client.getId()));
//	      Document setData = new Document();
//    
//	      if(!IsBlankOrNull(client.getCelNumber()))
//	    	  setData.append("cellNumber", client.getCelNumber());
//	      if(!IsBlankOrNull(client.getDni()))
//	    	  setData.append("dni", client.getDni());
//	      if(!IsBlankOrNull(client.getEmail()))
//	    	  setData.append("email", client.getEmail());    
//	      if(client.getNumber()!=null)
//	    	  setData.append("number", client.getNumber());      
//	      if(!IsBlankOrNull(client.getFirstName()))
//	    	  setData.append("firstName", client.getFirstName());
//	      if(!IsBlankOrNull(client.getLastName()))
//	    	  setData.append("lastName", client.getLastName());
//	      if(!IsBlankOrNull(client.getPhoneNumber()))
//	    	  setData.append("phoneNumber", client.getPhoneNumber());
//	      if(!IsBlankOrNull(client.getZone()))
//	    	  setData.append("zone", client.getZone());
//	      if(client.getLocalization() != null) 
//	    	  setData.append("localization",client.getLocalization());
//	   
//	      Document update = new Document();
//	      update.append("$set", setData);
//	
//	      UpdateResult updateOne = collection.updateMany(query, update);
//	  		 
//	      return updateOne.toString();
//		
//	}
//	public String updateMark(Mark mark) {
//		Optional<Mark> markById = markRepository.findById(mark.getId());
//		Mark updateMark = (Mark)markById.get();
//		updateMark.setNombre(mark.getNombre());
//
//		Mark upMark = markRepository.save(updateMark);
//		
//		
//		return upMark.getId();
//	}

	private boolean IsBlankOrNull(String celNumber) {
		return  GenericValidator.isBlankOrNull(celNumber);
		
	}

	public void delete(String id) {
		clientRepository.deleteById(id);
		
	}

	public String getNewClientNumber() {

		clientDb = new MongoClient("localhost", 27017);
		MongoDatabase db = clientDb.getDatabase("test");
		MongoCollection<Document> collection = db.getCollection("client");

		Document first = collection.aggregate(Arrays.asList(Aggregates.sort(Sorts.descending("number")))).first();

		Integer integer = first.getInteger("number") + 1;

		logger.info("new client number:"+integer.toString());
		return integer.toString();
	}

	
}
