/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch.withstate;

/**
 *
 * @author ahmed
 */
public class NormalState extends WatchState{

    public NormalState(MyWatch w) {
        super(w);
    }
   
    
    @Override
    public void doConfig() {
        watch.setState(new SecondeSettingState(watch));
        
    }

    @Override
    public void doMode() {
        
    }

    @Override
    public void doIncrement() {
           }

   
    
}
