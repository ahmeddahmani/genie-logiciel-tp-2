/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author tina
 */
public class AfficheurHeureSurConsole implements TimerChangeListener {
    
    private int heure;
    private int minute;
    private int seconde;
    private int disec;
    
    public AfficheurHeureSurConsole()
    {
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        heure=ts.getHeures();minute=ts.getMinutes();
        seconde=ts.getSecondes();disec=ts.getDixiemeDeSeconde();
    }

    /*@Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        
        System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
    }*/

    // cette méthode provient du PropertyChangeListener 
    // à utiliser plustard ! 
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        switch(pce.getPropertyName())
        {
            case TimerChangeListener.DIXEME_DE_SECONDE_PROP :
                disec=(int)pce.getNewValue();
                break;
            case TimerChangeListener.SECONDE_PROP :
                seconde=(int)pce.getNewValue();
                break;
            case TimerChangeListener.MINUTE_PROP :
                minute=(int)pce.getNewValue();
                break;
            default :
                heure=(int)pce.getNewValue();
        }
        
        System.out.println(""+heure+":"+minute+":"+seconde+","+disec);
        /*TimerService ts = Lookup.getInstance().getService(TimerService.class);
        System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());*/
        
        
    }

}
