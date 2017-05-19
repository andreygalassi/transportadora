package br.com.fiap.transportadora;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FreteCalculado {

	private double valorTotalFrete;

	public double getValorTotalFrete() {
		return valorTotalFrete;
	}

	public void setValorTotalFrete(double valorTotalFrete) {
		this.valorTotalFrete = valorTotalFrete;
	}
	
}
