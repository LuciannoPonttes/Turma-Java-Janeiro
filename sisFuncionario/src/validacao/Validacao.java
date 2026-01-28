package validacao;

import entidade.Atendente;
import entidade.Gerente;

public class Validacao {
	
	public static String validaGerente(Gerente gerente) {
		String mensangemRetorno = null;
		
		if(!gerente.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		return mensangemRetorno;
		
	}
	
	public static String validaAtendente(Atendente atendente) {
		String mensangemRetorno = null;
		
		if(!atendente.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		if(!(atendente.getNome() == null) && atendente.getNome().isBlank()) {
			mensangemRetorno = "NOME NÃO PODE SER VAZIO!!!";
		}
		
		if(!(atendente.getSetor() == null) && atendente.getSetor().isBlank()) {
			mensangemRetorno = "SETOR NÃO PODE SER VAZIO!!!";
		}
		
		return mensangemRetorno;
		
	}

}
