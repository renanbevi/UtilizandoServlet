package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;

public class RemoveCliente implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Removendo Cliente");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId); // recebendo o parametro id e transformando a String em INT
		
		System.out.println(id);
		
		
		Banco banco = new Banco();
		banco.removeCliente(id);
		
		return  "redirect:entrada?acao=ListaClientes";
	}

}
