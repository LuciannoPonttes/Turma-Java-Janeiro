package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import entidade.Gerente;
import interfaceGrafica.TelaDetalharGerente;

public class ControladorTelaListarGerente implements ActionListener {

	JTextField textCpf;
	List<Gerente> listaGerente;
	
	TelaDetalharGerente telaDetalharGerente = new TelaDetalharGerente();
	

	public ControladorTelaListarGerente(JTextField textCpf, List<Gerente> listaGerente) {
		
		this.textCpf = textCpf;
		this.listaGerente = listaGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaDetalharGerente.detalharGerente(buscarGerentePorCpf());
		
	}
	
	public Gerente buscarGerentePorCpf() {
		
		for(Gerente gerente: listaGerente) {
			if(gerente.getCpf().equals(textCpf.getText())) {
				return gerente;
			}
		}
		
		return null;
	}

}
