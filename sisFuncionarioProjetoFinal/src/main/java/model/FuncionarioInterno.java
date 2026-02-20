package model;

public class FuncionarioInterno extends Funcionario {
	
	private String cargo; //-> ENUM
	private Double salario;
	private Double plr;
	
	
	
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getPlr() {
		return plr;
	}
	public void setPlr(Double plr) {
		this.plr = plr;
	}
	
	
	
	
	
	
	

}


