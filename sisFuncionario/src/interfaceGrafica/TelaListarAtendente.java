package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarAtendente;
import entidade.Atendente;

public class TelaListarAtendente {

	// O metodo é void porque não retorna nenhum valor, ou seja não tem return
	public void listarAtendente(List<Atendente> listaAtendente) {
		
		int quantidadeLinhas = listaAtendente.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(Atendente atendente: listaAtendente) {
			
			tabelaString[posicaoLinha][posicaoColuna] = atendente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = atendente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = atendente.getSetor();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "SETOR"};
		
		JFrame frameListarAtendente = new JFrame();
		frameListarAtendente.setSize(475, 450);
		JPanel panelListarAtendente = new JPanel();
		
		JTable tabelaAtendente = new JTable(tabelaString, nomeColunas);
		tabelaAtendente.setSize(1000,1000);
		tabelaAtendente.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarAtendente = new JScrollPane(tabelaAtendente);
		
		JLabel labelCpf = new JLabel("Digite o CPF:");
		panelListarAtendente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelListarAtendente.add(textCpf);
		
		JButton botaoDetalhar = new JButton("Detalhar");
		panelListarAtendente.add(botaoDetalhar);
		
		
		panelListarAtendente.add(scrollPaneListarAtendente);
		
		frameListarAtendente.add(panelListarAtendente);
		frameListarAtendente.setLocationRelativeTo(null);
		frameListarAtendente.setVisible(true);
		
		ControladorTelaListarAtendente controladorTelaListarAtendente = new ControladorTelaListarAtendente(textCpf, listaAtendente);
		botaoDetalhar.addActionListener(controladorTelaListarAtendente);
		
		
		
	}
}
