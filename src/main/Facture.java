package main;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Facture {

	static ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	static ArrayList<Plat> listePlat = new ArrayList<Plat>();
	static ArrayList<Client> listeClient = new ArrayList<Client>(); 
	
	
	public Facture(ArrayList<Plat> listePlat,ArrayList<Client> listeClient,ArrayList<Commande> listeCommande) {
	
	}
	
	public static int PrintFacture() {
		DecimalFormat format = new DecimalFormat("##.00");
		int nbErreur = 0;
		System.out.println("Facture qui sont égale a 0$:");
		
		for (Client client : listeClient) {
			double prix = 0;
			for (Commande commande : client.listeCommande) {
				prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
				prix = Taxe(prix);
				
			}

			if (prix==0) {
			System.out.println(client.getNom()+" "+format.format(prix)+"$");
			nbErreur++;
			}
			
		}
		
		System.out.println(".");
		
		System.out.println("Bienvenue chez Barette!");
		System.out.println("Factures:");
		
				for (Client client : listeClient) {
					double prix = 0;
					for (Commande commande : client.listeCommande) {
						prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
						prix = Taxe(prix);
						
					}
		
					if (prix!=0) {
					System.out.println(client.getNom()+" "+format.format(prix)+"$");
					}
					
				}
			return nbErreur;
	}
	
	public static PrintWriter PrintFactureTxt() throws FileNotFoundException, UnsupportedEncodingException {
		
		DecimalFormat format = new DecimalFormat("##.00");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm");
		String time = new String(java.time.LocalTime.now().format(dtf));
		
		PrintWriter writer = new PrintWriter("Facture-du-"+java.time.LocalDate.now()+"-"+time+".txt", "UTF-8");
		
		writer.println("Facture qui sont égale a 0$:");
		
		for (Client client : listeClient) {
			double prix = 0;
			for (Commande commande : client.listeCommande) {
				prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
				prix = Taxe(prix);
				
			}

			if (prix==0) {
				writer.println(client.getNom()+" "+format.format(prix)+"$");
			}
			
		}
		
		writer.println(".");
		
		writer.println("Bienvenue chez Barette!");
		writer.println("Factures:");
		
				for (Client client : listeClient) {
					double prix = 0;
					for (Commande commande : client.listeCommande) {
						prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
						prix = Taxe(prix);
					}
					if(prix!=0) {
					writer.println(client.getNom()+" "+format.format(prix)+"$");
					}
				}
		writer.close();
		
		return writer;
	}
	//les taxes sont arrondie a la baisse
	public static double Taxe(double prix) {
		
		prix += prix*0.15;
		
		return prix;
		
	}
	
}
