/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Messages;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import jpa.MessagesFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class CreateMessageController_EJB {
  private int myID;
private int receiverID;
private String titel;
private String message;
private Date now;
private Messages messages;
private String receiver;
private int zeichen;
private final int maxZeichen=500;
private int inbox;

@Inject
private MessagesFacadeLocal messageFacade;


public String prepareMessage(int myID, int receiverID,String receiverName){
    setMyID(myID);
    setReceiverID(receiverID);
    setReceiver(receiverName);
    setZeichen(maxZeichen);
    
 return "/secured/user/messages/createMessage?faces-redirect=true";
}
public String prepareChatRequest(int myID, int receiverID,String chatroomName){
    setMyID(myID);
    setReceiverID(receiverID);
    setTitel(chatroomName);
    setZeichen(maxZeichen);
    
 return "/secured/user/messages/createMessage?faces-redirect=true";
}
   public void prepareCreateMessage(){
   
   }
public void send(){
    try{
    messages=new Messages();
messages.setBetreff(titel);
messages.setIsRead(false);
messages.setToDelete(false);
now=new Date();
messages.setWann(now);
messages.setSenderID(myID);
messages.setReceiverID(receiverID);
messages.setMessage(message);
messageFacade.create(messages);
    System.err.println("messages? "+messageFacade.count());
  FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_INFO, "Message created", " created"));  
    }catch(Exception e){
    FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Message send Failure", "Error"));
    }
}

public void test(){
    setZeichen(maxZeichen-message.length());
}
    public int getZeichen() {
        return zeichen;
    }

    public void setZeichen(int zeichen) {
        this.zeichen = zeichen;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }



    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setZeichen(maxZeichen-message.length());
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }




}
