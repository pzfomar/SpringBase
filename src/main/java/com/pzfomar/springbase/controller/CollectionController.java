package com.pzfomar.springbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzfomar.springbase.core.entity.CollectionEntity;

@RestController
@RequestMapping(path = "/_/api/collection")
public class CollectionController {

	@PostMapping("")
	public ResponseEntity<Void> create(@RequestBody CollectionEntity request) {
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/generate/sql")
	public ResponseEntity<Void> generateSql() {
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/generate/database")
	public ResponseEntity<Void> generateDatabase() {
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
