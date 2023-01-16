package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;

public class ListaClientes {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando Cliente");
		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();
		
		
		request.setAttribute("clientes", lista);
	
		
		return "forward:NovoClienteLista.jsp";
		
	}

}
