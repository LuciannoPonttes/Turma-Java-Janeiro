package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import entidade.Atendente;
import interfaceGrafica.TelaAlterarAtendente;

import interfaceGrafica.TelaDetalharAtendente;
import interfaceGrafica.TelaListarAtendente;
import interfaceGrafica.TelaPrincipal;
import repositorio.RepositorioAtendenteImplementacao;

public class ControladorTelaListarAtendente implements ActionListener {

	JTextField cpf;
	List<Atendente> listaAtendentes;
	JFrame frameListarAtendente;

	TelaAlterarAtendente alterarAtendente = new TelaAlterarAtendente();

	TelaDetalharAtendente telaDetalharAtendente = new TelaDetalharAtendente();
	
	TelaPrincipal telaPrincipal = new TelaPrincipal();
	
	TelaListarAtendente listarAtendente = new TelaListarAtendente();
	
	
	RepositorioAtendenteImplementacao repositorioAtendenteImplementacao = new RepositorioAtendenteImplementacao();

	public ControladorTelaListarAtendente(JTextField cpf, List<Atendente> listaAtendentes,
			JFrame frameListarAtendente) {

		this.cpf = cpf;
		this.listaAtendentes = listaAtendentes;
		this.frameListarAtendente = frameListarAtendente;
	}

	@Override
	public void actionPerformed(ActionEvent opcao) {

		switch (opcao.getActionCommand()) { // Recebe o valor opcao

		case "Detalhar": { // Verifica seo valor getOpcao é igual a 1

			Atendente atendente = buscarAtendentePorCpf();
			if (atendente != null) {
				telaDetalharAtendente.detalharAtendente(buscarAtendentePorCpf());

			} else {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");
			}

			break;
		}

		case "Alterar": { // Verifica seo valor getOpcao é igual a 1

			Atendente atendente = buscarAtendentePorCpf();
			if (atendente != null) {
				frameListarAtendente.setVisible(false);
				alterarAtendente.alterarAtendente(buscarAtendentePorCpf());
			} else {

				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");
			}

			break;
		}

		case "Deletar": { // Verifica seo valor getOpcao é igual a 1

			Atendente atendente = buscarAtendentePorCpf();
			if (atendente != null) {
				
				frameListarAtendente.setVisible(false);
				listarAtendente.listarAtendente(repositorioAtendenteImplementacao.listarAtendente());
				
				repositorioAtendenteImplementacao.deletarAtendente(atendente.getCpf());
				JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO");
			} else {

				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");
			}

			break;
		}
		case "Voltar": { // Verifica seo valor getOpcao é igual a 1
			frameListarAtendente.setVisible(false);
			telaPrincipal.menuPrincipal();

			break;
		}
		}
	}

	public Atendente buscarAtendentePorCpf() {

		for (Atendente atendente : listaAtendentes) {
			if (atendente.getCpf().equals(cpf.getText())) {
				return atendente;
			}

		}
		return null;
	}

}
