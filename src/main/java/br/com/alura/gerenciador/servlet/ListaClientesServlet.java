package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;

/**
 * Servlet implementation class ListaempresasServlet
 */
//@WebServlet("/listaClientes")
public class ListaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();
		
			
		
		RequestDispatcher rd = request.getRequestDispatcher("/NovoClienteLista.jsp");
		request.setAttribute("clientes", lista);
		rd.forward(request, response);
		
	
	}

}
