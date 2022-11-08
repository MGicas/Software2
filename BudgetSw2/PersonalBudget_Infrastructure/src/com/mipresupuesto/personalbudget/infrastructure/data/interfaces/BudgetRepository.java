package com.mipresupuesto.personalbudget.infrastructure.data.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mipresupuesto.personalbudget.entity.BudgetEntity;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, UUID> {
	@Query(value = "SELECT* FROM dbo.Budget WHERE idYear = ?1 and idPerson = ?2", nativeQuery = true)
	Optional<BudgetEntity> getByYearandPerson(UUID yearId, UUID personId);
}
