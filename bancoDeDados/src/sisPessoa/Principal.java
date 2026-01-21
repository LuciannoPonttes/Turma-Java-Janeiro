package sisPessoa;



public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Rodou");
		
		
		Pessoa pessoa = new Pessoa("Ronaldinho", "031", "ronaldinho@dibre.com");
		
		DaoPessoa daoPessoa = new DaoPessoa();
		
		if(daoPessoa.salvarPessoaNoBanco(pessoa)) {
			System.out.println("Salvou no banco!!");
			
			
		}else {
			
			System.out.println("Não salvou no banco!!!");
		}
		
		/* PARA TESTE
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		if(fabricaConexao.criarConexaoBancoSisPessoa() != null) {
			System.out.println("Conectou");
			
		}else {
			System.out.println("Não conectou");
		}
		*/

	}

}
