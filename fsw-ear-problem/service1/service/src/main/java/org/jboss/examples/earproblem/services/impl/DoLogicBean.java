package org.jboss.examples.earproblem.services.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("LogicBean")
@ApplicationScoped
public class DoLogicBean {

    private String _message = "Injection success!";

    public DoLogicBean() {
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }
}