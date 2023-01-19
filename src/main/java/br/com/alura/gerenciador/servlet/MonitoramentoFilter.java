package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;




//@WebFilter( "/entrada")
public class MonitoramentoFilter implements Filter{

	public void init() throws ServletException {}
	
	private void destroi() {}
   
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();	
		
		String acao = request.getParameter("acao"); // medir execucao de todas as ações do projeto
		//executa a ação se não chamar o processo para
		chain.doFilter(request, response);  //continua o processo
		
		
		long depois = System.currentTimeMillis();
	System.out.println("Tempo de execucao da acao: "+ acao + " -> " + (depois - antes) + " Milisegundos");
		
	}

}
