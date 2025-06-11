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

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fields")
public class FieldEntity extends Auditing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String autogeneratePattern;
	@Builder.Default
	private boolean hidden = false;
	@Builder.Default
	private int max = 0;
	@Builder.Default
	private int min = 0;
	private String name;
	private String pattern;
	@Builder.Default
	private boolean presentable = false;
	@Builder.Default
	private boolean primaryKey = false;
	@Builder.Default
	private boolean required = false;
	@Builder.Default
	private boolean system = false;
	@Enumerated(EnumType.STRING)
	private FieldEnum type;
}
