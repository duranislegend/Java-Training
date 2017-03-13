package JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

public class Xml2Java {
	public static void main(String[] args){
		try {
			JAXBContext jc = JAXBContext.newInstance(People.class);
			Unmarshaller um = jc.createUnmarshaller();
			File f = new File("os.xml");
			People p = (People)um.unmarshal(f);
			System.out.println(p.id);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


}
