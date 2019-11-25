package Unisuam.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
	
	
	/*
	 * 
	 *METODO PARA REALIZAR CALCULO
	 * 
	 *  */	

	public void total() throws RemoteException;
	public double valorRecebido() throws RemoteException;	
    

	
	/*
	 * METODOS PARA ALTERNAR CLIENTES
	 */
	
	public void setPassos(int passos) throws RemoteException;
	public int contaPassos() throws RemoteException;
	public void setCliente(int valor) throws RemoteException;
	public int getCliente() throws RemoteException;
	public void zeraContador() throws RemoteException;
	
	
	/*
	 * GET E SET
	 */

	public void setServico(String servico) throws RemoteException;
	public void setAceita(int aceita) throws RemoteException;
	public void setEntraDesconto(String desconto) throws RemoteException;	
	public void setTaxaJuros(String taxaDeJuros) throws RemoteException;
	
	
	public double getTotal() throws RemoteException;	
	public double getServico() throws RemoteException;
	public int getAceita() throws RemoteException;
	double getEntraDesconto() throws RemoteException;	
	public double getTaxaJuros() throws RemoteException;	
	

}
