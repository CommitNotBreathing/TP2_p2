package main;


import java.util.ArrayList;

public class Facture {

	static ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	static ArrayList<Plat> listePlat = new ArrayList<Plat>();
	static ArrayList<Client> listeClient = new ArrayList<Client>(); 
	
	
	public Facture(ArrayList<Plat> listePlat,ArrayList<Client> listeClient,ArrayList<Commande> listeCommande) {
	
	}
	
	public static void PrintFacture() {
				
		System.out.println("Bienvenue chez Barette!");
		System.out.println("Factures:");
		
		
				for (Client client : listeClient) {
					double prix = 0;
					for (Commande commande : client.listeCommande) {
						prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
					}
			
					System.out.println(client.getNom()+" "+prix+"$");
			
				}
	}
	
}
