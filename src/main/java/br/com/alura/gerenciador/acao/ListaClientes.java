package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;

public class ListaClientes  implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado") == null) {  //chamando a sessão que é gerada no tomcat com o ID do usuário e verifica se for vazio não fez login 
																			
			return "redirect:entrada?acao=LoginForm";       //volta para a tela de login sempre que for null
		}
		
		
		System.out.println("listando Cliente");
		Banco banco = new Banco();
		List<Cliente> lista = banco.getClientes();
		
		
		request.setAttribute("clientes", lista);
	
		
		return "forward:NovoClienteLista.jsp";
		
	}

}
