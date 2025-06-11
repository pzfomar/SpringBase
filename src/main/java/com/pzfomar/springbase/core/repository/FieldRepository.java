package com.pzfomar.springbase.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pzfomar.springbase.core.entity.FieldEntity;

/**
 * The Interface FieldRepository.
 */
@Repository
public interface FieldRepository extends JpaRepository<FieldEntity, Long> {

}
