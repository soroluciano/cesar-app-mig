package admin.api;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import admin.api.model.Category;
import admin.api.model.Mark;

public final class ValidationUtils {

	
	public static boolean IsBlankOrNull(String parameter) {
		  if(!parameter.equals(null)) {
			  return true;
		  }
		return false;
	}

	public static boolean IsNull(BigDecimal parameter) {
		  if(!parameter.equals(null)) {
			  return true;
		  }
		return false;
	}
	public static boolean IsBlankOrNull(Date parameter) {
		  if(!parameter.equals(null)) {
			  return true;
		  }
		return false;
	}
	
//	public static boolean IsNull(Category category) {
//		if(!category.equals(null)) {
//			return false;
//		}
//		return true;
//	}

	public static boolean IsNull(Serializable mark) {
		if(!mark.equals(null)) {
			return false;
		}
		return true;
	}
	
}
