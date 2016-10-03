package sources;

import java.util.Random;

import destinations.DestinationFinale;
import destinations.DestinationInterface;
import information.Information;

public class SourceAleatoire  extends Source <Boolean> {
DestinationFinale destination;

	@SuppressWarnings("unchecked")
	public SourceAleatoire (int nbBitsMess){
		super(); // Utilisation du constructeur supérieur pour bénéficier des attributs.
		
		//Création d'un tableau de Boolean pour créer ensuite une chaine de 0 et 1.
		Boolean BitsTab [] = new Boolean [nbBitsMess]; 
		Random r = new Random();
		
		int i = 0;
		for (i = 0;i<nbBitsMess;i++){
			
			BitsTab[i] = r.nextBoolean(); //génération d'un booléen aléatoire.

		}
		
		informationGeneree = new Information <Boolean> (BitsTab);
		System.out.println("la source a émis :" + informationGeneree +"(PASSAGE AU TRANSMETTEUR)");
		 
	}
	@SuppressWarnings("unchecked")
	public SourceAleatoire (int nbBitsMess, int seed){
		super(); // Utilisation du constructeur supérieur pour bénéficier des attributs.
		
		//Création d'un tableau de Boolean pour créer ensuite une chaine de 0 et 1.
		Boolean BitsTab [] = new Boolean [nbBitsMess]; 
		
		Random r = new Random(seed);
		int i = 0;
		for (i = 0;i<nbBitsMess;i++){
			
			BitsTab[i] = r.nextBoolean(); //génération d'un booléen aléatoire.

		}
		
		informationGeneree = new Information <Boolean> (BitsTab);
		System.out.println("la source a émis :" + informationGeneree +"(PASSAGE AU TRANSMETTEUR)");
		 
	}
	
	
	
}
