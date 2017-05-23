package br.com.fiap.filter;

import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.commons.codec.binary.Base64;

public class AuthenticationServiceTransportadora {
	
	static HashMap<String, String> usuarios;
	
	static {
		// HashMap com a lista fixa de usuários e senhas
		usuarios = new HashMap<String, String>();
		usuarios.put("fornecedor", "fornecedor");
		usuarios.put("governo", "governo");
		usuarios.put("loja", "loja");
		usuarios.put("financeira", "financeira");
		usuarios.put("transportadora", "transportadora");
		usuarios.put("teste", "teste");		
	}
	
	public boolean authenticate(String authCredentials) {
		
		String usernameAndPassword = null;
		boolean authenticationStatus = false;
		
		if (authCredentials == null) return false;  // Liga desliga
		
		// O formato  do header será "Basic encodedstring" para Basic authentication
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		System.out.println("encodedUserPassword: " + encodedUserPassword);
		
		try {
			
			// Java 8 Base64 decoder
			// byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			
			// Java 7 - Google Guava Base64 decoder 
			// byte[] decodedBytes = BaseEncoding.base64().decode(encodedUserPassword);
			// usernameAndPassword = new String(decodedBytes, "UTF-8");
			
			byte[] decodedBytes = Base64.decodeBase64(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
			
		} catch (Exception e) {
			System.out.println("Falha durante decodificação base64:" + e.getMessage());
			return false;
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		
		if (tokenizer.countTokens() < 2) return false;
		
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		String senhaObtidaHashMap = usuarios.get(username);
		
		if( senhaObtidaHashMap == null )
			authenticationStatus = false;
		else
		{
			if( senhaObtidaHashMap.equals(password) )
				authenticationStatus = true;
		}
		
		return authenticationStatus;
	}
	
}

