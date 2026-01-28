package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entidade.Atendente;
import interfaceGrafica.TelaListarAtendente;
import repositorio.RepositorioAtendenteImplementacao;
import validacao.Validacao;

public class ControladorTelaCadastroAtendente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField setor;
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAtendente;
	Atendente atendente = new Atendente();
	TelaListarAtendente telaListarAtendente = new TelaListarAtendente();
	RepositorioAtendenteImplementacao repositorioAtendenteImplementacao = new RepositorioAtendenteImplementacao();

	public ControladorTelaCadastroAtendente(JTextField nome, JTextField cpf, JTextField gerencia,
			JFrame frameTelaPrincipal, JFrame frameCadastroAtendente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.setor = gerencia;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroAtendente = frameCadastroAtendente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("O botão foi acionado");

		switch (e.getActionCommand()) {
			
			case "Cadastrar": {
	
				atendente.setNome(nome.getText());
				atendente.setCpf(cpf.getText());
				atendente.setSetor(setor.getText());
				
				String resultadoValidacao = Validacao.validaAtendente(atendente);
				
				if(resultadoValidacao == null) {
					if (repositorioAtendenteImplementacao.salvarAtendente(atendente)) {
						
						JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");
		
						nome.setText(null);
						cpf.setText(null);
						setor.setText(null);
		
					} else {
						JOptionPane.showMessageDialog(null, "Não foi salvo com sucesso!!!!!");
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, resultadoValidacao);
				}
	
				
				break;
	
				}
				case "Menu Inicial": {
					frameCadastroAtendente.setVisible(false);
					frameTelaPrincipal.setVisible(true);
					break;
				}
				case "Listar": {
					frameCadastroAtendente.setVisible(false);
					telaListarAtendente.listarAtendente(repositorioAtendenteImplementacao.listarAtendente());
					break;
				}

		}

	}

}
