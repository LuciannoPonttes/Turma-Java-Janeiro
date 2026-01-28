package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entidade.Atendente;
import interfaceGrafica.TelaListarAtendente;
import repositorio.RepositorioAtendenteImplementacao;

public class ControladorTelaAlterarAtendente implements ActionListener {


	JTextField nome;
	JTextField cpf;
	JTextField setor;
	JFrame frameTelaAlterarAtendente;
	
	TelaListarAtendente telaListarAtendente = new TelaListarAtendente();
	
	RepositorioAtendenteImplementacao atendenteImplementacao = new RepositorioAtendenteImplementacao(); 
	
	
	public ControladorTelaAlterarAtendente(JTextField nome, JTextField cpf, JTextField setor, JFrame frameTelaAlterarAtendente) {
		this.nome = nome;
		this.cpf = cpf;
		this.setor = setor;
		this.frameTelaAlterarAtendente = frameTelaAlterarAtendente;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			
			case "ALTERAR": {
				Atendente atendente = new Atendente();
				atendente.setCpf(cpf.getText());
				atendente.setNome(nome.getText());
				atendente.setSetor(setor.getText());
				
				atendenteImplementacao.alterarAtendente(atendente);
			}
			
			case "VOLTAR": {
				frameTelaAlterarAtendente.setVisible(false);
				telaListarAtendente.listarAtendente(atendenteImplementacao.listarAtendente());
			}
				
				
				break;
			}
		
	}

}
