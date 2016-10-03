package transmetteurs;


import destinations.DestinationInterface;
import information.Information;
import information.InformationNonConforme;

public class TransmetteurParfait extends Transmetteur <Boolean,Boolean> {
	
	/** Le constructeur de TransmetteurParfait est celui de la classe
	 * Transmetteur dont il hérite. Il ne prend pas de paramètres.
	 */
	
	public TransmetteurParfait(){
		
	super();
	}
	
	
	  /** La méthode recevoir permet au transmetteur
  	 * de stocker un message reçu en vu d'un traitement ultérieur.
  	 * D'une manière générale c'est un objet de classe Source qui 
  	 * appelle cette méthode.
     * @param information le message passé au transmetteur
     */   
	public void recevoir(Information <Boolean> information) throws InformationNonConforme {
		this.informationRecue = information; 
		this.emettre();		
	}
	  /** La méthode émettre transmet le message à la destination
	 * Il s'agit de l'information émise qui a été traitée 
	 * pour simuler le canal. 
	 * Elle appelle la fonction recevoir des destinations finales retenues.
	 * (destinations et sondes).
	 */
	public void emettre() throws InformationNonConforme {
		//Ici pas de traitement on envoie l'information tel qu'on l'a reçu
		this.informationEmise = informationRecue;
	
		//Boucle de parcours des différentes destinations connectées.
		for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(informationEmise);
            
		}
	}

}
