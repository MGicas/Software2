package com.mipresupuesto.personalbudget.application.specification;

public interface Specification<T> {

	boolean isSatisfiedBy(T specification);
}
