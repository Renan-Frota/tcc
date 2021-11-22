package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {
	
	@Id
	private int rm;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Curso curso;
}
