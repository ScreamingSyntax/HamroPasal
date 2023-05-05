package model;

public class Product {
	String productName;
	String productQuantity;
	String productPrice;
	String productImagePath;
	
	public Product(String productName,String productQuantity, String productPrice,String productImagePath) {
		this.productName=productName;
		this.productQuantity=productQuantity;
		this.productPrice=productPrice;
		this.productImagePath=productImagePath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	
	
}
