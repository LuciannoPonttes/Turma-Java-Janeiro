package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
	JFrame frameTelaPrincipal;
	JFrame frameCadastroGerente;

	public ControladorTelaCadastroGerente(JTextField nome, JTextField cpf, JTextField gerencia,
			JFrame frameTelaPrincipal, JFrame frameCadastroGerente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.gerencia = gerencia;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroGerente = frameCadastroGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(gerencia.getText());
		
		
		
		switch (e.getActionCommand()) {
			case "Cadastrar": {
				
				Gerente gerente = new Gerente();
				gerente.setNome(nome.getText());
				
				if(!gerente.isCpfValido(cpf.getText())) {
					JOptionPane.showMessageDialog(null, "CPF INVALIDO!" );
					
				}else {
					gerente.setCpf(cpf.getText());
					gerente.setGerencia(gerencia.getText());
					
					if(manipuladorArquivo.registrarGerente(gerente)) {
						
						JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");
						
						nome.setText(null);
						cpf.setText(null);
						gerencia.setText(null);
						
					}else {
						JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
					}
				}
					
				
				
				
				break;
			}
			
			case "Menu Inicial": {
				frameCadastroGerente.setVisible(false);
				frameTelaPrincipal.setVisible(true);
				
				break;
			}
		}
		
		
			
		}

}
