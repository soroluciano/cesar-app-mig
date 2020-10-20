package admin.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "payment")
public class Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String PaymentType;
	private BigDecimal amount;
	private Date creationDate;
	private Integer sequence;
	
	public Payment() {}

	public Payment(String id, String paymentType, BigDecimal amount, Date creationDateTime) {
		this.id = id;
		this.PaymentType = paymentType;
		this.setAmount(amount);
		this.creationDate = creationDateTime;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPaymentType() {
		return PaymentType;
	}


	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}


	public Date getCreationDateTime() {
		return creationDate;
	}


	public void setCreationDateTime(Date creationDateTime) {
		this.creationDate = creationDateTime;
	}

	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	
}
