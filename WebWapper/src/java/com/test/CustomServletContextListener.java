/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author USER
 */
public class CustomServletContextListener  implements ServletContextListener {

    private SystemTrayApp myThread = null;

    public void contextInitialized(ServletContextEvent sce) {    
        
      ServletContext context = sce.getServletContext();  
      //String path = context.getRealPath("/images/bulb.gif"); 
      //String path = "C:\\Users\\USER\\Documents\\NetBeansProjects\\WebWapper\\build\\web\\WEB-INF\\images\\bulb.gif";
      String path = "http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/TrayIconDemoProject/src/misc/images/bulb.gif";
      
      System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      
      //URL imageURL = SystemTrayApp.class.getResource(path);
        URL imageURL = null;
      
        try {
            imageURL = new URL(path);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CustomServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      System.out.println("path : "+path);
        
        if ((myThread == null) || (!myThread.isAlive())) {
            myThread = new SystemTrayApp(imageURL);
            myThread.start();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        
            //myThread.doShutdown();
            myThread.interrupt();
        
    }
}
