package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;

public class MostraCliente implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId); // recebendo o parametro id e transformando a String em INT
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePelaId(id);
		
		System.out.println(cliente.getNome());
				
		request.setAttribute("cliente", cliente);
		
		
		return "forward:formAlteraCliente.jsp";
	}
	

}
