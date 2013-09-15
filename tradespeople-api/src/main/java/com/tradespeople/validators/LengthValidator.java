package com.tradespeople.validators;

public class LengthValidator implements IValidator {

	private String value;
	private Integer lenght;
	
	
	
	public LengthValidator(String value, Integer lenght) {
		super();
		this.value = value;
		this.lenght = lenght;
	}

	@Override
	public boolean validate() {
		if (value==null) {
			return false;
		}
		if (lenght==null) {
			return false;
		}
		
		if (lenght.equals(lenght)) {
			return true;
		}else{
			return false;
		}
	}

}
