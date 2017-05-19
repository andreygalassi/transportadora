package br.com.fiap.transportadora;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class Aplicacao extends ResourceConfig {

	public Aplicacao() {
		packages("br.com.fiap.transportadora");
	}
	
}
