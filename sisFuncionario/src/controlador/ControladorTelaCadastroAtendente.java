package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entidade.Atendente;
import interfaceGrafica.TelaListarAtendente;
import repositorio.RepositorioAtendenteImplementacao;

public class ControladorTelaCadastroAtendente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField setor;
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAtendente;
	Atendente atendente = new Atendente();
	TelaListarAtendente telaListarAtendente = new TelaListarAtendente();
	RepositorioAtendenteImplementacao repositorioAtendenteImplementacao = new RepositorioAtendenteImplementacao();

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
	
				if (repositorioAtendenteImplementacao.salvarAtendente(atendente)) {
	
					JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");
	
					nome.setText(null);
					cpf.setText(null);
					setor.setText(null);
	
				} else {
					JOptionPane.showMessageDialog(null, "Não foi salvo com sucesso!!!!!");
				}
				break;
	
				}
				case "Menu Inicial": {
					frameCadastroAtendente.setVisible(false);
					frameTelaPrincipal.setVisible(true);
					break;
				}
				case "Listar": {
					telaListarAtendente.listarAtendente(repositorioAtendenteImplementacao.listarAtendente());
					break;
				}

		}

	}

}
