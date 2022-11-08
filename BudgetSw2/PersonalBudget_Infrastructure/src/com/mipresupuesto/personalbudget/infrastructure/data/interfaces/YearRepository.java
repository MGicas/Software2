package com.mipresupuesto.personalbudget.infrastructure.data.interfaces;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mipresupuesto.personalbudget.entity.YearEntity;

@Repository
public interface YearRepository extends JpaRepository<YearEntity, UUID> {
	@Query(value="SELECT * FROM dbo.Year WHERE id = ?1", nativeQuery = true)
	Optional<YearEntity> findYearBy(String yaer);
}
