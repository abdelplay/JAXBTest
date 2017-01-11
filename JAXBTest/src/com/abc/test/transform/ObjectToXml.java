package com.abc.test.transform;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.abc.test.jaxb.Bibliotheque;
import com.abc.test.jaxb.ObjectFactory;

public class ObjectToXml {


	  public static void main(String[] args) {
	    try {
	      JAXBContext context = JAXBContext.newInstance(Bibliotheque.class);
	      Marshaller m = context.createMarshaller();
	      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	      ObjectFactory fabrique = new ObjectFactory();
	      Bibliotheque bibliotheque = fabrique.createBibliotheque();

	      Bibliotheque.Livre livre = fabrique.createBibliothequeLivre();
	      livre.setEditeur("editeur 1");
	      livre.setTitre("titre 1");

	      Bibliotheque.Livre.Auteur auteur = fabrique
	          .createBibliothequeLivreAuteur();
	      auteur.setNom("nom 1");
	      auteur.setPrenom("prenom 1");
	      livre.setAuteur(auteur);

	      bibliotheque.getLivre().add(livre);

	     // m.marshal(bibliotheque, System.out); ==> afficher le flux sur la console
	      m.marshal(bibliotheque, new File("bibliotheque.xml"));
	    } catch (JAXBException ex) {
	      ex.printStackTrace();
	    }
	  }
}
