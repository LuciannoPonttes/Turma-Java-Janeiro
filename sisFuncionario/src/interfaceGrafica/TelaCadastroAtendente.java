package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroAtendente;

//Classe Atendente
public class TelaCadastroAtendente {
	
	public void formularioAtendente(JFrame frameTelaPrincipal) {
		

		String nome = "Digite o nome do gerente:";
		String cpf = "Digite o cpf do gerente:";
		String setor = "Digite o setor:";
		
		
		JFrame frameCadastroAtendente = new JFrame();
		frameCadastroAtendente.setSize(300,300);
		
		JPanel panelAtendente = new JPanel();
		
		JLabel labelNome = new JLabel(nome);
		panelAtendente.add(labelNome);
		
		JTextField textNome = new JTextField(10);
		panelAtendente.add(textNome);
		
		JLabel labelCpf = new JLabel(cpf);
		panelAtendente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelAtendente.add(textCpf);
		
		JLabel labelSetor = new JLabel(setor);
		panelAtendente.add(labelSetor);
		
		JTextField textSetor = new JTextField(10);
		panelAtendente.add(textSetor);
		
		JButton botaoCadastrarAtendente = new JButton("Cadastrar");
		panelAtendente.add(botaoCadastrarAtendente);
		
		JButton botaoMenuInicial = new JButton("Menu Inicial");
		panelAtendente.add(botaoMenuInicial);
		
		
		frameCadastroAtendente.add(panelAtendente);
		frameCadastroAtendente.setLocationRelativeTo(null);
		frameCadastroAtendente.setVisible(true);
		
		ControladorTelaCadastroAtendente controladorTelaCadastroAtendente = new ControladorTelaCadastroAtendente(textNome, textCpf, textSetor, frameTelaPrincipal, frameCadastroAtendente );
		botaoCadastrarAtendente.addActionListener(controladorTelaCadastroAtendente);
		botaoMenuInicial.addActionListener(controladorTelaCadastroAtendente);
		
		
		
	}

}
