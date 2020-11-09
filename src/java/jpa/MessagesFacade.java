/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Messages;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> implements MessagesFacadeLocal {

    @PersistenceContext(unitName = "myWorldMessages-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }

    @Override
    public List<Messages> findBySender(int myID) {
    try{
        return em.createNamedQuery("Messages.findBySenderID",Messages.class)
                .setParameter("senderID", myID).getResultList();
    }catch(Exception e){
    }
    return null;
    }

    @Override
    public List<Messages> findByReceiver(int myID) {
         List<Messages>check=new ArrayList<>();
       try{
        check= em.createNamedQuery("Messages.findByReceiverID",Messages.class)
                .setParameter("receiverID", myID).getResultList();
    }catch(Exception e){
    }
    return check;
    }

    @Override
    public List<Messages> findMyGarbage(int myID) {
        List<Messages>check=new ArrayList<>();
     try{
        check= em.createNamedQuery("Messages.findByToDelete",Messages.class)
                .setParameter("toDelete",false)
                .setParameter("receiverID", myID).getResultList();
    }catch(Exception e){
    }
    return check;
    }

    @Override
    public List<Messages> findMyUnread(int myID) {
    try{
        return em.createNamedQuery("Messages.findMyInbox",Messages.class)
                .setParameter("isRead",false)
                .setParameter("receiverID", myID).getResultList();
    }catch(Exception e){
    }
    return null;
    }
    
}
