/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.mywatch.withstate;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.action.TimeActionInterface;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

/**
 *
 * @author ahmed
 */
public class MyWatch extends TimerServiceImplWithDelegation implements TimeActionInterface{
    public MyWatch(){
    super();
        Lookup.getInstance().register(TimeActionInterface.class, this);
    }
    private WatchState ws =new NormalState(this);
    public void setState(WatchState nws)
    {
    ws=nws;
    }
    public void updateSec()
    {
        this.updateSecode();
    }
    public void updateMin()
    {
        this.updateMinutes();
    }
    public void updateHours()
    {
        this.updateHeures();
    }
    @Override
    public void doConfig() {
        ws.doConfig();
        
    }

    @Override
    public void doMode() {
       ws.doMode();
                
    }
    @Override
    public void doIncrement() {
        ws.doIncrement();
    }
    
    
}
