package com.tradespeople.utils;

public class ApiConstants {

	public static class Enums {
		
		public static enum BaseStatus{
			Active("0"), Passive("1");
			BaseStatus(String statusCode) {
			}
		}
		public static enum ResponseErrorCode {
			NoError("0"), NotSupportedParameter("1");
			ResponseErrorCode(String errorCode) {
			}
		}

		public static enum ShopCategoryStatus {
			Active("0"), Passive("1");
			ShopCategoryStatus(String statusCode) {
			}
		}

		public static enum ResponseStatus {
			SuccessFull("0"), Fail("1");
			ResponseStatus(String errorCode) {
			}
		}
	}
}
