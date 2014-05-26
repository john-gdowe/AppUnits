package referentiel;

import java.util.ArrayList;
import java.util.List;

public class Mesure {

    // Le type de la mesure
    private String nomMesure;

    // La liste des unités qui lui sont rattachées
    private List<Unite> listeUnites;

    public Mesure() {
	this.listeUnites = new ArrayList<Unite>();
    }

    public Mesure(String nomMesure, List<Unite> listeUnites) {
	this.nomMesure = nomMesure;
	this.listeUnites = listeUnites;
    }

    public String getNomMesure() {
	return nomMesure;
    }

    public void setNomMesure(String nomMesure) {
	this.nomMesure = nomMesure;
    }

    public List<Unite> getListeUnites() {
	return listeUnites;
    }

    public void setListeUnites(List<Unite> listeUnites) {
	this.listeUnites = listeUnites;
    }

    public void ajoutUnite(Unite u) {
	this.listeUnites.add(u);
    }

    @Override
    public String toString() {
	return "Mesure [nomMesure=" + nomMesure + ", listeUnites="
		+ listeUnites + "]";
    }
}
