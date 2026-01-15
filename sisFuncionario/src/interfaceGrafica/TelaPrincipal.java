package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal {
	
	
	public void menuPrincipal() {
		System.out.println("Inicio do metodo menuPrincipal");
		
		JFrame frameMenuPrincipal = new JFrame(); // Cria o objeto Frame(janela da interface grafica)
		frameMenuPrincipal.setSize(200,200);// Tamano da janela
		
		JPanel panelMenuPrincipal = new JPanel();//Painel para organizar os itens dentro do painel
		
		JLabel labelOpcao1 = new JLabel("1 - PARA GERENTE");// Criar a primeira label
		panelMenuPrincipal.add(labelOpcao1);// Adiciona a primeira label dentro do painel
		
		JLabel labelOpcao2 = new JLabel("2 - ATENDENTE");//Cria a segunda Label
		panelMenuPrincipal.add(labelOpcao2);//Adiciona a segunda label no painel
		
		JTextField caixaTextoOpcao = new JTextField(10);//Cria a caixa de texto para receber a opção
		panelMenuPrincipal.add(caixaTextoOpcao);//Adiciona a opção na caixa de texto
		
		JButton botaoEnviar = new JButton("Enviar");//Cria o botão
		panelMenuPrincipal.add(botaoEnviar);//Adiciona o botão no painel
		
		
		frameMenuPrincipal.add(panelMenuPrincipal);
		frameMenuPrincipal.setVisible(true); // Liberando a visualização desse frame para o usuario
		
		

	}

}
