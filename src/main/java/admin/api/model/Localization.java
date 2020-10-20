package admin.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "localization")
public class Localization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@NotNull
	private String id;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private String direccion;

	public Localization() {}
	
	
	public Localization(BigDecimal latitud, BigDecimal longitud, String direccion) 	
	{
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setDireccion(direccion);
	}
	
	public String getId() {
		return id;
	}
	
	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setId(String id) {
		this.id = id;
	}


	public BigDecimal getLatitud() {
		return latitud;
	}


	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}


	public BigDecimal getLongitud() {
		return longitud;
	}


	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	


}
