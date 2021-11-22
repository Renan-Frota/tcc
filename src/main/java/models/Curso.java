package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos;
}
