package JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;

import cc.ccs.chap6.ArrayList;


public class Java2Xml {
	public static void main(String[] args)  {
		try {
			JAXBContext jc = JAXBContext.newInstance(People.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_FRAGMENT, false);
			OutputStream of = new FileOutputStream("os.xml");
			People p = new People();
			m.marshal(p, of);
		} catch (FileNotFoundException |JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
