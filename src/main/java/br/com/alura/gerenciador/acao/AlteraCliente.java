package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;


//@WebServlet("/alteraCliente")
public class AlteraCliente implements Acao {
	private static final long serialVersionUID = 1L;

	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nomeCliente = request.getParameter("nome");
		String sexoCliente = request.getParameter("sexo");
		String paramDataMarcada = request.getParameter("data"); // recebe a informação da data do formulario
		String valorCliente = request.getParameter("valor");
		String servicoCliente = request.getParameter("servico");
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Ação altera empresa = "+ id);
		
		
		Date dataMarcada = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // sdf formata o parse da string DATA
			dataMarcada = sdf.parse(paramDataMarcada);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Cliente cliente = banco.buscaClientePelaId(id);
		cliente.setNome(nomeCliente);
		cliente.setSexo(sexoCliente);
		cliente.setDataMarcada(dataMarcada);
		cliente.setValor(valorCliente);
		cliente.setServico(servicoCliente);
		
		return "redirect:entrada?acao=ListaClientes";
		
		
		
		
	}

	
}

