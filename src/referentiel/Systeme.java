package referentiel;

import java.util.ArrayList;
import java.util.List;

public class Systeme {
	
    private String nom_system;
    private List<Mesure> Mesure = new ArrayList<Mesure> ();

    public List<Mesure> getMesure() {
        return this.Mesure;
    }

    public void setMesure(List<Mesure> value) {
       this.Mesure = value;
    }

    public String getNom_system() {
        return this.nom_system;
    }

    public void setNom_system(String value) {
       this.nom_system = value;
    }

 }
