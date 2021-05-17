package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.mywatch.withstate.MyWatch;
import org.emp.gl.time.control.GuiControl;
import org.emp.gl.time.display.GuiDisplay;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

/**
 * Hello world!
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
        //Lookup.getInstance().register(TimerService.class,new TimerServiceImplWithDelegation() );
        Lookup.getInstance().register(TimerService.class,new MyWatch() );
    }

    public static void main(String[] args) {

       // testDuTimeService();
       launchApp();
       
    }


    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);

        ts.addTimeChangeListener(new CompteARebour(10));
        ts.addTimeChangeListener(new CompteARebour(5));
        /*int i=0;
        while(i<20){
        ts.addTimeChangeListener(new CompteARebour(5 + (int)(Math.random() * 10)));
         i++;}*/
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    //part 2
    private static void launchApp()
    {
        //Lookup.getInstance().getService(TimerService.class);
         GuiDisplay smartwatch=new GuiDisplay();
         smartwatch.setVisible(true);
         GuiControl controlsmartwatch=new GuiControl();
         controlsmartwatch.setVisible(true);
         
        
    }
}
