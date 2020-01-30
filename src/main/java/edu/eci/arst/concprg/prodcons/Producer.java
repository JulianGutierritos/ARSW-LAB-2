/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class Producer extends Thread {

    private Queue<Integer> queue = null;

    private int dataSeed = 0;
    private Random rand=null;
    private final long stockLimit;
    private boolean finish;
    
    public Producer(Queue<Integer> queue,long stockLimit) {
        this.queue = queue;
        rand = new Random(System.currentTimeMillis());
        this.stockLimit=3;
        this.finish=false;
    }
    
    
    @Override
    synchronized public void run() {
    	
    		while (true) {
    					
		    			dataSeed = dataSeed + rand.nextInt(100);
			            System.out.println("Producer added " + dataSeed);
			            synchronized (queue) {
							if (queue.size() + 1 == stockLimit) {
								try {
									queue.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}	
							queue.add(dataSeed);		
							queue.notify(); 	
			            }
    					
			            
			    			try {
			                wait(1000);
			                
			            } catch (InterruptedException ex) {
			                Logger.getLogger(StartProduction.class.getName()).log(Level.SEVERE, null, ex);
			            }
    		}
			      
			        
    				//}
			        
    				/*else {
    					this.finish=true;
    				}*/
		            
    		
    	}
    	
}
	       
