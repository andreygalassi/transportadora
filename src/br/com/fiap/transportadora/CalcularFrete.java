package br.com.fiap.transportadora;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalcularFrete {

	private long quantidadeProdutos;
	private double valorTotalRemessa;
	
	public long getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	public void setQuantidadeProdutos(long quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}
	public double getValorTotalRemessa() {
		return valorTotalRemessa;
	}
	public void setValorTotalRemessa(double valorTotalRemessa) {
		this.valorTotalRemessa = valorTotalRemessa;
	}
	
}
