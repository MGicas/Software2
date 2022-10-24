package com.mipresupuesto.personalbudget.infrastructure.data.specification;

public interface Specification <S>{
	
	boolean isSatisfied(S object);

    default Specification<S> and(Specification<S>... specifications) {
        return new AndSpecification(specifications);
    }

    default Specification<S> or(Specification<S>... specifications) {
        return new OrSpecification(specifications);
    }

    default Specification<S> not(Specification<S> specification) {
        return new NotSpecification(specification);
    }
    
}
