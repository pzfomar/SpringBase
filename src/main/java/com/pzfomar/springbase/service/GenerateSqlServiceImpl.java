package com.pzfomar.springbase.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pzfomar.springbase.core.entity.CollectionEntity;
import com.pzfomar.springbase.core.entity.FieldEntity;
import com.pzfomar.springbase.core.repository.CollectionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class GenerateSqlServiceImpl implements GenerateSqlService {
	private final CollectionRepository collectionRepository;

	@Override
	public void process() {
		String sql = this.collectionRepository.findAll().parallelStream().map(this::table)
				.collect(Collectors.joining(";"));

		log.info(sql);
	}

	private String table(CollectionEntity collectionEntity) {
		return "CREATE TABLE " + collectionEntity.getName().toUpperCase() + this.parenthesis(
				collectionEntity.getFields().parallelStream().map(this::attribute).collect(Collectors.joining(", ")));
	}

	private String attribute(FieldEntity fieldEntity) {
		String size = "";
		if (fieldEntity.getMax() != 0) {
			size = this.parenthesis(String.valueOf(fieldEntity.getMax()));
		}
		return fieldEntity.getName() + " " + fieldEntity.getType() + size;
	}

	private String parenthesis(String text) {
		return "( " + text + " )";
	}
}
