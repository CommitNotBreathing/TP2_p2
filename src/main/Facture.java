package main;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
		
		DecimalFormat format = new DecimalFormat("##.00");
		
				for (Client client : listeClient) {
					double prix = 0;
					for (Commande commande : client.listeCommande) {
						prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
						prix += prix*0.15;
						
					}
		
					if (prix!=0) {
					System.out.println(client.getNom()+" "+format.format(prix)+"$");
					}
				}
	}
	
	public static void PrintFactureTxt() throws FileNotFoundException, UnsupportedEncodingException {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm'.txt'");
		LocalDateTime dateTemps = LocalDateTime.now();
		String datefinal = dateTemps.format(formatter);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm");
		String time = new String(java.time.LocalTime.now().format(dtf));
		
		PrintWriter writer = new PrintWriter("Facture-du-"+java.time.LocalDate.now()+"-"+time+".txt", "UTF-8");
		
		writer.println("Bienvenue chez Barette!");
		writer.println("Factures:");
		
		DecimalFormat format = new DecimalFormat("##.00");
		
				for (Client client : listeClient) {
					double prix = 0;
					for (Commande commande : client.listeCommande) {
						prix += commande.getPrix(commande.getPlat()) * commande.getnbArticle();
						prix += prix*0.15;
					}
					if(prix!=0) {
					writer.println(client.getNom()+" "+format.format(prix)+"$");
					}
				}
		writer.close();
	}
	
}
