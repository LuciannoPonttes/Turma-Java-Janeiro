package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarGerente;
import entidade.Gerente;

public class TelaListarGerente {
	
	
	public void listarGerente(List<Gerente> listaGerentes) {
		
		
		int quantidadeLinhas = listaGerentes.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(Gerente gerente: listaGerentes) {
			
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getGerencia();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "GERENCIA"};
		
		JFrame frameListarGerentes = new JFrame();
		frameListarGerentes.setSize(475, 450);
		
		JTable tabelaGerentes = new JTable(tabelaString, nomeColunas);
		tabelaGerentes.setSize(1000,1000);
		tabelaGerentes.setBounds(30,40,300,300);
		
		JPanel panelListarGerente = new JPanel();
		
		
		
		JScrollPane scrollPaneListarGerente = new JScrollPane(tabelaGerentes);
		
		JLabel labelCpf = new JLabel("Digite o CPF");
		panelListarGerente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelListarGerente.add(textCpf);
		
		JButton botaoDetalhar = new JButton("Detalhar");
		panelListarGerente.add(botaoDetalhar);
		
		panelListarGerente.add(scrollPaneListarGerente);
		
		
		frameListarGerentes.add(panelListarGerente);
		frameListarGerentes.setLocationRelativeTo(null);
		frameListarGerentes.setVisible(true);
		
		ControladorTelaListarGerente controladorTelaListar = new ControladorTelaListarGerente(textCpf, listaGerentes);
		botaoDetalhar.addActionListener(controladorTelaListar);
		
		
		
		
		
	}

}
