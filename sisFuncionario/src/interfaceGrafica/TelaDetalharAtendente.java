package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.Atendente;


public class TelaDetalharAtendente {
	
public void detalharAtendente(Atendente atendente) {
		
		GridLayout grid = new GridLayout(0,2);
		
		JFrame frameTelaAtendente = new JFrame("Detalhes do Gerente");
		frameTelaAtendente.setSize(300,180);
		
		JPanel panelTelaAtendente = new JPanel();
		panelTelaAtendente.setLayout(grid);
		
		panelTelaAtendente.add(new JLabel("CPF:"));
		panelTelaAtendente.add(new JLabel(atendente.getCpf()));
		
		
		panelTelaAtendente.add(new JLabel("NOME:"));
		panelTelaAtendente.add(new JLabel(atendente.getNome()));
		
		panelTelaAtendente.add(new JLabel("SETOR:"));
		panelTelaAtendente.add(new JLabel(atendente.getSetor()));
		
		frameTelaAtendente.add(panelTelaAtendente);
		frameTelaAtendente.setLocationRelativeTo(null);
		frameTelaAtendente.setVisible(true);
		
		
		
		
		
		
		
	}

}
