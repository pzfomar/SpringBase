package com.pzfomar.springbase.core.entity;

import java.util.List;

import com.pzfomar.springbase.core.enums.CollectionEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "collections")
public class CollectionEntity extends Auditing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Builder.Default
	private boolean system = false;
	@Enumerated(EnumType.STRING)
	private CollectionEnum type;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<FieldEntity> fields;
	@OneToMany(cascade = CascadeType.ALL)
	private List<IndexEntity> indexes;
	private String listRule;
	private String viewRule;
	private String createRule;
	private String updateRule;
	private String deleteRule;
}
