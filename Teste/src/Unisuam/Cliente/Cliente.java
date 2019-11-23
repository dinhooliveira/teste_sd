package Unisuam.Cliente;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import Unisuam.Interface.Interface;

public class Cliente {


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {

			String nomeServico = "ServicosSalao";
			int porta = 1099;
			String ip = retornaIP();


			Registry registry = LocateRegistry.getRegistry(ip, porta);


			Interface	stub = (Interface) registry.lookup(nomeServico);

			/*cria um stub que recebe o servico contendo os metodos remotos do servidor
			 * Responsavel pela comunica��o entre clientes e servidor.
			 */

			JOptionPane.showMessageDialog(null, "=====================================\n"
					+ "Conectado no servidor -> " +ip+"\n"
					+ "=====================================");


			//stub.adicionarCliente(cliente);
			try {
				if(stub.getCliente() == 0) {
					//while(stub.contaPassos() <= 6) {
					stub.setCliente(1);
					stub.setPassos(1);//2

					while(stub.contaPassos() == 2) {
						//Mensagem.mensagemAguardaSegundoCliente();
					}

					stub.setServico(Mensagem.servico());
					stub.setPassos(1);//4


					while(stub.contaPassos() == 4) {}
					stub.setEntraDesconto(Mensagem.entraDesconto());
					stub.setPassos(1);//6
					
					while(stub.contaPassos() == 6) {}
					stub.setTaxaJuros(Mensagem.entraTaxaDeJuros());
					stub.setPassos(1);//6

					while(stub.contaPassos() == 8) {}
					stub.valorRecebido();

					Mensagem.mensagemFinalCliente1(stub.getServico(), stub.getEntraDesconto(), stub.getTaxaJuros(),  stub.valorRecebido());

					stub.zeraContador();

					//}
				}else
					if(stub.getCliente() == 1) {

						stub.setPassos(1);//3

						while(stub.contaPassos() == 3) {}
						stub.setEntraDesconto(Mensagem.entraDesconto());
						stub.setPassos(1);//6
						
						while(stub.contaPassos() == 5) {}
						stub.setTaxaJuros(Mensagem.entraTaxaDeJuros());
						stub.setPassos(1);//6

						while(stub.contaPassos() == 7) {}
						stub.valorRecebido();

						Mensagem.mensagemFinalCliente1(stub.getServico(), stub.getEntraDesconto(), stub.getTaxaJuros(),  stub.valorRecebido());


						stub.zeraContador();
					}
			}catch(Exception e) {
				stub.zeraContador();
				e.printStackTrace();
			}

			//}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO 404 - Servidor n�o encontrado: \n" + e);
		}

	}




	public static String retornaIP() {

		String[] servidor = {"Servidor 1", "Servidor 2"};
		String op = (String) JOptionPane.showInputDialog(null, "Escolha o servidor", "Servidores", JOptionPane.QUESTION_MESSAGE,null, servidor, servidor[0]);

		if(op == servidor[0]) {
			return "10.0.200.28";
		}else {
			return "10.0.200.8";
		}

	}

}