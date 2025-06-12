package com.pzfomar.springbase.core.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Class Auditing.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Auditing {

	/** The created date. */
	@CreatedDate
	private LocalDateTime createdDate;

	/** The updated date. */
	@LastModifiedDate
	private LocalDateTime updatedDate;
}
