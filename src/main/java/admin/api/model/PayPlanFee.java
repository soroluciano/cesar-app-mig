package admin.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author lsoro
 * Cuota
 */
@JsonIgnoreProperties
@Document(collection = "payPlanFee")
public class PayPlanFee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Integer sequence;
	private LocalDate dateToPay;
	private LocalDate datePayed;
	private BigDecimal moneyFee;
	private FeeStatus status;
	
	
	
	//@DBRef
	private List<Payment> payments;
	
	public PayPlanFee() {}

	public PayPlanFee(Integer sequence, LocalDate dateToPay, LocalDate datePayed, BigDecimal moneyFee, FeeStatus status,
			List<Payment> payments) {
		this.setSequence(sequence);
		this.datePayed = datePayed;
		this.dateToPay = dateToPay;
		this.moneyFee = moneyFee;
		this.status = status;
		this.payments = payments;

	}
	
	
	public LocalDate getDateToPay() {
		return dateToPay;
	}
	
	public void setDateToPay(LocalDate dateToPay) {
		this.dateToPay = dateToPay;
	}
	
	public LocalDate getDatePayed() {
		return datePayed;
	}
	
	public void setDatePayed(LocalDate datePayed) {
		this.datePayed = datePayed;
	}
	
	public BigDecimal getMoneyFee() {
		return moneyFee;
	}
	
	public void setMoneyFee(BigDecimal moneyFee) {
		this.moneyFee = moneyFee;
	}
	
	public FeeStatus getStatus() {
		return status;
	}
	
	public void setStatus(FeeStatus status) {
		this.status = status;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}
	
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
}
