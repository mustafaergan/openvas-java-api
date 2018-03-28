/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.out.openvasclient.handler;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.out.openvasclient.model.resources.tasks.Task;
import com.out.openvasclient.model.responses.GetTasksResponse;

import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author christoph
 */
public class GetTasksResponseHandler extends DefaultHandler<GetTasksResponse>{

    
    public GetTasksResponseHandler() {
        super(new GetTasksResponse(), "get_tasks_response");
        AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector pair = new AnnotationIntrospectorPair(primary, secondary);
        mapper.setAnnotationIntrospector(pair);
    }
    
    @Override
    protected void parseStartElement(XMLStreamReader parser)  throws XMLStreamException, IOException {
        if ("task".equals(parser.getName().toString())){
            Task task = mapper.readValue(parser, Task.class);
            response.addTask(task);
        }
    }
    
    
}
