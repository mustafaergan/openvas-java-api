package com.out.openvasclient.commands;

import javax.xml.bind.JAXBException;

import com.out.openvasclient.DefaultCommand;
import com.out.openvasclient.handler.AuthenticateResponseHandler;
import com.out.openvasclient.model.requests.AuthenticateRequest;
import com.out.openvasclient.model.requests.Credentials;
import com.out.openvasclient.util.JAXBUtil;

public class AuthenticateCommand extends DefaultCommand<AuthenticateResponseHandler> {

    private final AuthenticateRequest auth;

    public AuthenticateCommand() {
        super("authenticate", false, new AuthenticateResponseHandler());
        auth = new AuthenticateRequest();
        auth.setCredentials(new Credentials());
    }

    @Override
    public String getRequest() throws JAXBException {
        return JAXBUtil.marshall(auth, AuthenticateRequest.class);
    }

    public String getUsername() {
        return auth.getCredentials().getUsername();
    }

    public void setUsername(String username) {
        auth.getCredentials().setUsername(username);
    }

    public String getPassword() {
        return auth.getCredentials().getPassword();
    }

    public void setPassword(String password) {
        auth.getCredentials().setPassword(password);
    }

    @Override
    public boolean isAuthenticationRequired() {
        return false;
    }

}
