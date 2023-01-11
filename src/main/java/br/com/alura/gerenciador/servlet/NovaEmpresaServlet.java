package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String paramDataEmpresa = request.getParameter("data"); // recebe a informação da data do formulario
	
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // sdf formata o parse da string DATA
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpjEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
	
					
		//Chamar o JSP que possui todo o código de visualização novaEmpresaCriada.jsp
		
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");  //usar o despachador de requisição
		request.setAttribute("empresa", empresa.getNome()); //Joga o atributo dentro da requisição 
		request.setAttribute("cnpj", empresa.getCnpj());
		request.setAttribute("data", empresa.getDataAbertura());
		rd.forward(request, response); //leva os objetos e chama o JSP
		
		
}
}
