package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import interfaceGrafica.TelaListarGerente;
import repositorio.RepositorioGerenteImplementacao;

public class ControladorTelaCadastroGerente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField gerencia;
	JFrame frameTelaPrincipal;
	Gerente gerente;
	JFrame frameCadastroGerente;

	RepositorioGerenteImplementacao repositorioGerenteImplementacao = new RepositorioGerenteImplementacao();
	TelaListarGerente telaListarGerente = new TelaListarGerente();
	
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

		switch (e.getActionCommand()) {
		case "Cadastrar": {

			Gerente gerente = new Gerente();
			gerente.setNome(nome.getText());

			if (gerente.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");

			} else {
				gerente.setCpf(cpf.getText());
				gerente.setGerencia(gerencia.getText());

				if (repositorioGerenteImplementacao.salvarGerente(gerente)) {

					JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");

					nome.setText(null);
					cpf.setText(null);
					gerencia.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "Não salvo com sucesso!!!!!");
				}
			}

			break;
		}

		case "Menu Inicial": {
			frameCadastroGerente.setVisible(false);
			frameTelaPrincipal.setVisible(true);

			break;
		}

		case "Listar": {
			telaListarGerente.listarGerente(repositorioGerenteImplementacao.listarGerente()); 

			break;
		}

		}

	}

}
