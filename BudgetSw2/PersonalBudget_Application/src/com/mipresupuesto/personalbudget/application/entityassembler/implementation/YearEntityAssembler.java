package com.mipresupuesto.personalbudget.application.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.builder.YearDomainBuilder;
import com.mipresupuesto.personalbudget.entity.YearEntity;

@Component
public class YearEntityAssembler implements EntityAssembler<YearEntity, YearDomain>{
	

	@Override
	public final YearDomain asembleDomain(YearEntity entity) {
		YearDomain domain = YearDomainBuilder.get().build();
		if (!ObjectHelper.isNull(entity)) {
			domain = YearDomainBuilder.get()
					.setId(entity.getId())
					.setYear(entity.getYear())
					.build();
		}
		return domain;
	}

	@Override
	public YearEntity asembleEntity(YearDomain domain) {
		YearEntity entity = new YearEntity();
		if (!ObjectHelper.isNull(domain)) {
			entity = new YearEntity(domain.getId(), domain.getYear());
		}
		return entity;
	}

}
