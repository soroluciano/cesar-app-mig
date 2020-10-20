package admin.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Document(collection = "sell")
public class Sell implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private List<Product> productList;
	private Seller seller;
	private PayPlan payPlan;
	
	
	public Sell() {	}
	
	public Sell(List<Product> productList, Seller seller) {
		this.productList = productList;
		this.seller = seller;
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public PayPlan getPayPlan() {
		return payPlan;
	}

	public void setPayPlan(PayPlan payPlan) {
		this.payPlan = payPlan;
	}
}
