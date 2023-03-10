package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;


//@WebServlet("/mostrarCliente")
public class mostraClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId); // recebendo o parametro id e transformando a String em INT
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePelaId(id);
		
		System.out.println(cliente.getNome());
				
		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraCliente.jsp");
		rd.forward(request, response);
		
		response.sendRedirect("entrada?acao=listaClientes");
		
	}

}
