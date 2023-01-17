package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
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


