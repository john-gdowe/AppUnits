package referentiel;

import java.util.ArrayList;
import java.util.List;

public class Mesure {
	
    private String nom_mesure;
    
	private List<Unite> unite = new ArrayList<Unite> ();

	public String getNom_mesure() {
		return nom_mesure;
	}
	
	public void setNom_mesure(String nom_mesure) {
		this.nom_mesure = nom_mesure;
	}
	
	public List<Unite> getUnite() {
		return unite;
	}
	
	public void setUnite(List<Unite> unite) {
		this.unite = unite;
	}
}
