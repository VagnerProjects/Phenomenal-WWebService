package br.com.vagner.phenomenal.webservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import br.com.vagner.phenomenal.webservice.model.Colaborador;
import br.com.vagner.phenomenal.webservice.repository.Colaboradores;


/**Classe de controle do Spring MVC e das requisições
 * Este sendo um controller REST
 * @author Vagner
 *
 */
@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController 
{
	@Autowired(required=false)
	private Colaboradores colaboradores;
	
    
	/**
	 * Método que retorna a view da página
	 * @return ModelAndView - A visualização da página
	 */
	@GetMapping
	public ModelAndView listar()
	{
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("colaboradores", colaboradores.findAll());
		
		//Adiciona um novo modelo
		modelAndView.addObject(new Colaborador());
		
		return modelAndView;
	}
	
	
	/**
	 * Controle de requisição POST
	 * @param col - Entidade de controle do Spring Data JPA (Camada model)
	 * @param request - Valor retornado pela requisição HTTP
	 * @return Redireciona para outra página
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Colaborador col, HttpServletRequest request)
	{
	
		try
		{
			//Recebe os valores digitados na form
//			String ID = request.getParameter("ID");
			String Name = request.getParameter("Nome");
			String DP = request.getParameter("DP");
			String Project = request.getParameter("Project");
			String Gestor = request.getParameter("Gestor");
			
			//Adiciona nas colunas no Banco de dados os novos valores
			col.setNome(Name);
			col.setDP(DP);
//			col.setId(Long.valueOf(ID));
			col.setProject(Project);
			col.setGestorProject(Gestor);
	
			//Salva no banco de dados as adições
			this.colaboradores.save(col);
			
			return "Cadastro Realizado! Retorne a página anterior";
		}
		catch(HttpClientErrorException ex)
		{
			ex.getMessage();
		}
		
		return null;

	}
	
	
}


