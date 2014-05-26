package referentiel;

import java.util.ArrayList;
import java.util.List;

public class Systeme {

    private String nomSysteme;
    private List<Mesure> listeMesures;

    public Systeme() {
	this.listeMesures = new ArrayList<Mesure>();
    }

    public Systeme(String nom) {
	this.nomSysteme = nom;
	this.listeMesures = new ArrayList<Mesure>();
    }

    public Systeme(String nom, List<Mesure> liste) {
	this.nomSysteme = nom;
	this.listeMesures = liste;
    }

    public String getNomSysteme() {
	return nomSysteme;
    }

    public void setNomSysteme(String nomSysteme) {
	this.nomSysteme = nomSysteme;
    }

    public List<Mesure> getListeMesures() {
	return listeMesures;
    }

    public void setListeMesures(List<Mesure> listeMesures) {
	this.listeMesures = listeMesures;
    }

    public void ajoutMesure(Mesure m) {
	this.listeMesures.add(m);
    }

    @Override
    public String toString() {
	return "Systeme [nomSysteme=" + nomSysteme + ", listeMesures="
		+ listeMesures + "]";
    }
}
