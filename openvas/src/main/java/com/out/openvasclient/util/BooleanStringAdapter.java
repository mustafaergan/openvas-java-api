package com.out.openvasclient.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This is an adapter for the boolean values used by the OpenVAS. The Data Type 
 * boolean is defined as follows: 
 * Zero as false, anything else is true. As a result, the empty string is 
 * considered true.
 * 
 * @author Christoph Bless
 */
public class BooleanStringAdapter extends XmlAdapter<String, Boolean> {

	@Override
	public String marshal(Boolean arg) throws Exception {
		if (arg == null){
                    return "1";
		}
		if (!arg){
                    return "0";
		}	
                return "1";
		
	}

	@Override
	public Boolean unmarshal(String arg) throws Exception {
		if ("0".equals(arg)){
			return false;
		}
		return true;
	}

	
}
