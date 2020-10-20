package admin.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;

import admin.api.model.Sell;
import admin.api.repo.SellRepository;

@Service
public class SellServiceRest {

	@Autowired
	SellRepository sellRepository;
	private MongoClient sellDb;
	
	
	public void insertSell(@Valid Sell sell) {
		sellRepository.insert(sell);
		
	}

	public Sell findById(String id) {
		return  sellRepository.findById(id);
	}

	public String updateSell(Sell sell) {
		 // sellDb = new MongoClient("localhost",27017);
//	      MongoDatabase db = sellDb.getDatabase("test");
//	      MongoCollection<Document> collection = db.getCollection("sell");
//	      Document query = new Document();
//	      query.append("_id",new ObjectId(sell.getId()));
//	      Document setData = new Document();
//    
//	      if(!IsBlankOrNull(sell.getCelNumber()))
//	    	  setData.append("cellNumber", sell.getCelNumber());
//	      if(!IsBlankOrNull(sell.getDni()))
//	    	  setData.append("dni", sell.getDni());
//	      if(!IsBlankOrNull(sell.getEmail()))
//	    	  setData.append("email", sell.getEmail());    
//	      if(sell.getNumber()!=null)
//	    	  setData.append("number", sell.getNumber());      
//	      if(!IsBlankOrNull(sell.getFirstName()))
//	    	  setData.append("firstName", sell.getFirstName());
//	      if(!IsBlankOrNull(sell.getLastName()))
//	    	  setData.append("lastName", sell.getLastName());
//	      if(sell.getPayPlanList() != null)
//	    	  setData.append("payPlanList", sell.getPayPlanList());
//	      if(!IsBlankOrNull(sell.getPhoneNumber()))
//	    	  setData.append("phoneNumber", sell.getPhoneNumber());
//	      if(!IsBlankOrNull(sell.getZone()))
//	    	  setData.append("zone", sell.getZone());
//	      if(sell.getLocalization() != null) 
//	    	  setData.append("localization",sell.getLocalization());
//	   
//	      Document update = new Document();
//	      update.append("$set", setData);
//	
//	      UpdateResult updateOne = collection.updateMany(query, update);
	  		 
	      return null;
	}

	public List<Sell> findAllSell() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
