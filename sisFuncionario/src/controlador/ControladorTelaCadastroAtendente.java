package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Atendente;
import gerenciaArquivo.ManipuladorArquivo;

public class ControladorTelaCadastroAtendente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField setor;
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAtendente;
	Atendente atendente = new Atendente();
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

	public ControladorTelaCadastroAtendente(JTextField nome, JTextField cpf, JTextField gerencia,
			JFrame frameTelaPrincipal, JFrame frameCadastroAtendente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.setor = gerencia;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroAtendente = frameCadastroAtendente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("O botão foi acionado");

		switch (e.getActionCommand()) {
			
			case "Cadastrar": {
	
				atendente.setNome(nome.getText());
				atendente.setCpf(cpf.getText());
				atendente.setSetor(setor.getText());
	
				if (manipuladorArquivo.registrarAtendente(atendente)) {
	
					JOptionPane.showMessageDialog(null, "O arquivo foi salvo com sucesso!!");
	
					nome.setText(null);
					cpf.setText(null);
					setor.setText(null);
	
				} else {
					JOptionPane.showMessageDialog(null, "O arquivo não salvo com sucesso!!!!!");
				}
				break;
	
			}
			case "Menu Inicial": {
				frameCadastroAtendente.setVisible(false);
				frameTelaPrincipal.setVisible(true);
				break;
			}

		}

	}

}
