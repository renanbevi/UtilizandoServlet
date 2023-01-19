package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;


@WebServlet("/clientes")
public class ClientesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<Cliente> clientes = new Banco().getClientes();
	
	Gson gson = new Gson();
	String json = gson.toJson(clientes);
		 
	response.setContentType("application/json");  //Definir o tipo de conteudo
	response.getWriter().print(json);  //método para devolver string
		
	}

}
