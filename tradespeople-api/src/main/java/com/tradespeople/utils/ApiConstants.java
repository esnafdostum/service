package com.tradespeople.utils;

public class ApiConstants {

	public static class Enums {

		public static enum BaseStatus {
			Active("0"), Passive("1");
			private String statusCode;
			BaseStatus(String statusCode) {
				this.statusCode = statusCode;
			}
			public Byte getValue() {
				return Byte.valueOf(statusCode);
			}
		}
		
		public static enum LogSeverity{
			ERROR,DEBUG,INFO
		}
		
		public static enum LogOperation{
			LOGIN,USERCREATE,USERUPDATE
		}
		
		public static enum UserType{
			ADMIN,NORMAL_USER
		}
		
		public static enum SearchType{
			SHOP
		}


		public static enum ResponseErrorCode {
			NoError("0"), NotSupportedParameter("1");
			private String errorCode;
			ResponseErrorCode(String errorCode) {
				this.errorCode = errorCode;
			}
			public Integer getValue() {
				return Integer.valueOf(errorCode);
			}
		}

		public static enum ShopCategoryStatus {
			Active("0"), Passive("1");
			private String statusCode;
			ShopCategoryStatus(String statusCode) {
				this.statusCode = statusCode;
			}
			public Byte getValue() {
				return Byte.valueOf(statusCode);
			}
		}

		public static enum ResponseStatus {
			SuccessFull("0"), Fail("1");
			private String errorCode;

			ResponseStatus(String errorCode) {
				this.errorCode = errorCode;
			}
			public Integer getValue() {
				return Integer.valueOf(errorCode);
			}
		}
	}
}
