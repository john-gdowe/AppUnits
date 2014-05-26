package referentiel;

public class Unite {

    private String nomUnite;
    private int coefUnite;
    private Valeur valeurUnite;

    public Unite() {
    }

    public Unite(String nomUnite, int coefUnite, Valeur valeurUnite) {
	this.nomUnite = nomUnite;
	this.coefUnite = coefUnite;
	this.valeurUnite = valeurUnite;
    }

    public String getNomUnite() {
	return nomUnite;
    }

    public void setNomUnite(String nomUnite) {
	this.nomUnite = nomUnite;
    }

    public int getCoefUnite() {
	return coefUnite;
    }

    public void setCoefUnite(int coefUnite) {
	this.coefUnite = coefUnite;
    }

    public Valeur getValeurUnite() {
	return valeurUnite;
    }

    public void setValeurUnite(Valeur valeurUnite) {
	this.valeurUnite = valeurUnite;
    }

    @Override
    public String toString() {
	return "Unite [nomUnite=" + nomUnite + ", coefUnite=" + coefUnite
		+ ", valeurUnite=" + valeurUnite + "]";
    }
}
