package com.tradespeople.validators;

public class RequiredStringValidator implements IValidator {

	public String value;
	
	public RequiredStringValidator(String value){
		this.value=value;
	}
	
	@Override
	public boolean validate() {
		if (value==null) {
			return false;
		}
		if (value.trim().length()==0) {
			return false;
		}
		return true;
	}

}
