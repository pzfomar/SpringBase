package com.pzfomar.springbase.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pzfomar.springbase.core.entity.IndexEntity;

/**
 * The Interface IndexRepository.
 */
@Repository
public interface IndexRepository extends JpaRepository<IndexEntity, Long> {

}
