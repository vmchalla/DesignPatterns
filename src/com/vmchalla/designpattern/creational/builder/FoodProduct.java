package com.vmchalla.designpattern.creational.builder;

/**
 * This class has too many parameters to be set and to create a fully populated
 * consistent (no null Values and the instance variables are all private) object
 * the client needs to set these at the object instantiation. if we add all
 * those to constructor the client code can effectively miss one of the values
 * and thus break the code. the best way is to build this class incrementally
 * 
 * @author vmohanchalla
 *
 */
public class FoodProduct {

	/*
	 * Required
	 */
	private final String productId;
	private final String productType;
	private final String productName;
	/*
	 * Optional
	 */
	private final String category;
	private final String department;
	private final Boolean isAvailable;
	private final Boolean isFrozen;
	private final String soldBy;
	private final String salesUnit;
	private final Boolean isSeasonal;
	private final String nutritionalFacts;

	public String getProductId() {
		return this.productId;
	}

	public String getProductType() {
		return this.productType;
	}

	public String getProductName() {
		return this.productName;
	}

	public String getCategory() {
		return this.category;
	}

	public String getDepartment() {
		return this.department;
	}

	public Boolean getIsAvailable() {
		return this.isAvailable;
	}

	public Boolean getIsFrozen() {
		return this.isFrozen;
	}

	public String getSoldBy() {
		return this.soldBy;
	}

	public String getSalesUnit() {
		return this.salesUnit;
	}

	public Boolean getIsSeasonal() {
		return this.isSeasonal;
	}

	public String getNutritionalFacts() {
		return this.nutritionalFacts;
	}

	private FoodProduct(String productId, String productType,
			String productName, String category, String department,
			Boolean isAvailable, Boolean isFrozen, String soldBy,
			String salesUnit, Boolean isSeasonal, String nutritionalFacts) {
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.department = department;
		this.isAvailable = isAvailable;
		this.isFrozen = isFrozen;
		this.soldBy = soldBy;
		this.salesUnit = salesUnit;
		this.isSeasonal = isSeasonal;
		this.nutritionalFacts = nutritionalFacts;
	}

	public static class FoodProductBuilder {
		/*
		 * Required
		 */
		private final String productId;
		private final String productType;
		private final String productName;
		/*
		 * Optional
		 */
		private String category;
		private String department;
		private Boolean isAvailable;
		private Boolean isFrozen;
		private String soldBy;
		private String salesUnit;
		private Boolean isSeasonal;
		private String nutritionalFacts;

		public FoodProductBuilder(String productId, String productType,
				String productName) {
			this.productId = productId;
			this.productType = productType;
			this.productName = productName;
		}

		public FoodProductBuilder category(String category) {
			this.category = category;
			return this;
		}

		public FoodProductBuilder department(String department) {
			this.department = department;
			return this;
		}

		public FoodProductBuilder isAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
			return this;
		}

		public FoodProductBuilder isFrozen(boolean isFrozen) {
			this.isFrozen = isFrozen;
			return this;
		}

		public FoodProductBuilder soldBy(String soldBy) {
			this.soldBy = soldBy;
			return this;
		}

		public FoodProductBuilder saleUnit(String saleUnit) {
			this.salesUnit = saleUnit;
			return this;
		}

		public FoodProductBuilder isSeasonal(boolean isSeasonal) {
			this.isSeasonal = isSeasonal;
			return this;
		}

		public FoodProductBuilder nutritionalFacts(String nutritionalFacts) {
			this.nutritionalFacts = nutritionalFacts;
			return this;
		}

		public FoodProduct buildFoodProduct() {
			return new FoodProduct(productId, productType, productName,
					category, department, isAvailable, isFrozen, soldBy,
					salesUnit, isSeasonal, nutritionalFacts);
		}

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(productId).append("\n").append(productType).append("\n")
				.append(productName).append("\n").append(category).append("\n")
				.append(department).append("\n").append(soldBy).append("\n")
				.append(salesUnit).append("\n").append(nutritionalFacts)
				.append("\n").append("Available :").append(isAvailable)
				.append("\n").append("isFrozen ").append(isFrozen).append("\n")
				.append("isSeasonal ").append(isSeasonal);

		return sb.toString();
	}

}
