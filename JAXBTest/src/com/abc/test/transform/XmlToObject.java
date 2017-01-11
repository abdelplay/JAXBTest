package com.abc.test.transform;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.abc.test.jaxb.Bibliotheque;
import com.abc.test.jaxb.Bibliotheque.Livre;

// generation des objets java à partir d'un fichier xml
public class XmlToObject {

	  public static void main(String[] args) {
	    try {
	      JAXBContext jc = JAXBContext.newInstance("com.abc.test.jaxb");
	      Unmarshaller unmarshaller = jc.createUnmarshaller();
	      Bibliotheque bibliotheque = (Bibliotheque) unmarshaller.unmarshal(
		     new File("biblio.xml"));
	      List<Livre> livres = bibliotheque.getLivre();
	      for (int i = 0; i < livres.size(); i++) {
	      Livre livre = livres.get(i);
	      System.out.println("Livre ");
	      System.out.println("Titre : " + livre.getTitre());
	      System.out.println("Auteur : " + livre.getAuteur().getNom() 
	        + " " +livre.getAuteur().getPrenom());
	      System.out.println("Editeur : " + livre.getEditeur());
	      System.out.println();
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
}
	  }
