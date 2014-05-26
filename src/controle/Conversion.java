package controle;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import referentiel.Unite;
import referentiel.Valeur;

public abstract class Conversion {

    private static String nomFic = "unites.xml";

    public static Double getFacteurConversion(Integer idSysIn,
	    Integer idSysOut, Integer idMes) {

	try {

	    File fXmlFile = new File(System.getProperty("user.dir")
		    + "/src/files/" + nomFic);

	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory
		    .newInstance();

	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	    Document doc = dBuilder.parse(fXmlFile);

	    Double facteur = (double) 0;

	    // optional, but recommended
	    // read this -
	    // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    doc.getDocumentElement().normalize();

	    NodeList nListSysDep = doc.getElementsByTagName("systeme_depart");

	    // Recherche du Syst�me de d�part sur la base de l'id_depart
	    for (int i = 0; i < nListSysDep.getLength(); i++) {
		Element sysDep = (Element) nListSysDep.item(i);

		if (Integer.parseInt(sysDep.getAttribute("id_depart")) == idSysIn) {

		    NodeList nListSysAr = sysDep
			    .getElementsByTagName("systeme_arrivee");

		    // Recherhce du Syst�me d'arriv�e sur la base de
		    // l'id_arriv�e
		    for (int j = 0; j < nListSysAr.getLength(); j++) {
			Element sysAr = (Element) nListSysAr.item(j);

			if (Integer.parseInt(sysAr.getAttribute("id_arrivee")) == idSysOut) {

			    // Une fois le syst�me d'arriv�e trouv�, on
			    // recherche la bonne mesure

			    NodeList nListMes = sysAr
				    .getElementsByTagName("mesure");

			    // Recherhce de la bonne mesure
			    for (int k = 0; k < nListMes.getLength(); k++) {
				Element mes = (Element) nListMes.item(k);

				if (Integer.parseInt(mes
					.getAttribute("id_mesure")) == idMes) {

				    // On peut enfin r�cup�rer le facteur de
				    // conversion

				    NodeList n = mes
					    .getElementsByTagName("taux_conversion");

				    facteur = Double.parseDouble(n.item(0)
					    .getTextContent());
				}
			    }
			}
		    }
		}
	    }
	    // On retourne le facteur de conversion
	    return facteur;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static Valeur convertir(Integer idSysIn, Integer idSysOut,
	    Integer idMes, Unite uniteIn, Unite uniteOut, Double quantite,
	    boolean memeSysteme) {

	Double val_in, val_out, val_coef;

	// On multiplie la quantit� souhait�e par le coef de l'unit� d'entr�e
	// pour obtenir sa valeur dans l'unit� de r�f�rence de la mesure
	val_in = quantite * Math.pow(10, uniteIn.getCoefUnite());

	// On la stocke dans l'unit� d'entr�e
	uniteIn.getValeurUnite().setVal(val_in);

	// Si les unit�s d'entr�e et de sortie sont dans le m�me syst�me alors
	// on applique le coeff de sortie sur la valeur dans l'unit� de
	// r�f�rence
	if (memeSysteme) {
	    val_out = val_in * Math.pow(10, uniteOut.getCoefUnite());
	}
	// Sinon on applique le facteur de conversion entre syst�mes puis le
	// coeff de l'unit� de sortie.
	else {
	    val_out = val_in * getFacteurConversion(idSysIn, idSysOut, idMes)
		    * Math.pow(10, uniteOut.getCoefUnite());
	}

	// On stocke la valeur de sortie dans l'unit� de sortie
	uniteOut.getValeurUnite().setVal(val_out);

	return uniteOut.getValeurUnite();
    }

    // private static Map<String, V> listeFacteurs;
    // private Unite unite_in;
    // private Unite unite_out;
    //
    // public double getFacteur_conv() {
    // return facteur_conv;
    // }
    //
    // public void setFacteur_conv(double facteur_conv) {
    // this.facteur_conv = facteur_conv;
    // }
    //
    // public Unite getUnite_in() {
    // return unite_in;
    // }
    //
    // public void setUnite_in(Unite unite_in) {
    // this.unite_in = unite_in;
    // }
    //
    // public Unite getUnite_out() {
    // return unite_out;
    // }
    //
    // public void setUnite_out(Unite unite_out) {
    // this.unite_out = unite_out;
    // }

    // public Valeur convertir(Unite unite_in, Unite unite_out, double quantite,
    // boolean meme_systeme) {
    //
    // double val_in, val_out, val_coef;
    // val_coef = 1;
    //
    // // on multiplie la quantit� souhait�e par le coef et on stocke le
    // // r�sultat dans la valeur de l'unit�
    // val_in = quantite * Math.pow(10, unite_in.getCoef());
    // unite_in.getValeur().setVal(val_in);
    //
    // // si on est dans le m�me syst�me, on passe la valeur directement
    // if (meme_systeme) {
    // val_coef = val_in;
    //
    // // Sinon, on la multiplie par le facteur de conversion
    // } else {
    // // val_coef= val_in* le coef de la mesure
    // }
    //
    // // on multiplie le r�sultat par le coef de l'unit� de sortie et on
    // // sotcke le r�sultat dans la valeur de l'unit�
    // val_out = val_coef * Math.pow(10, unite_out.getCoef());
    // unite_out.getValeur().setVal(val_out);
    //
    // return unite_out.getValeur();
    // }
}
