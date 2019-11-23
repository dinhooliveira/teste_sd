package Unisuam.Cliente;


import javax.swing.JOptionPane;

public class Mensagem {
	static String mensagem;


/*
 * VALIDAÇÃO DE DADOS 
 */
	public static boolean validaEntrada(String entrada) {

		boolean retorno=false;

		try {
			if(entrada.matches("[0-9]")) {
				retorno = false;
			}else {
				retorno = true;
			}
		}catch(Exception e) {
			retorno = false;
		}
		return retorno;

	}

	/*=====================================================================================================================
	 * 									METODOS PARA ENTRADA DE DADOS
	 */
	public static void mensagemAguardaSegundoCliente() {
		JOptionPane.showMessageDialog(null, "Aguarde o segundo cliente logar!!");
	}

	public static String servico() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com valor do serviço." + "\n" + "Ex: 50,00").replace(",",".");

		if(!validaEntrada(mensagem)) {
			mensagemErro();
			servico();
		}
		return mensagem;
	}

	public static String entraDesconto() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com o desconto" + "\n" + "Ex: R$ 50,00").replace(",",".");

		if(!validaEntrada(mensagem)) {
			mensagemErro();
			entraDesconto();
		}
		return mensagem;
	}

	public static String entraTaxaDeJuros() {
		mensagem = JOptionPane.showInputDialog(null, "Entre com a taxa de juros." + "\n" + "Ex: 0.6%").replace(",",".");

		if(!validaEntrada(mensagem)) {
			mensagemErro();
			entraTaxaDeJuros();
		}

		return mensagem;
	}
	
/*
 * MENSAGEM DE ERRO
 */
	
	public static void mensagemErro() {
		JOptionPane.showMessageDialog(null,"Informe um valor valido!");
	}

	/*=====================================================================================================================
	 * 									METODOS PARA RESULTADO FINAL
	 */	

	public static void mensagemFinalCliente1(double servico, double desconto, double taxaDeJuros,  double valorRecebido) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 1--------------------\n"
				+ "*.*.*.*.*.*.*.*.*.VALORES INSERIDOS *.*.*.*.*.*.*.*.*.\n"
				+ "Valor Serviço: " + String.format("%.2f",servico) + "\n" 
				+ "Valor Desconto: " + String.format("%.2f",desconto) + "\n" 
				+ "Taxa de Juros: " + String.format("%.1f",taxaDeJuros) + "\n"
				+"----------------Resultado final-------------\n"
				+ "Valor total: " + String.format("%.2f",valorRecebido) + "\n"
				+ "*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");

	}

	public static void mensagemFinalCliente2(double servico, double desconto, double taxaDeJuros,  double valorRecebido) {
		JOptionPane.showMessageDialog(null, "------------------Cliente 2--------------------\n"
				+ "*.*.*.*.*.*.*.*.*.VALORES INSERIDOS *.*.*.*.*.*.*.*.*.\n"
				+ "Valor Serviço: " + String.format("%.2f",servico) + "\n" 
				+ "Valor Desconto: " + String.format("%.2f",desconto) + "\n" 
				+ "Taxa de Juros: " + String.format("%.1f",taxaDeJuros) + "\n"
				+"----------------Resultado final-------------\n"
				+ "Valor total: " + String.format("%.2f",valorRecebido) + "\n"
				+ "*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.");

	}


}