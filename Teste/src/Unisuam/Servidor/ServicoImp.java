package Unisuam.Servidor;

import java.rmi.RemoteException;



import Unisuam.Interface.Interface;

public class ServicoImp implements Interface{
	private static int contaPassos=1;
	private static int contaCliente=0;

	private double valorRecebido;
	private double total;


	private  double servico = 0.0; 
	private double desconto = 0.0;
	private double taxaJuros = 0.0;

	public ServicoImp() {

	}

/*
 * (non-Javadoc)
 * @see Unisuam.Interface.Interface#setServico(java.lang.String)
 * GET E SET 
 */

	public void setServico(String servico) throws RemoteException {
		this.servico = Double.parseDouble(servico);
		System.out.println(this.servico+"\n");
	}
	

	@Override
	public double getServico() throws RemoteException {
		// TODO Auto-generated method stub
		return this.servico;
	}
	

	@Override
	public void setEntraDesconto(String desconto) throws RemoteException {

		this.desconto = Double.parseDouble(desconto);
		System.out.println(this.desconto+"\n");
	}
	
	@Override
	public double getEntraDesconto() throws RemoteException {
		// TODO Auto-generated method stub
		return this.desconto;
	}
	
	
	@Override
	public void setTaxaJuros(String taxaDeJuros) throws RemoteException {
		this.taxaJuros = Double.parseDouble(taxaDeJuros);
		System.out.println(this.taxaJuros+"\n");
	}
	
	@Override
	public double getTaxaJuros() throws RemoteException {
		// TODO Auto-generated method stub
		return this.taxaJuros;
	}
	
	
	public double getValorRecebido() throws RemoteException{
	return this.valorRecebido;
}
	
	public double getTotal() throws RemoteException{
	return this.total;
}


	/*
	 * MÉTODOS QUE REALIZAM CALCULOS
	 * 
	 */



	@Override
	public double valorRecebido()  throws RemoteException{	
		System.out.println("********************");
		System.out.println(" VALORES RECEBIDOS ");
		System.out.println("********************");
		System.out.println(this.servico+"\n");
		System.out.println(this.desconto+"\n");
		System.out.println(this.taxaJuros+"\n");
		System.out.println("********************");
		System.out.println("********************");
		double aux=0.0;

		 aux = (this.servico - this.desconto) * (this.taxaJuros/100);
		return this.valorRecebido = aux;		
	
	}


	@Override
	public void total()  throws RemoteException{
		this.total = this.valorRecebido;
		
	}



/*
 * (non-Javadoc)
 * @see Unisuam.Interface.Interface#setPassos(int)
 * CONTROLE DE CLIENTES 
 */
	
	@Override
	public void setPassos(int passos) throws RemoteException{
		ServicoImp.contaPassos += passos;
	}
	
	
	@Override
	public int contaPassos() throws RemoteException{
		return contaPassos;
	}	

	
	@Override
	public void setCliente(int valor) throws RemoteException{
		ServicoImp.contaCliente += valor;
	}


	@Override
	public int getCliente() throws RemoteException{
		return ServicoImp.contaCliente;
	}
  
	@Override
	public void zeraContador() throws RemoteException{
		ServicoImp.contaCliente = 0;
		ServicoImp.contaPassos = 1;
	}

}