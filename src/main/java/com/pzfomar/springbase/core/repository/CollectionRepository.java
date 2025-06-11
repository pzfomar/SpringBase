package com.pzfomar.springbase.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pzfomar.springbase.core.entity.CollectionEntity;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Long> {

}
