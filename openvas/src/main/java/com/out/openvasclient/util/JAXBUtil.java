package com.out.openvasclient.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBUtil {

	
	public static String marshall(Object obj, Class type) throws JAXBException{
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(type);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		
		marshaller.marshal(obj,writer);
		return writer.toString();
	}
}
