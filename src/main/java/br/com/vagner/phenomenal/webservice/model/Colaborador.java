package br.com.vagner.phenomenal.webservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe de entidade do banco de dados (Com a persistencia ela se tornara uma tabela pelo H2)
 * @author Vagner
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Colaborador")
public class Colaborador implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//Atributos/colunas
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@Column(nullable = false)
    @NotNull
	private String nome;
	
	@Column(nullable = false)
    @NotNull
	private String project;
	
	@Column(nullable = false)
    @NotNull
	private String DP;
	
	@Column(name="GESTORPROJECT",nullable = false)
    @NotNull
	private String gestorProject;
	
	/*Getters e Setters dos atributos
	Por algum motivo o lombook não funcionou, o código seria bastante diminuido
	*/
	
	//Setters
	public void setId(Long id)
	{
		this.id = id;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public void setProject(String project) 
	{
		this.project = project;
	}

	public void setDP(String dP) {
		DP = dP;
	}

	public void setGestorProject(String gestorProject) {
		this.gestorProject = gestorProject;
	}

	
	//Getters
	public Long getId()
	{
		return id;
	}

	public String getNome() 
	{
		return nome;
	}

	public String getProject() 
	{
		return project;
	}

	public String getDP()
	{
		return DP;
	}

	public String getGestorProject() 
	{
		return gestorProject;
	}

}
