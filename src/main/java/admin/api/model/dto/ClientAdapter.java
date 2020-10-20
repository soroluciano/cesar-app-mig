//package admin.api.model.dto;
//
//
//
//import java.util.List;
//
//import org.bson.Document;
//
//import admin.api.adapter.MongoAdapter;
//
//public class ClientAdapter implements MongoAdapter<ClientPostDto> {
//
//
//	
//	
//	//private MongoAuthorAdapter authorAdapter;
//
//	
////	public  static final Employee transform(EmployeePostDto dto) {
////		
////		employee = new Employee();
////		employee.setFirstName(dto.getFirstName()); 
////		employee.setLastName(dto.getLastName()); 
////		employee.setEmail(dto.getEmail());
////		employee.setId(dto.getId());
////		employee.setLocalizations(dto.getLocalizations());
////		
////	//	System.out.println(employee.getLocalization().getMapsCordenadas());
////	
////		return employee;
////	}
//
//
//
////	@Override
////	public Employee toPOJO(Document doc) {
////		
////		
////		Employee employee = new Employee();
////		employee.setFirstName(dto.getFirstName()); 
////		employee.setLastName(dto.getLastName()); 
////		employee.setEmail(dto.getEmail());
////		employee.setId(dto.getId());
////		employee.setLocalizations(dto.getLocalizations());
////		
////		
////		return null;
////	}
//
//	@Override
//	public final Document toDocument(ClientPostDto pojo) {
//		// TODO Auto-generated method stub
//		
//		Document client = new Document( "id", pojo.getId())
//				.append("firstName", pojo.getFirstName())
//				.append("lastName", pojo.getLastName())
//				.append("email", pojo.getEmail())
//				.append("localizations", pojo.getLocalizations());
//
//		return client;
//	
//	}
//
//	@Override
//	public ClientPostDto toPOJO(Document doc) {
//		
//
//		ClientPostDto client = new ClientPostDto(null, null, null, null, null);
//		client.setFirstName(doc.getString("firstName")); 
//		client.setLastName(doc.getString("lastName")); 
//		client.setEmail(doc.getString("email")); 
//		client.setId(doc.getString("id")); 
//		
//		
//		client.setLocalizations( (List<Localization>) doc.get( "localizations" ) );
//		
//		return client;
//	}
//	
////	@Override
////	public Employee toPOJO(EmployeePostDto pojo){
////
////		Employee employee = new Employee();
////		employee.setFirstName(employee.getFirstName()); 
////		employee.setLastName(employee.getLastName()); 
////		employee.setEmail(employee.getEmail()); 
////		employee.setId(employee.getId()); 
////		
////		
////		employee.setLocalizations(pojo.getLocalizations() );
////		
////		return employee;
////		
////	}
//	
//	
//}
