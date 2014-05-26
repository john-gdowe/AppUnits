package controle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import referentiel.Systeme;
import referentiel.Systeme;

public class Moteur {
	
    private List<Systeme> Systeme = new ArrayList<Systeme> ();
	private Conversion conversion;
    
	
    public List<Systeme> getSysteme() {
		return Systeme;
	}
	public void setSysteme(List<Systeme> Systeme) {
		this.Systeme = Systeme;
	}
	public Conversion getConversion() {
		return conversion;
	}
	public void setConversion(Conversion conversion) {
		this.conversion = conversion;
	}

    public void parsing(){
    	try {
    		 
    		File fXmlFile = new File("reference.xml");
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		Document doc = dBuilder.parse(fXmlFile);
    	 
    		//optional, but recommended
    		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    		doc.getDocumentElement().normalize();
    	 
    		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    	 
    		NodeList nList = doc.getElementsByTagName("staff");
    	 
    		System.out.println("----------------------------");
    	 
    		for (int temp = 0; temp < nList.getLength(); temp++) {
    	 
    			Node nNode = nList.item(temp);
    	 
    			System.out.println("\nCurrent Element :" + nNode.getNodeName());
    	 
    			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    	 
    				Element eElement = (Element) nNode;
    	 
    				System.out.println("Staff id : " + eElement.getAttribute("id"));
    				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
    				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
    				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
    				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
    	 
    			}
    		}
    	    } catch (Exception e) {
    		e.printStackTrace();
    	    }
    }

}
