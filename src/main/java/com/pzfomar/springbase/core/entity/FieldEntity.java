package com.pzfomar.springbase.core.entity;

import com.pzfomar.springbase.core.enums.FieldEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class FieldEntity.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fields")
public class FieldEntity extends Auditing {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The autogenerate pattern. */
	private String autogeneratePattern;

	/** The hidden. */
	@Builder.Default
	private boolean hidden = false;

	/** The max. */
	@Builder.Default
	private int max = 0;

	/** The min. */
	@Builder.Default
	private int min = 0;

	/** The name. */
	private String name;

	/** The pattern. */
	private String pattern;

	/** The presentable. */
	@Builder.Default
	private boolean presentable = false;

	/** The primary key. */
	@Builder.Default
	private boolean primaryKey = false;

	/** The required. */
	@Builder.Default
	private boolean required = false;

	/** The system. */
	@Builder.Default
	private boolean system = false;

	/** The type. */
	@Enumerated(EnumType.STRING)
	private FieldEnum type;
}
