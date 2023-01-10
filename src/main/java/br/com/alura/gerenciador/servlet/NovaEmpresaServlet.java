package br.com.alura.gerenciador.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cadastrando nova empresa");
		
	
		String nomeEmpresa = request.getParameter("empresa");
		String cnpjEmpresa = request.getParameter("cnpj");
	
			
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpjEmpresa);
		
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
	
					
		//Chamar o JSP que possui todo o código de visualização novaEmpresaCriada.jsp
		
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");  //usar o despachador de requisição
		request.setAttribute("empresa", empresa.getNome()); //Joga o atributo dentro da requisição 
		request.setAttribute("cnpj", empresa.getCnpj());
		rd.forward(request, response); //leva os objetos e chama o JSP
		
		
}
}
