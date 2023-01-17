package br.com.alura.gerenciador.servlet.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {
	
	private static List<Cliente> listaCliente = new ArrayList<>();
	private static List<Usuario> ListaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	
	
	static {
		Cliente cliente = new Cliente();
		cliente.setId(chaveSequencial++);
		cliente.setNome("Moura");
		cliente.setSexo("Masculino");
		cliente.setValor("40,00");
		cliente.setServico("Corte de cabelo");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(chaveSequencial++);
		cliente2.setNome("Cachusia");
		cliente2.setSexo("Feminino");
		cliente2.setValor("80,00");
		cliente2.setServico("Pintura cabelo");
		listaCliente.add(cliente);
		listaCliente.add(cliente2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("renan");
		u1.setSenha("190210");
		
		Usuario u2 = new Usuario();
		u2.setLogin("juliane");
		u2.setSenha("190210");
		
		ListaUsuarios.add(u1);
		ListaUsuarios.add(u2);
		
	}
	
	
	
	public void adiciona(Cliente cliente) {  //criação de um banco para guardar as informações das empresas em uma lista
		cliente.setId(Banco.chaveSequencial);
		Banco.listaCliente.add(cliente);
		
	}
	
	public List<Cliente> getClientes(){  // Mostra todas as informações gravada na Lista das empresas
		return Banco.listaCliente;
	}

	

	public void removeCliente(Integer id) {
		
		Iterator<Cliente> it = listaCliente.iterator();
		
		while (it.hasNext()) { //tem o proximo elemento?
			Cliente cli = it.next(); // me dá o proximo elemento
			if(cli.getId() == id) {
				it.remove();
			}
			
		}
	}
		public Cliente buscaClientePelaId(Integer id) {
			for (Cliente cliente : listaCliente) {
				if(cliente.getId() == id) {
					return cliente;
				}
			}	
			return null;
		
				
		}

		public Usuario existeUsuario(String login, String senha) {
			
			for(Usuario usuario : ListaUsuarios) {
				if(usuario.ehIgual(login, senha)) {
					return usuario;
				}
			}
			
			return null;
		}
	
}

