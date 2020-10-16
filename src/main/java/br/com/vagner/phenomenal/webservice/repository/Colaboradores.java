package br.com.vagner.phenomenal.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.vagner.phenomenal.webservice.model.Colaborador;

/**
 * Interface de repositório para o modelo de dados, usando a persistencia JPA
 * é necessário passar o modelo de dados (Entity) e o tipo do ID
 * @author Vagner
 *
 */
@Repository
public interface Colaboradores extends JpaRepository<Colaborador, Long>
{
	
	 
}

