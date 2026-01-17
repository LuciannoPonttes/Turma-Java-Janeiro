package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import interfaceGrafica.TelaCadastroGerente;

// O implements será detalhado um poucou mais na frente
// A classe ControladorTelaPrincipal se torna subClasse EventListener
public class ControladorTelaPrincipal implements ActionListener {

	JTextField opcao;
	TelaCadastroGerente telaCadastroGerente = new TelaCadastroGerente();// Tela de Cadastro do Gerente
	JFrame frameTelaPrincipal; //Jframe da tela principal
	

	public ControladorTelaPrincipal(JTextField opcao, JFrame frameTelaPrincipal ) {
		this.opcao = opcao;
		this.frameTelaPrincipal = frameTelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		System.out.println("O usuario digitou: " + opcao.getText());

		switch (opcao.getText()) { // Recebe o valor opcao

		case "1": { // Verifica seo valor getOpcao é igual a 1
			
			telaCadastroGerente.formularioGerente();// Cria e apresenta a tele de formulario de Gerente
			frameTelaPrincipal.setVisible(false); // Oculta a tela principal
			System.out.println("Direcionar para o cadastro de Gerente");
			break;
		}

		case "2": { // Verifica se o valor getOpcao é igual a 2
			System.out.println("Direcionar para o cadastro de Atendente");
			break;
		}

		}

	}
}
