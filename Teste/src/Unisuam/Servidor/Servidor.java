package Unisuam.Servidor;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import Unisuam.Interface.Interface;

public class Servidor {

	public static void main(String[] args) {
		try {
			String nomeServico = "ServicosSalao";
			int porta = 1099;

			//instancia um objeto 
			Interface servico = new ServicoImp();

			//instancia o stub e exporta o objeto criado anteriormente para que o cliente possa utiliza-lo remotamente
			Interface servicoDistribuido = (Interface) UnicastRemoteObject.exportObject(servico, 0);

			Registry registry = LocateRegistry.createRegistry(porta);
			registry.bind(nomeServico, servicoDistribuido);
			String ip = InetAddress.getLocalHost().getHostAddress();
			String mensagem ="-------------Servidor Disponível-------------\n" +
					"Nome do Servido: "+nomeServico+"         \n"+
					"IP: "+ip+"                             \n"+
					"Pressione qualquer botão para encerrar \n"+
					"---------------------------------------------\n";			
			// JOptionPane.showMessageDialog(null, mensagem);

			int m = JOptionPane.showConfirmDialog(null, mensagem);

			if(m == JOptionPane.CANCEL_OPTION || m == JOptionPane.NO_OPTION || m == JOptionPane.YES_OPTION){
				UnicastRemoteObject.unexportObject(servico, true);
				registry.unbind(nomeServico);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
