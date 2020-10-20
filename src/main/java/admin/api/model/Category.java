package admin.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "category")
public class Category implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String nombre;
	

	public Category() {

	}
	
	
	public Category(String nombre) {
		
		
		this.nombre = nombre;
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
