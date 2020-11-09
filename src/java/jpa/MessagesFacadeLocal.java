/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Messages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface MessagesFacadeLocal {

    void create(Messages messages);

    void edit(Messages messages);

    void remove(Messages messages);

    Messages find(Object id);

    List<Messages> findAll();

    List<Messages> findRange(int[] range);

    int count();
    List<Messages>findBySender(int myID);//messages outgoing
    List<Messages>findByReceiver(int myID);//messages incoming
    List<Messages>findMyGarbage(int myID);//my toDelete messages
    List<Messages>findMyUnread(int myID);//my unreaded messages
}
