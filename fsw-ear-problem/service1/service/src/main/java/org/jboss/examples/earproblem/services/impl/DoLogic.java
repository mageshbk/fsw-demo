package org.jboss.examples.earproblem.services.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

//@XmlRootElement(namespace="urn:org.jboss.examples.earproblem.services:1.0")
//@XmlAccessorType(XmlAccessType.FIELD)
@Named
@ApplicationScoped
public class DoLogic {

    //@XmlElement
    private String _message;

    //@Inject @Named("LogicBean")
    //private DoLogicBean _bean;

    public DoLogic() {
    }

    public String getMessage() {
        //System.out.println(_bean.getMessage());
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }
}