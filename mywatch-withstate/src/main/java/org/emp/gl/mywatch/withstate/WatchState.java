/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch.withstate;

import org.emp.gl.time.action.TimeActionInterface;
import java.lang.NullPointerException;
/**
 *
 * @author ahmed
 */
abstract public class WatchState implements TimeActionInterface{
    protected  MyWatch watch ;
    private WatchState(){}
    public WatchState(MyWatch w)
    {
        if (w==null) {
        throw new NullPointerException();
           //on peut pas instancier un objet watch state sans cree un objet mywatch
          
        }
        watch=w;
    }
    
    @Override
    public abstract void doConfig() ;
        
    

    @Override
    public abstract void doMode() ;

    @Override
    public abstract void doIncrement() ;
    
}
