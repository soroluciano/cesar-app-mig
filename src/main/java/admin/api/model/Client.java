package admin.api.model;



import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "client")
public class Client implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6403216684565776377L;

	@Id
    private String id;
	private Integer number;
	private String firstName;
    private String lastName;
    private String email;
	private String celNumber;
    private String phoneNumber;
    private String zone;
    private ArrayList<PayPlan> payPlanList;
    //PayPlan payPlan;
    private String dni;
    @Field("localization")
    //@DBRef
    public Localization localization;

    
    public Client() {}

    public Client(String firstName,
    		String lastName,
    		String email,
    		Localization localization, 
    		String zone,
    		String dni,
    		Integer number,
    		String celNumber) {
    	
    	this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.localization = localization;
        this.celNumber =celNumber;
        this.zone = zone;
        this.dni = dni;
        this.number = number;
        
    }


    public String getId() {
 		return id;
 	}

 	public void setId(String id) {
 		this.id = id;
 	}

 	public String getFirstName() {
 		return firstName;
 	}

 	public void setFirstName(String firstName) {
 		this.firstName = firstName;
 	}

 	public String getLastName() {
 		return lastName;
 	}

 	public void setLastName(String lastName) {
 		this.lastName = lastName;
 	}

 	public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}

 	public Localization getLocalization() {
 		return localization;
 	}

 	public void setLocalization(Localization localization) {
 		this.localization = localization;
 	}
 	public String getCelNumber() {
		return celNumber;
	}

	public void setCelNumber(String celNumber) {
		this.celNumber = celNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}