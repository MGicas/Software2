package com.mipresupuesto.personalbudget.crosscutting.exception.messages;

public class Messages {

	public static class CreateBudgetUseCaseImpl {
		private CreateBudgetUseCaseImpl() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_CREATE_BUDGET = "There was a problem creating budget";

	}

	public static class IdValidSpecification {
		private IdValidSpecification() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_WITH_BUDGET_ID = "Year id can not be null";
		public static final String TECHNICAL_PROBLEM_WITH_PERSON_ID = "Person id can not be null";

	}
	
	public static class notDefault {
		private notDefault() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_WITH_INFO_PERSON = "That person do not have info";
		public static final String TECHNICAL_PROBLEM_WITH_INFO_YEAR = "That year do not have info";

	}
	
	public static class mandatoryValues {
		private mandatoryValues() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_FIRST_NAME = "The first name is a mandatory information";
		public static final String TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_MIDDLE_NAME = "The middle name can not be null";
		public static final String TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_ID_CARD = "The id card is a mandatory information";
		public static final String TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_LAST_NAME = "The last name is a mandatory information";

	}
	
	public static class exist {
		private exist() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_WITH_PERSON = "That person do not exist";
		public static final String TECHNICAL_PROBLEM_WITH_PERSON_INFO = "Error getting person's information";
		public static final String TECHNICAL_PROBLEM_WITH_YEAR = "That year do not exist";
		public static final String TECHNICAL_PROBLEM_WITH_YEAR_INFO = "Error getting year";
		public static final String TECHNICAL_PROBLEM_WITH_BUDGET = "That budget do not exist";
		public static final String TECHNICAL_PROBLEM_WITH_BUDGET_EXIST = "Error getting budget information";
		public static final String TECHNICAL_PROBLEM_WITH_BUDGET_INFO = "Provided budget do not have info";

	}
	public static class YearBiggerThanActual {
		private YearBiggerThanActual() {
			super();
		}

		public static final String TECHNICAL_PROBLEM_WITH_PROVIDED_NUMBER = "Year not provided";
		public static final String TECHNICAL_PROBLEM_PRIVIDED_NUMBER = "The year given is not bigger than actual";

	}
}
