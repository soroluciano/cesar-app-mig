package admin.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "payPlan")
public class PayPlan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<PayPlanFee> payPlanFeeList;

	public PayPlan() {}
	
	public PayPlan(LocalDate startDate, List<PayPlanFee> payPlanFeeList,LocalDate endDate) {
		this.startDate = startDate;
		this.payPlanFeeList = payPlanFeeList;
		this.endDate = endDate;
		
		
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public List<PayPlanFee> getPayPlanFeeList() {
		return this.payPlanFeeList;
	}

	public void setPayPlanFeeList(List<PayPlanFee> payPlanFeeList) {
		this.payPlanFeeList = payPlanFeeList;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
