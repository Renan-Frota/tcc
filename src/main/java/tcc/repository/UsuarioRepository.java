package tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
	
	public Optional<UsuarioModel> findByLogin(String login);
}
