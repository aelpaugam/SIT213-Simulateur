package sources;

import information.Information;



public class SourceFixe extends Source <Boolean>{

	public SourceFixe (String messageString){
		super(); // Utilisation du constructeur supérieur pour bénéficier des attributs.
		
		Boolean BitsTab [] = new Boolean [messageString.length()]; 
		
		char messageTab[] = messageString.toCharArray();
		
		
		int i = 0;
		for (i = 0;i<messageString.length();i++){
			
			if (messageTab[i] == '0') BitsTab[i] = false; // Attribution de l'état boolean selon la valeur générée.
			
			else BitsTab[i] = true;
		}

		
		this.informationGeneree = new Information <Boolean> (BitsTab);
		
	}
	}

