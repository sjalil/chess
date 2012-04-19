
package org.me.mybackgroundapp;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JLabel;

public interface MoveInterface  extends Remote{
    
    public void moveRemote(JLabel x,int locx,int locy) throws RemoteException;
    
}
