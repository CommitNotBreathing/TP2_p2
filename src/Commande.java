

import java.util.ArrayList;

public class Commande {
	
	static ArrayList<Commande> listeCommande = new ArrayList<Commande>();	
	String nom;
	String plat;
	double nbArticle;

	public Commande (String nom,String plat,double nbArticle) {
	this.nom=nom;
	this.plat=plat;
	this.nbArticle = nbArticle;

	}

	public String getNom() {
		return this.nom;
	}
	
	public String getPlat() {
		return this.plat;
	}
	
	public double getnbArticle() {
		return this.nbArticle;
	}
	
	public double getPrix(String nom) {
		double prix = 0;
		switch (nom) {
		case "Poutine":
			prix = 10.5;
			break;
		case "Frites":
			prix = 2.5;
			break;
		case "Repas_Poulet":
			prix = 15.75;
			break;
		}
		return prix;
	}
	
	
	public static void CreateCommande(ArrayList<String> info) {
		
		int debut = info.indexOf("Commandes :");
		int fin = info.indexOf("Fin");
		
		
		for (int i = debut + 1; i < fin; i++) {
			String[] lignes = info.get(i).split(" ");
			Commande temp = new Commande(lignes[0], lignes[1],Double.parseDouble(lignes[2]));			
			listeCommande.add(temp);
		}
		Client.Client_Commande(listeCommande);
	Facture.listeCommande=listeCommande;
	}
}