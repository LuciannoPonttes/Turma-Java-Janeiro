package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaAlterarAtendente;
import entidade.Atendente;

public class TelaAlterarAtendente {
	
	public void alterarAtendente(Atendente atendente) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaAlterarAtendente = new JFrame("Alterar Atendente");
		frameTelaAlterarAtendente.setSize(300, 180);

		JPanel panelTelaAlterarAtendente = new JPanel();
		panelTelaAlterarAtendente.setLayout(grid);

		panelTelaAlterarAtendente.add(new JLabel("CPF:"));
		JTextField textoCpf = new JTextField(atendente.getCpf());
		textoCpf.setEditable(false);
		panelTelaAlterarAtendente.add(textoCpf);

		panelTelaAlterarAtendente.add(new JLabel("NOME:"));
		JTextField textoNome = new JTextField(10);
		textoNome.setText(atendente.getNome());
		panelTelaAlterarAtendente.add(textoNome);

		panelTelaAlterarAtendente.add(new JLabel("SETOR:"));
		JTextField textoSetor = new JTextField(10);
		textoSetor.setText(atendente.getSetor());
		panelTelaAlterarAtendente.add(textoSetor);

		JButton botaoAlterar = new JButton("ALTERAR");
		panelTelaAlterarAtendente.add(botaoAlterar);

		JButton botaoVoltar = new JButton("VOLTAR");
		panelTelaAlterarAtendente.add(botaoVoltar);

		frameTelaAlterarAtendente.add(panelTelaAlterarAtendente);
		frameTelaAlterarAtendente.setLocationRelativeTo(null);
		frameTelaAlterarAtendente.setVisible(true);

		ControladorTelaAlterarAtendente controladorTelaAlterarAtendente = new ControladorTelaAlterarAtendente(
				textoNome, textoCpf, textoSetor, frameTelaAlterarAtendente);
		botaoAlterar.addActionListener(controladorTelaAlterarAtendente);
		botaoVoltar.addActionListener(controladorTelaAlterarAtendente);
	}

}
