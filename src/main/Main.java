package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;




public class Main {
	
	public static ArrayList<String> principale() {
		ArrayList<String> info = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Style.txt"));

			String line;
			while ((line = br.readLine()) !=null) {
					info.add(line);
			}
			
			br.close();
			
			Client.CreateClients(info);
			Plat.CreatePlats(info);
			Commande.CreateCommande(info);
			if (info.isEmpty()) {
				System.out.println("Le fichier est vide, pas de facture a traité");	
			}else {
			Facture.PrintFacture();
			Facture.PrintFactureTxt();
			}
		} catch (Exception e) {
			System.out.println("Le fichier ne respecte pas le format demandé !");
			e.printStackTrace();
		}
		return info;
		
	}
	
	public static void main(String[] args) {
		principale();
	}


}


