package Unisuam.Cliente;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import Unisuam.Interface.Interface;

public class Cliente {


	public static void main(String[] args) {
		Cliente.comecar();
	}
	
	public static void comecar() {
		// TODO Auto-generated method stub


		try {

			String nomeServico = "ServicosSalao";
			int porta = 1099;
			String ip = retornaIP();


			Registry registry = LocateRegistry.getRegistry(ip, porta);


			Interface	stub = (Interface) registry.lookup(nomeServico);

			/*cria um stub que recebe o servico contendo os metodos remotos do servidor
			 * Responsavel pela comunicação entre clientes e servidor.
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
						Mensagem.mensagemAguardaSegundoCliente();
					}

					stub.setServico(Mensagem.servico());
					stub.setPassos(1);//4
					
					while(stub.contaPassos() == 4) {}
					if(stub.getAceita()==0){
					     stub.setEntraDesconto(Mensagem.entraDesconto());
					     stub.setPassos(1);//6
					}else {
					  JOptionPane.showInputDialog(null, "Cliente não aceitou!");
					     stub.zeraContador();
					     Cliente.comecar();
					}

// 					while(stub.contaPassos() == 6) {}
// 					stub.setEntraDesconto(Mensagem.entraDesconto());
// 					stub.setPassos(1);//6
					
//					while(stub.contaPassos() == 6) {}
//					stub.setTaxaJuros(Mensagem.entraTaxaDeJuros());
//					stub.setPassos(1);//6

					while(stub.contaPassos() == 6) {}
					stub.valorRecebido();

					Mensagem.mensagemFinalCliente1(stub.getServico(), stub.getEntraDesconto(),  stub.valorRecebido());

					stub.zeraContador();
					Cliente.comecar();
					
					//}
				}else
					if(stub.getCliente() == 1) {

						stub.setPassos(1);//3

						while(stub.contaPassos() == 3) {}
						stub.setAceita(Mensagem.aceita(stub.getServico()));
						stub.setPassos(1);//6
						
//						while(stub.contaPassos() == 5) {}
//						stub.setTaxaJuros(Mensagem.entraTaxaDeJuros());
//						stub.setPassos(1);//6

						while(stub.contaPassos() == 5) {}
						stub.valorRecebido();

						Mensagem.mensagemFinalCliente2(stub.getServico(), stub.getEntraDesconto(),  stub.valorRecebido());


						stub.zeraContador();
						Cliente.comecar();
					}
			}catch(Exception e) {
				stub.zeraContador();
				e.printStackTrace();
			}

			//}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERRO 404 - Servidor não encontrado: \n" + e);
		}

	}




	public static String retornaIP() {

		String[] servidor = {"Servidor 1", "Servidor 2"};
		String op = (String) JOptionPane.showInputDialog(null, "Escolha o servidor", "Servidores", JOptionPane.QUESTION_MESSAGE,null, servidor, servidor[0]);

		if(op == servidor[0]) {
			return "10.0.218.19";
		}else {
			return "10.0.218.14";
		}

	}

}
