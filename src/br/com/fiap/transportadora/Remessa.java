package br.com.fiap.transportadora;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Remessa {

	private String cpfCnpjRemetente;
	private String cpfCnpjDestinatario;
	private double valorFrete;
	
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
	public double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	
}
