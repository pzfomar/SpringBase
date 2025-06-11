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

/**
 * The Class CollectionEntity.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collections")
public class CollectionEntity extends Auditing {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The system. */
	@Builder.Default
	private boolean system = false;

	/** The type. */
	@Enumerated(EnumType.STRING)
	private CollectionEnum type;

	/** The name. */
	private String name;

	/** The fields. */
	@OneToMany(cascade = CascadeType.ALL)
	private List<FieldEntity> fields;

	/** The indexes. */
	@OneToMany(cascade = CascadeType.ALL)
	private List<IndexEntity> indexes;

	/** The list rule. */
	private String listRule;

	/** The view rule. */
	private String viewRule;

	/** The create rule. */
	private String createRule;

	/** The update rule. */
	private String updateRule;

	/** The delete rule. */
	private String deleteRule;
}
