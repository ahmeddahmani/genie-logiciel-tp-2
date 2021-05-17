/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author ahmed
 */
public class TimerServiceImplWithDelegation extends TimerTask implements TimerService{
int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;
    private PropertyChangeSupport PCS=null ;
    private PropertyChangeEvent pce=null ;

    /**
     * Constructeur du DummyTimeServiceImpl Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de
     * réaliser des tocs à chaque N millisecondes
     */
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();
        this.PCS =new PropertyChangeSupport(this);
        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        PCS.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        PCS.removePropertyChangeListener(pl);
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        // informer les listeners ! 
         pce=new PropertyChangeEvent(this,TimerChangeListener.DIXEME_DE_SECONDE_PROP,
                    oldValue, dixiemeDeSeconde);
         PCS.firePropertyChange(pce);
           

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    protected void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;
       pce=new PropertyChangeEvent(this,TimerChangeListener.SECONDE_PROP,
                    oldValue, secondes);
       PCS.firePropertyChange(pce);
            
        

        if (secondes == 0) {
            updateMinutes();
        }
    }

    protected void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;
        pce=new PropertyChangeEvent(this,TimerChangeListener.MINUTE_PROP,
                    oldValue, minutes);
        PCS.firePropertyChange(pce);
                
      

        if (minutes == 0) {
            updateHeures();
        }
    }

    protected void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;
        pce=new PropertyChangeEvent(this,TimerChangeListener.HEURE_PROP,
                    oldValue, heures);
        PCS.firePropertyChange(pce);
        
            
        
    }

}
   
    
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */








