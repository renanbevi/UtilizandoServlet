package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login"); //recebendo os parametros do formulario de login name="login" />
		String senha = request.getParameter("senha"); // name="senha" />
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login,senha);
		
		if(usuario != null) {
			System.out.println("usuario existe");
			return "redirect:entrada?acao=ListaClientes";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
		
	
		
		
	}

}
