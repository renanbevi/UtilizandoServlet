package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
       
   
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		
		
		String paramAcao = request.getParameter("acao"); // medir execucao de todas as ações do projeto
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));  //protege as paginas e não deixa acessar sem o login
		
		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {  //chamando a sessão que é gerada no tomcat com o ID do usuário e verifica se for vazio não fez login 
			
			response.sendRedirect("entrada?acao=LoginForm");       //volta para a tela de login sempre que for null
			return;
		}
		
		
		chain.doFilter(request, response);
		
		
		
	}

}
