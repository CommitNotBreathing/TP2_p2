package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import main.Client;
import main.Commande;
import main.Facture;
import main.Main;
import main.Plat;

public class TestUnitaire {

	@org.junit.jupiter.api.Test
	//Test qui demontre que les liste sont pas null donc ils contiennent client,plat,commande
	public void testClient() {
		ArrayList<Client> listetest;
		listetest = Client.CreateClients(Main.principale());
		assertNotNull(listetest);
			
	}
	@org.junit.jupiter.api.Test
	public void testPlat() {
		ArrayList<Plat> listetest;
		listetest = Plat.CreatePlats(Main.principale());
		assertNotNull(listetest);
			
	}
	@org.junit.jupiter.api.Test
	public void testCommande() {
		ArrayList<Commande> listetest;
		listetest = Commande.CreateCommande(Main.principale());
		assertNotNull(listetest);
			
	}
	@org.junit.jupiter.api.Test
	public void testLecture() {
		//si lecture null alors elle n'a pas bien été faites ou mauvais format 
		assertNotNull(Main.principale());
	}
	@org.junit.jupiter.api.Test
	public void testErreurFacture() {
		int nbErreur = Facture.PrintFacture();
		assertEquals(1,nbErreur);
		
	}
	
	
	@org.junit.jupiter.api.Test
	public void testFichierTxt() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = Facture.PrintFactureTxt();
		//not null quand le fichier txt est écrit
		assertNotNull(writer);
	}
	
	
	
	
	

}
