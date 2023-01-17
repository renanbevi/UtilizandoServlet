package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Cliente;

public class NovoCliente implements Acao{
	
			public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("cadastrando novo Cliente");
			
		
			String nomeCliente = request.getParameter("nome");
			String sexoCliente = request.getParameter("sexo");
			String servicoCliente = request.getParameter("servico");
			String paramDataMarcada = request.getParameter("data"); // recebe a informação da data do formulario
			String valorCliente = request.getParameter("valor");
					
			Date dataMarcada = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // sdf formata o parse da string DATA
				dataMarcada = sdf.parse(paramDataMarcada);
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			
			
			Cliente cliente = new Cliente();
			cliente.setNome(nomeCliente);
			cliente.setSexo(sexoCliente);
			cliente.setServico(servicoCliente);
			cliente.setDataMarcada(dataMarcada);
			cliente.setValor(valorCliente);
			
			
			
			Banco banco = new Banco();
			banco.adiciona(cliente);
		
						
			//Chamar o JSP que possui todo o código de visualização novaEmpresaCriada.jsp
			
		
			request.setAttribute("cliente", cliente.getNome()); //Joga o atributo dentro da requisição 
			request.setAttribute("sexo", cliente.getSexo());
			request.setAttribute("servico", cliente.getServico());
			request.setAttribute("data", cliente.getDataMarcada());
			request.setAttribute("valor", cliente.getValor());
			

			
			return "redirect:entrada?acao=ListaClientes";
		}

	}

