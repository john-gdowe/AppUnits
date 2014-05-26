package controle;

import referentiel.Unite;
import referentiel.Valeur;



public class Conversion {
	
    private double facteur_conv;
    private Unite unite_in;
    private Unite unite_out;

    
   	public double getFacteur_conv() {
		return facteur_conv;
	}
	public void setFacteur_conv(double facteur_conv) {
		this.facteur_conv = facteur_conv;
	}
	public Unite getUnite_in() {
		return unite_in;
	}
	public void setUnite_in(Unite unite_in) {
		this.unite_in = unite_in;
	}
	public Unite getUnite_out() {
		return unite_out;
	}
	public void setUnite_out(Unite unite_out) {
		this.unite_out = unite_out;
	}
	
	
	 public Valeur convertir(Unite unite_in, Unite unite_out, double quantite, boolean meme_systeme) {
		 
		 double val_in, val_out, val_coef;
		 val_coef=1;
		 
		 // on multiplie la quantité souhaitée par le coef et on stocke le résultat dans la valeur de l'unité
		 val_in= quantite*Math.pow(10, unite_in.getCoef()) ;
		 unite_in.getValeur().setVal(val_in);
		 
		 // si on est dans le même système, on passe la valeur directement
		 if (meme_systeme){
			 val_coef= val_in;

		//Sinon, on la multiplie par le facteur de conversion
		 }else{
			 //val_coef= val_in* le coef de la mesure
		 }
		 
		 // on multiplie le résultat par le coef de l'unité de sortie et on sotcke le résultat dans la valeur de l'unité
		 val_out= val_coef*Math.pow(10, unite_out.getCoef()) ;
		 unite_out.getValeur().setVal(val_out);
		 
		 
		 return unite_out.getValeur();
	    }
}
