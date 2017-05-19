package br.com.fiap.transportadora;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Frete {

	private String cpfCnpjRemetente;
	private String cpfCnpjDestinatario;
	private long quantidadeProdutos;
	private double valorTotalRemessa;
	
	public String getCpfCnpjRemetente() {
		return cpfCnpjRemetente;
	}
	public void setCpfCnpjRemetente(String cpfCnpjRemetente) {
		this.cpfCnpjRemetente = cpfCnpjRemetente;
	}
	public String getCpfCnpjDestinatario() {
		return cpfCnpjDestinatario;
	}
	public void setCpfCnpjDestinatario(String cpfCnpjDestinatario) {
		this.cpfCnpjDestinatario = cpfCnpjDestinatario;
	}
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

