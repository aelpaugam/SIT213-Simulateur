package destinations;

import information.Information;
import information.InformationNonConforme;

public class DestinationFinale extends Destination <Boolean> {

	/**La fonction recevoir, prend les informations que lui envoie un transmetteur.
	 * @param information le message passé par le transmetteur.
	 */
	public void recevoir(Information <Boolean> information) throws InformationNonConforme {
		this.informationRecue = information;
		
	}

}
