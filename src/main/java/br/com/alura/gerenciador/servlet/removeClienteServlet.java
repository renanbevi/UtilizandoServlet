package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;

//@WebServlet("/removeCliente")
public class removeClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId); // recebendo o parametro id e transformando a String em INT
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeCliente(id);
		
		return "redirect:entrada?acao=listaClientes";
	
		
		
		
	}

}
