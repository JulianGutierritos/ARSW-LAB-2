package edu.eci.arsw.highlandersim;


import org.junit.Test;
import static org.junit.Assert.*;


import edu.eci.arsw.highlandersim.*;
import javax.swing.JTextField;

public class InmortalTest{
    
    
    public InmortalTest(){
    }

    @Test
    public void deberianMantenerseLaCondicionCon100(){
        ControlFrame c = new ControlFrame();
		JTextField j =  new JTextField("100");
		c.setInmortals(j);
		c.correrP();
		try {
            Thread.sleep(5000);
            
        } catch (InterruptedException ex) {
        }
		assertEquals(c.getPuntajeTotalYPausar(), 100*100);
    }
	
	@Test
    public void deberianMantenerseLaCondicionCon1000(){
        ControlFrame c = new ControlFrame();
		JTextField j =  new JTextField("1000");
		c.setInmortals(j);
		c.correrP();
		try {
            Thread.sleep(5000);
            
        } catch (InterruptedException ex) {
        }
		assertEquals(c.getPuntajeTotalYPausar(), 1000*100);
    }
	
	@Test
    public void deberianMantenerseLaCondicionCon10000(){
        ControlFrame c = new ControlFrame();
		JTextField j =  new JTextField("10000");
		c.setInmortals(j);
		c.correrP();
		try {
            Thread.sleep(5000);
            
        } catch (InterruptedException ex) {
        }
		assertEquals(c.getPuntajeTotalYPausar(), 10000*100);
    }
}