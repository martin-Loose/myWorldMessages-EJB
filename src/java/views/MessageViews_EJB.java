/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Messages;
import helperClass.MessagesSenderHelperClass;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.MessagesFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class MessageViews_EJB {
 private List<Messages>myMessages=new ArrayList<>();
 private List<MessagesSenderHelperClass> myList=new ArrayList<>();
 private MessagesSenderHelperClass helper;
 private Messages selectedMessage;
 private int inbox;
 private int garbage;
 private int outbox;
 private int unread;
 private int archive;
 private int myID;
 private String absender;
 List<Messages>lstInbox=new ArrayList<>();
 @Inject
 private MessagesFacadeLocal messagesFacade;

    public void MessageViews_EJB() {
         
    try{
        setLstInbox(messagesFacade.findMyUnread(myID));
    setInbox(lstInbox.size());
    }catch(NullPointerException n){
            
     }
    }

    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }

    public List<MessagesSenderHelperClass> getMyList() {
        return myList;
    }

    public MessagesSenderHelperClass getHelper() {
        return helper;
    }

    public void setHelper(MessagesSenderHelperClass helper) {
        this.helper = helper;
    }

    public void setMyList(List<MessagesSenderHelperClass> myList) {
        this.myList = myList;
    }

    public List<Messages> getLstInbox(int myID) {
         try{
        lstInbox=messagesFacade.findMyUnread(myID);
    setInbox(lstInbox.size());
    }catch(NullPointerException n){
            
     }
        return lstInbox;
    }

    public void setLstInbox(List<Messages> lstInbox) {
        this.lstInbox = lstInbox;
    }

 
    public List<Messages> getMyMessages() {
        
        try{
    
        }catch(NullPointerException n){
    }
        return myMessages;
    }

    public void setMyMessages(List<Messages> myMessages) {
        this.myMessages = myMessages;
    }

    public Messages getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(int id) {
        this.selectedMessage = messagesFacade.find(id);
        setAbsender("dummy");
        
    }

    public int getInbox() {
        return inbox;
    }

    public void setInbox(int inbox) {
        this.inbox = inbox;
    }

    public int getGarbage() {
        return garbage;
    }

    public void setGarbage(int garbage) {
        this.garbage = garbage;
    }

    public int getOutbox() {
        return outbox;
    }

    public void setOutbox(int outbox) {
        this.outbox = outbox;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }
 
 
 
}
