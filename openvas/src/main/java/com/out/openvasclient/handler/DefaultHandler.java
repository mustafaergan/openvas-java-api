/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import com.fasterxml.jackson.dataformat.xml .XmlMapper;
import com.out.openvasclient.OpenVASException;
import com.out.openvasclient.model.responses.Response;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author christoph
 */
public abstract class DefaultHandler<T extends Response> implements ResponseHandler<T> {
    
    protected T response;
    protected String rootTag;
    protected XmlMapper mapper = new XmlMapper();
    
    public DefaultHandler(T response, String rootTag) {
        this.response = response;
        this.rootTag = rootTag;
    }

    @Override
    public int getStatus() {
        return response.getStatus();
    }

    @Override
    public String getStatusText() {
        return response.getStatusText();
    }    
    
    @Override
    public T getResponse() {
        return response;
    }
    
    
    protected void parseRootTag(XMLEvent event){
        StartElement element = event.asStartElement();
        while (element.getAttributes().hasNext()){
            Attribute attribute = (Attribute) element.getAttributes().next();
            if ("status".equals(attribute.getName().toString())){
                response.setStatus(Integer.parseInt(attribute.getValue()));
            } else if ("status_text".equals(attribute.getName().toString())){
                response.setStatusText(attribute.getValue());
            }
        }
    }
    
    protected void parseRootTag(XMLStreamReader parser){
        for (int i = 0; i < parser.getAttributeCount(); i++){
            if ("status".equals(parser.getAttributeName(i).toString())){
                response.setStatus(Integer.parseInt(parser.getAttributeValue(i)));
            } else if ("status_text".equals(parser.getAttributeName(i).toString())) {
                response.setStatusText(parser.getAttributeValue(i));
            }
        }
    }
    
    protected abstract void parseStartElement(XMLStreamReader parser) throws XMLStreamException, IOException;
    
    protected void parseEndElement(XMLStreamReader parser){
    }
    
    @Override
    public void parse(InputStream in) throws OpenVASException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        try{
            XMLStreamReader parser = factory.createXMLStreamReader(in);
        
            parser.nextTag();
            
            
            while (parser.hasNext()){
                
                switch (parser.getEventType()){
                case XMLStreamConstants.START_ELEMENT:
                    if (rootTag.equals(parser.getName().toString())){
                        parseRootTag(parser);
                    } else{
                        parseStartElement(parser);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (rootTag.equals(parser.getLocalName())){
                        return;
                    }else{
                        parseEndElement(parser);
                    }
                    break;
                default:
                    break;
                }
                
                parser.next();
            }
            
            parser.close();
        } catch(XMLStreamException ex){
            throw new OpenVASException(ex);
        } catch(IOException ex ){
            throw new OpenVASException(ex);
        }
    }
}
