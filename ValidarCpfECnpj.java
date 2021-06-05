package validacao;


public class ValidarCpfECnpj {
	
	public boolean validarCpf(String cpf) {
		if(cpf.length() == 14) // tirando formatação ('.' e '-') 
			cpf = cpf.replaceAll("\\.|-", "");
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || 
			cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
			cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || 
			cpf.equals("99999999999") || (cpf.length() != 11)) // CPF com digitos iguais são inválidos 
			return false; // CPF com tamanho diferente de 11 digitos são inválidos 
		
		char digito10, digito11;
		int somatorio = 0, indice, numero, peso, resposta;
		
		peso = 10; // Encontrar o digito 10 
		for(indice = 0; indice < 9; indice++){
			numero = Character.getNumericValue(cpf.charAt(indice));
			somatorio += numero * peso;
			peso--;
		}
			
		resposta = 11 - (somatorio % 11);
		
		if(resposta == 10 || resposta == 11)
			digito10 = '0';
		else
			digito10 = Character.forDigit(resposta, 10);
		
		somatorio = 0; peso = 11;  // Encontrar o digito 11
		for(indice = 0; indice < 10; indice++){
			numero = Character.getNumericValue(cpf.charAt(indice));
			somatorio += numero * peso;
			peso--;
		}
		
		resposta = 11 - (somatorio % 11);
		
		if(resposta == 10 || resposta == 11)
			digito11 = '0';
		else
			digito11 = Character.forDigit(resposta, 10);
			
		if(digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10))
			return true; // Se CPF for válido retorna 'true'
		else
			return false; // Se CPF for inválido retorna 'false'
	}
	
	public boolean validarCnpj(String cnpj) {
		if(cnpj.length() == 18) // tirando formatação ('.' , '-' e '/')
			cnpj = cnpj.replaceAll("\\.|-|\\/", "");
		
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || 
			cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
		    cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") ||
		    cnpj.equals("99999999999999") || (cnpj.length() != 14)) // CNPJ com digitos iguais são inválidos 
			return false; // CNPJ com tamanho diferente de 14 digitos são inválidos
		 
		char digito13, digito14;
		int somatorio = 0, indice, numero, peso, resposta;
		
		peso = 5; // Encontrar o digito 13
		for(indice = 0; indice < 12; indice++){
			numero = Character.getNumericValue(cnpj.charAt(indice));
			somatorio += numero * peso;
			peso--;
			if(peso == 1)
				peso = 9;
		}
		
		resposta = 11 - (somatorio % 11);
		if(resposta == 0 || resposta == 1)
			digito13 = '0';
		else
			digito13 = Character.forDigit(resposta, 10);
		
		peso = 6; somatorio = 0; // Encontrar o digito 14
		for(indice = 0; indice < 13; indice++){
			numero = Character.getNumericValue(cnpj.charAt(indice));
			somatorio += numero * peso;
			peso--;
			if(peso == 1)
				peso = 9;
		}
		
		resposta = 11 - (somatorio % 11);
		if(resposta == 0 || resposta == 1)
			digito14 = '0';
		else
			digito14 = Character.forDigit(resposta, 10);
		
		if(digito13 == cnpj.charAt(12) && digito14 == cnpj.charAt(13))
			return true; // Se o CNPJ for válido retorna 'true'
		else
			return false;// Se o CNPJ for inválido retorna 'false' 
	}
}
