package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
	
	@Test
	void testPrixFrite() {
		double prix = Commande.getPrix("Frites");
		
		assertEquals(prix, 2.5);	
	}
	
	@Test
	void testPrixRepasPoulet() {
		double prix = Commande.getPrix("Repas_Poulet");
		
		assertEquals(prix, 15.75);		
	}
	
	@Test
	void testPrixPoutine() {
		
		double prix = Commande.getPrix("Poutine");
		
		
		assertEquals(prix, 10.5);			
	}
	
	@Test
	void testTaxesPoutine() {
		double total = Facture.Taxe(10.5);
		assertEquals(total, 12.075);
	}
	
	@Test
	void testTaxesFrite() {
		double total = Facture.Taxe(2.5);
		assertEquals(total, 2.875);
	}
	
	@Test
	void testTaxesRepasPoulet() {
		double total = Facture.Taxe(15.75);
		assertEquals(total, 18.1125);
	}
	
 
	
	

}
