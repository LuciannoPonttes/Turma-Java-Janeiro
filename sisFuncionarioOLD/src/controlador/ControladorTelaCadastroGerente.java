package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import gerenciaArquivo.ManipuladorArquivo;

public class ControladorTelaCadastroGerente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField gerencia;
	Gerente gerente;
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	
	
	public ControladorTelaCadastroGerente(JTextField nome, JTextField cpf, JTextField gerencia) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.gerencia = gerencia;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(gerencia.getText());
		
		Gerente gerente = new Gerente();
		gerente.setNome(nome.getText());
		gerente.setCpf(cpf.getText());
		gerente.setGerencia(gerencia.getText());
		
		
		
		if(manipuladorArquivo.registrarGerente(gerente)) {
			JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");
			
		}else {
			JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
		}
		
		
		
	}

}
