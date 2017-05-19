package br.com.fiap.transportadora;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transportadora")
public class Transportadora {

	static List<Remessa> remessas = new ArrayList<Remessa>();
	private static double VALOR_FRETE_POR_PRODUTO = 25;
	private static double ALIQUOTA_SEGURO = 0.01;
	
	static {
		
		// TODO : Remover posteriormente a lista de remessas de teste
		
		remessas = new ArrayList();

		Remessa remessa = new Remessa();
		remessa.setCpfCnpjDestinatario("262");
		remessa.setCpfCnpjRemetente("256");
		remessa.setValorFrete(10.5);
		
		remessas.add(remessa);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarRemessas")
	public List<Remessa> getListaRemessas() {
		return remessas;
	}
	
	// Método com uso presumido para simulação em site de vendas.
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("calcularFrete")
	public Response calcularFrete(CalcularFrete calcularFrete) {
		
		double valorTotalFrete = calculaFrete(calcularFrete);		
		
		FreteCalculado freteCalculado = new FreteCalculado();
		freteCalculado.setValorTotalFrete(valorTotalFrete);
		
		return Response.status(200).entity(freteCalculado).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("gerarFrete")
	public Response cadastrarFrete(Frete frete) {
		
		// TODO - variável somente para depurar e separar da lógica ok dos outros grupos, remover.
		boolean gerarFreteNormalmente = true;
		
		Retorno retorno = new Retorno();
		retorno.setMensagem("Geração de frete em curso...");
		
		if( frete != null )
		{
			CalcularFrete calcularFrete = new CalcularFrete();
			calcularFrete.setQuantidadeProdutos(frete.getQuantidadeProdutos());
			calcularFrete.setValorTotalRemessa(frete.getValorTotalRemessa());
		
			double valorTotalFrete = calculaFrete(calcularFrete);
		
			// TODO ( ?? )
			//
			// if ( financeira.isDebtApproved( cpfCnpjRemetente, valorTotalFrete ) )  
			// { 
			//   if ( governo.isNotaFiscalEmitida(cpfCnpjRemetente, cpfCnpjDestinatario, valorProdutos, quantidadeProdutos, valorTotalFrete) ) 
			//   {
			//      gerarFreteNormalmente = true;
			//	 }
			//   else
			//      retorno.setMensagem("Nota fiscal não emitida.");
			// }
			// else
			//    retorno.setMensagem("Débito não aprovado.");
			//		
			
			if( gerarFreteNormalmente )
			{
				Remessa remessa = new Remessa();
				remessa.setCpfCnpjDestinatario(frete.getCpfCnpjDestinatario());
				remessa.setCpfCnpjRemetente(frete.getCpfCnpjRemetente());
				remessa.setValorFrete(valorTotalFrete);
				remessas.add(remessa);
			
				retorno.setMensagem("Frete gerado com sucesso.");
			}
		}	
			
		return Response.status(200).entity(retorno).build();
	}
	
	private double calculaFrete(CalcularFrete calcularFrete)
	{
		double freteCalculado = 0.0;
		
		if( calcularFrete != null )
		{
			freteCalculado = calcularFrete.getQuantidadeProdutos() * VALOR_FRETE_POR_PRODUTO;
			freteCalculado = freteCalculado + calcularFrete.getValorTotalRemessa() * ALIQUOTA_SEGURO;
			
			// TODO (??)
			// double totalImpostos = governo.getTotalImpostos(QuantidadeProdutos, ValorTotalRemessa);
			// freteCalculado = freteCalculado + totalImpostos;
		}
		
		return freteCalculado;
	}
	
}
