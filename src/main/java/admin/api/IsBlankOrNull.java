package admin.api;

import org.apache.commons.validator.GenericValidator;

public class  IsBlankOrNull extends GenericValidator{


	public Boolean  IsBlankOrNull(String string) {
		
		Boolean res = Boolean.TRUE;
		if(!string.equals(null)) {
			res =  Boolean.FALSE;
		}
		if(!"".contentEquals(string.toString().trim())) {
			res = Boolean.FALSE;
		}
			
		return res;
		
	}


}
