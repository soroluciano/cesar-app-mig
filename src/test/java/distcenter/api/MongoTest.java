package distcenter.api;

import org.bson.Document;
import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import admin.api.model.PayPlan;

public class MongoTest {
	
//	@Override
//    public void afterTestExecution(ExtensionContext context) throws Exception {
//        commit();
//        rollback();
//    }


//	@Test
//	 void testUpdate(){
//	  MongoClient client = new MongoClient("localhost",27017);
//      MongoDatabase db = client.getDatabase("test");
//      MongoCollection<Document> collection = db.getCollection("client");
//      Document query = new Document();
//      query.append("_id","5d54be33ae6a313884e8d597");
//      Document setData = new Document();
//      setData.append("zone", 1).append("1", 125);
//      Document update = new Document();
//      update.append("$set", setData);
//      //To update single Document  
//      collection.updateOne(query, update);
//     
//	}
	
	@Test
	 void testCreatePayPlan(){
	
		PayPlan p = new PayPlan();
		

	
//	  MongoClient client = new MongoClient("localhost",27017);
//     MongoDatabase db = client.getDatabase("test");
//     MongoCollection<Document> collection = db.getCollection("client");
//     Document query = new Document();
//     query.append("_id","5d54be33ae6a313884e8d597");
//     Document setData = new Document();
//     setData.append("zone", 1).append("1", 125);
//     Document update = new Document();
//     update.append("$set", setData);
//     //To update single Document  
//     collection.updateOne(query, update);
    
		
		
		
	}
}
