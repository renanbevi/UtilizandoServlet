package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraCliente;
import br.com.alura.gerenciador.acao.ListaClientes;
import br.com.alura.gerenciador.acao.MostraCliente;
import br.com.alura.gerenciador.acao.NovoCliente;
import br.com.alura.gerenciador.acao.RemoveCliente;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UnicaEntradaServlet() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nome = null;
		if (paramAcao.equals("listaClientes")) {

			ListaClientes acao = new ListaClientes();
		    nome = acao.executa(request, response);
		     
		} else if (paramAcao.equals("removeCliente")) {

			RemoveCliente acao = new RemoveCliente();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("mostraCliente")) {

			MostraCliente acao = new MostraCliente();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("novoCliente")) {

			NovoCliente acao = new NovoCliente();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("alteraCliente")) {

			AlteraCliente acao = new AlteraCliente();
			nome = acao.executa(request, response);

		}
		
		String [] tipoEEndereco = nome.split(":"); //split separa o string  forward:NovoClienteLista.jsp   Foward posicao 0 e o JPS posição 1 separados por :
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);
		
		}else {
		response.sendRedirect(tipoEEndereco[1]); // se não for foward tras o link da JSP diretamente
		}
	}
}


