package com.mipresupuesto.personalbudget.application.specification;

public class AndSpecification <T> extends CompositeSpecification<T>{
	
	private final Specification <T> left;
	private final Specification <T> right;
	 
	public AndSpecification(Specification<T> pleft, Specification<T> pright) {
		this.left= pleft;
		this.right= pright;
	}
	
	public boolean isSatisfiedBy(T t) {
		return left.isSatisfiedBy(t) && right.isSatisfiedBy(t);
	}
	

}
