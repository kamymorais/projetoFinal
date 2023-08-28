package br.com.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.project.model.Usuario;

	@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
		@Query("select i from Usuario i where i.email = :email")
		public Usuario findByEmail(String email);
		
		@Query("select p from Usuario p where p.email = :email and p.senha = :senha")
		public Usuario buscarLogin(String email, String senha);
	}

	
	