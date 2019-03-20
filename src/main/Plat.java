package main;


import java.util.ArrayList;

public class Plat {

	static ArrayList<Plat> listePlat = new ArrayList<Plat>();	
	String nom;
	double prix;
	
	
	public Plat (String nom,double  prix) {
	this.nom=nom;
	this.prix=prix;
			
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public double getPrix() {
		return this.prix;
	}
		
	public static void CreatePlats(ArrayList<String> info) {
		
		int debut = info.indexOf("Plats :");
		int fin = info.indexOf("Commandes :");
			
		for (int i = debut + 1; i < fin; i++) {
			String[] lignes = info.get(i).split(" ");
			Plat temp = new Plat(lignes[0], Double.parseDouble(lignes[1]));
			listePlat.add(temp);
		}
		Facture.listePlat=listePlat;
	}
	



}
