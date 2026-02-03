package model;

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private String senha;
	

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	// Validação basica de cpf
	public boolean isCpfValido() {
		
		
		if (cpf == null) return false;

	    // Remove caracteres não numéricos
	    cpf = cpf.replaceAll("\\D", "");

	    // CPF deve ter exatamente 11 dígitos
	    if (cpf.length() != 11) return false;

	    // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
	    if (cpf.matches("(\\d)\\1{10}")) return false;

	    try {
	        // Calcula o primeiro dígito verificador
	        int soma = 0;
	        for (int i = 0; i < 9; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	        }
	        int primeiroDigito = 11 - (soma % 11);
	        if (primeiroDigito >= 10) primeiroDigito = 0;

	        if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
	            return false;
	        }

	        // Calcula o segundo dígito verificador
	        soma = 0;
	        for (int i = 0; i < 10; i++) {
	            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	        }
	        int segundoDigito = 11 - (soma % 11);
	        if (segundoDigito >= 10) segundoDigito = 0;

	        return segundoDigito == Character.getNumericValue(cpf.charAt(10));

	    } catch (Exception e) {
	        return false;
	    }
	}
	
	
	

}