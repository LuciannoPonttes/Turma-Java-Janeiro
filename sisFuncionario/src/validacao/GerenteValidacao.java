package validacao;

import entidade.Gerente;

public class GerenteValidacao {
	
	public static String validaGerente(Gerente gerente) {
		String mensangemRetorno = null;
		if(!gerente.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		return mensangemRetorno;
		
	}

}
