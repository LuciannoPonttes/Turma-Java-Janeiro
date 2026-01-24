package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.Gerente;

public class TelaDetalharGerente {

	
	
	public void detalharGerente(Gerente gerente) {
		
		GridLayout grid = new GridLayout(0,2);
		
		JFrame frameTelaGerente = new JFrame("Detalhes do Gerente");
		frameTelaGerente.setSize(300,180);
		
		JPanel panelTelaGerente = new JPanel();
		panelTelaGerente.setLayout(grid);
		
		panelTelaGerente.add(new JLabel("CPF:"));
		panelTelaGerente.add(new JLabel(gerente.getCpf()));
		
		
		panelTelaGerente.add(new JLabel("NOME:"));
		panelTelaGerente.add(new JLabel(gerente.getNome()));
		
		panelTelaGerente.add(new JLabel("GERENCIA:"));
		panelTelaGerente.add(new JLabel(gerente.getGerencia()));
		
		frameTelaGerente.add(panelTelaGerente);
		frameTelaGerente.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
}
