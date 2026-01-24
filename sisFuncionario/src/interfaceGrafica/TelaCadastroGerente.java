package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroGerente;


public class TelaCadastroGerente {
	
	
	public void formularioGerente(JFrame  frameTelaPrincipal) {
		
		String nome = "Digite o nome do gerente:";
		String cpf = "Digite o cpf do gerente:";
		String gerencia = "Digite a gerencia:";
		
		JFrame frameCadastroGerente = new JFrame();
		frameCadastroGerente.setSize(300 , 300);
		
		JPanel panelGerente = new JPanel();
		
		

		JLabel labelCpf = new JLabel(cpf);
		panelGerente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelGerente.add(textCpf);
		
		JLabel labelNome = new JLabel(nome);
		panelGerente.add(labelNome);
		
		JTextField textNome = new JTextField(10);
		panelGerente.add(textNome);
		
		JLabel labelGerencia = new JLabel(gerencia);
		panelGerente.add(labelGerencia);
		
		JTextField textGerencia = new JTextField(10);
		panelGerente.add(textGerencia);
		
		JButton botaoCadastrarGerente = new JButton("Cadastrar");
		panelGerente.add(botaoCadastrarGerente);
		
		JButton botaoMenuInicial = new JButton("Menu Inicial");
		panelGerente.add(botaoMenuInicial);
		
		JButton botaoListar = new JButton("Listar");
		panelGerente.add(botaoListar);
		
		frameCadastroGerente.add(panelGerente);
		frameCadastroGerente.setLocationRelativeTo(null); // Centraliza a janela
		frameCadastroGerente.setVisible(true);
		
		ControladorTelaCadastroGerente controladorTelaCadastroGerente = new ControladorTelaCadastroGerente(textNome, textCpf, textGerencia, frameTelaPrincipal, frameCadastroGerente);
		botaoCadastrarGerente.addActionListener(controladorTelaCadastroGerente);
		botaoMenuInicial.addActionListener(controladorTelaCadastroGerente);
		botaoListar.addActionListener(controladorTelaCadastroGerente);
		
	}

}
