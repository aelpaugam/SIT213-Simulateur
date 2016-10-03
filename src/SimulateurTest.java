

import static org.junit.Assert.*;

import org.junit.Test;

public class SimulateurTest {

	//Création d'un simple message de 3 bits taille fixe
	@Test
	public void testSimulateur_valide1() throws ArgumentsException {
		String args[] = new String[2];
		args[0] = "-mess";
		args[1] = "10101";
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires (sans seed)	
	@Test
	public void testSimulateur_valide2() throws ArgumentsException {

		String args[] = new String[2];
		args[0] = "-mess";
		args[1] = "123";
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires (avec seed)
	@Test
	public void testSimulateur_valide3() throws ArgumentsException {

		String args[] = new String[4];
		args[0] = "-mess";
		args[1] = "123";
		args[2] = "-seed";
		args[3] = "321";
		new Simulateur(args);
	}

	//Création d'un simple message de 16 bits taille fixe avec une sonde apr�s
	@Test
	public void testSimulateur_valide4() throws ArgumentsException {
		String args[] = new String[3];
		args[0] = "-mess";
		args[1] = "1101001000011111";
		args[2] = "-s";
		new Simulateur(args);
	}

	//Création d'un simple message de 16 bits taille fixe avec une sonde avant
	@Test
	public void testSimulateur_valide5() throws ArgumentsException {
		String args[] = new String[3];
		args[0] = "-s";
		args[1] = "-mess";
		args[2] = "1101001000011111";
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires avec une sonde, (sans seed)
	@Test
	public void testSimulateur_valide6() throws ArgumentsException {
		String args[] = new String[3];
		args[0] = "-mess";
		args[1] = "123";
		args[2] = "-s";			
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires avec une sonde, (avec seed)
	@Test
	public void testSimulateur_valide7() throws ArgumentsException {

		String args[] = new String[5];
		args[0] = "-mess";
		args[1] = "123";
		args[2] = "-s";	
		args[3] = "-seed";
		args[4] = "555";
		new Simulateur(args);
	}


	//Création d'un  message avec un argument erronné
	@Test(expected=ArgumentsException.class)
	public void testSimulateur_invalide1() throws ArgumentsException {
		String args[] = new String[2];
		args[0] = "-less";
		args[1] = "10101";
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires (sans seed) avec argument erronné
	@Test(expected=ArgumentsException.class)
	public void testSimulateur_invalide2() throws ArgumentsException {
		String args[] = new String[2];
		args[0] = "-less";
		args[1] = "123";
		new Simulateur(args);
	}

	//Création d'un message de 123 bits aléatoires (sans seed) avec argument erronné
	@Test(expected=ArgumentsException.class)
	public void testSimulateur_invalide3() throws ArgumentsException {
		String args[] = new String[4];
		args[0] = "-less";
		args[1] = "123";
		args[2] = "-seed";
		args[3] = "-seed";
		new Simulateur(args);
	}

	//Création d'un  message avec un argument erronné, avec une sonde
	@Test(expected=ArgumentsException.class)
	public void testSimulateur_invalide4() throws ArgumentsException {
		String args[] = new String[3];
		args[0] = "-less";
		args[1] = "10101";
		args[2] = "-s";
		new Simulateur(args);
	}


	//Création d'un message de 123 bits aléatoires avec une sonde, argument erronné (sans seed)
	@Test(expected = ArgumentsException.class)
	public void testSimulateur_invalide5() throws ArgumentsException {
		String args[] = new String[3];
		args[0] = "-less";
		args[1] = "123";
		args[2] = "-s";			
		new Simulateur(args);
	}


	//Création d'un message de 123 bits aléatoires avec une sonde, argument erronné (avec seed)
	@Test
	public void testSimulateur_invalide6() throws ArgumentsException {
		String args[] = new String[5];
		args[0] = "-mess";
		args[1] = "123";
		args[2] = "-s";	
		args[3] = "-seed";
		args[4] = "555";
		new Simulateur(args);
	}

	//Atteinte des limites pour suite binaire
	@Test(expected = ArgumentsException.class)
	public void testSimulateur_invalide7() throws ArgumentsException {
		String args[] = new String[2];
		args[0] = "-mess";
		args[1] = "56432124165795";
		new Simulateur(args);
	}

	//Mauvaise seed, seed is a char
	@Test(expected = ArgumentsException.class)
	public void testSimulateur_invalide8() throws ArgumentsException {
		String args[] = new String[4];
		args[0] = "-mess";
		args[1] = "123546";
		args[2] = "-seed";
		args[3] = "f"; // -seed attends un Integer
		new Simulateur(args);
	}

	//Mauvaise seed, seed is a float
	@Test(expected = ArgumentsException.class)
	public void testSimulateur_invalide10() throws ArgumentsException {
		String args[] = new String[4];
		args[0] = "-mess";
		args[1] = "123546";
		args[2] = "-seed";
		args[3] = "9.56"; // -seed attends un Integer
		new Simulateur(args);
	}


	@Test
	public void testExecute_valide() throws Exception   {
		String args[] = new String[2];
		args[0]="-mess";
		args[1]="123";

		Simulateur sim=new Simulateur(args);
		sim.execute();
	}

	@Test
	public void testConnection_valide1() throws Exception {
		String args[] = new String[2];
		args[0]="-mess";
		args[1]="123";

		Simulateur sim=new Simulateur(args);
		sim.connection();
	}

	@Test
	public void testConnection_valide2() throws Exception {
		String args[] = new String[3];
		args[0]="-mess";
		args[1]="123";
		args[2]="-s";

		Simulateur sim=new Simulateur(args);
		sim.connection();
	}

	@Test
	public void testCalculTauxErreurBinaire_valide() {
		String args[] = new String[2];
		args[0]="-mess";
		args[1]="123";


		//Simulateur sim=new Simulateur(args);
		//assertEquals("TEB",sim.calculTauxErreurBinaire(),is(0));//a d�finir
	}


	@Test
	public void testCalculTauxErreurBinaire_invalide() {

	}

}
