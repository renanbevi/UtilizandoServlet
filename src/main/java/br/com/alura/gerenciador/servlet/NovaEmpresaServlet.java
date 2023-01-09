package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		String nomeLogin = request.getParameter("usuario");//lendo o parametro 
		String senhaLogin = request.getParameter("password");
		String nomeEmpresa = request.getParameter("empresa");
		
		Acessos acessoLogin = new Acessos();
		acessoLogin.setAdmin(nomeLogin);
		
		Acessos acessoSenha = new Acessos();
		acessoSenha.setSenha(senhaLogin);
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		banco.adicionaAcessos(acessoLogin, acessoSenha);
					
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1> Login efetuado com sucesso ! Empresa " + nomeEmpresa + " </h1> </body></html>");
	
		
}
}
