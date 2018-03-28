package com.out.openvasclient.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NotCloseableInputStream extends FilterInputStream {

	

	public NotCloseableInputStream(InputStream in) {
		super(in);
	}

	@Override
	public void close() throws IOException {}
}
