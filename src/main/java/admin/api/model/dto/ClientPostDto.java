package admin.api.model.dto;

import java.io.Serializable;
import java.util.List;

import admin.api.model.Localization;
import admin.api.model.PayPlan;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPostDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Localization localization;
   // private String celNumber;
    private String phoneNumber;
    private String zone;
    private PayPlan payPlan;
    private String dni;
}
