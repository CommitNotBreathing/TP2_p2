package main;


import java.util.ArrayList;

public class Client {
	
	static ArrayList<Client> listeClient = new ArrayList<Client>();
	ArrayList<Commande> listeCommande= new ArrayList<Commande>();
	
	String nom;
	
	public Client(String nom) {
		this.nom = nom;
		this.listeCommande = new ArrayList<Commande>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public static void CreateClients(ArrayList<String> info) {
	
		int debut = info.indexOf("Clients :");
		int fin = info.indexOf("Plats :");				
		
		for (int i = debut + 1; i < fin; i++) {
			
			
			listeClient.add(new Client(info.get(i)));
		}
		
		Facture.listeClient=listeClient;
	
		
	}
	
	public static void Client_Commande(ArrayList<Commande> commandes) {
		
		for (Client c : listeClient) {
			commandes.forEach(commande -> {
				if (commande.getNom().equals(c.getNom())) {
					c.listeCommande.add(commande);
				}
			});
		}
		
		
	}
	


}
