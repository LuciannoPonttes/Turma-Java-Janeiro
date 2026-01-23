package sisAnimal2;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {
		
		
		System.out.println("Rodou");
		
		Animal animal = new Animal("002", "Pipa", "Tania");
		
		DaoAnimal daoAnimal = new DaoAnimal();
		
		daoAnimal.salvarAnimalBanco(animal);

	}

}
