package com.mipresupuesto.personalbudget.crosscutting.exception.data;

import com.mipresupuesto.personalbudget.crosscutting.exc.BudgetCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.enumeration.LayerException;

public class ApplicationCustomException extends BudgetCustomException{

	private static final long serialVersionUID = 3601263231326252967L;
	

	protected ApplicationCustomException(String userMessage, String technicalMessage,
			Throwable rootException) {
		super(userMessage, LayerException.APLICATION, technicalMessage, rootException);
		
	}
	
	public static final BudgetCustomException CreateUserException(final String userMessage) {
        return new ApplicationCustomException(userMessage, userMessage, new Exception());
    }
    
    public static final BudgetCustomException CreateTechnicalException(final String technicalMessage) {
        return new ApplicationCustomException(null, technicalMessage, new Exception());
        
    }
    public static final BudgetCustomException CreateTechnicalException(final String technicalMessage, final Exception rootException ) {
        return new ApplicationCustomException(null, technicalMessage,rootException);
        
    }
    public static final BudgetCustomException Create(final String userMessage, final String technicalMessage) {
        return new ApplicationCustomException(userMessage,technicalMessage, new Exception());
        
    }
    public static final BudgetCustomException Create(final String userMessage, final String technicalMessage, final Exception rootException ) {
        return new ApplicationCustomException(userMessage, technicalMessage, rootException);
    }
	

}
