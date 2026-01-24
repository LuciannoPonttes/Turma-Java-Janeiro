package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entidade.Atendente;
import interfaceGrafica.TelaDetalharAtendente;

public class ControladorTelaListarAtendente implements ActionListener {

	JTextField cpf;
	List<Atendente> listaAtendentes;
	
	TelaDetalharAtendente telaDetalharAtendente = new TelaDetalharAtendente();

	public ControladorTelaListarAtendente(JTextField cpf, List<Atendente> listaAtendentes) {

		this.cpf = cpf;
		this.listaAtendentes = listaAtendentes;
	}

	@Override
	public void actionPerformed(ActionEvent opcao) {

		switch (opcao.getActionCommand()) { // Recebe o valor opcao

			case "Detalhar": { // Verifica seo valor getOpcao é igual a 1
				telaDetalharAtendente.detalharAtendente(buscarAtendentePorCpf());
				
	
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
