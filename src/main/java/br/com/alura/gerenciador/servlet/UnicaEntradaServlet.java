package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraCliente;
import br.com.alura.gerenciador.acao.ListaClientes;
import br.com.alura.gerenciador.acao.MostraCliente;
import br.com.alura.gerenciador.acao.NovoCliente;
import br.com.alura.gerenciador.acao.NovoClienteform;
import br.com.alura.gerenciador.acao.RemoveCliente;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UnicaEntradaServlet() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String paramAcao = request.getParameter("acao");
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));  //protege as paginas e não deixa acessar sem o login
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {  //chamando a sessão que é gerada no tomcat com o ID do usuário e verifica se for vazio não fez login 
																			
			response.sendRedirect("entrada?acao=LoginForm");       //volta para a tela de login sempre que for null
			return;
		}
		
		
		
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			 nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		} 
		
		
					
		
		String [] tipoEEndereco = nome.split(":"); //split separa o string  forward:NovoClienteLista.jsp   Foward posicao 0 e o JPS posição 1 separados por :
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		
		}else {
		response.sendRedirect(tipoEEndereco[1]); // se não for foward tras o link da JSP diretamente
		}
	}
}


