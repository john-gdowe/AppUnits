package referentiel;

public class Valeur {

    private Double val;

    public Valeur() {
    }

    public Valeur(Double v) {
	this.val = v;
    }

    public double getVal() {
	return this.val;
    }

    public void setVal(Double val) {
	this.val = val;
    }

    @Override
    public String toString() {
	return "Valeur [val=" + val + "]";
    }
}
