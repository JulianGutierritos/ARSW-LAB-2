package edu.eci.arsf.maths;

import java.util.ArrayList;
import java.util.List;

import edu.eci.arsw.highlandersim.Immortal;

public class Sumas {
	
	private static Integer sumaTotal;
	private int numOfThreads;
	private List<Immortal> immortals;
	private int size;
	private ArrayList<Integer[]> limits;
	private ArrayList<SumaThread>threads;
	
	public Sumas(int numOfThreads, List<Immortal> immortals, int size) {
		Sumas.sumaTotal=0;
		this.numOfThreads=numOfThreads;
		this.immortals=immortals;
		this.size=size;
		this.limits=new ArrayList<Integer[]>();
		this.threads=new ArrayList<SumaThread>();
		try {
			dividir();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dividir() throws InterruptedException {
		int div=this.size/this.numOfThreads;
		int aux=0;
		for(int i=0; i<this.numOfThreads;i++) {
			int limInf=aux;
			int limSup=limInf+div-1;
			if(i==numOfThreads-1) {
				limSup=size-1;
			}
			Integer[] lim= {limInf, limSup};
			this.limits.add(lim);
			
			aux=limSup+1;
		}
	}
	
	public static synchronized  void sumar(int limInf, int limSup, List<Immortal>immortals) {
		synchronized(sumaTotal) {
			for(int i=limInf;i<=limSup;i++) {
					sumaTotal+=immortals.get(i).getHealth().get();
					
			}			
		}
		//System.out.println(sumaTotal);
	}
	
	public void sumaTotal() {
		for(int i=0; i<this.numOfThreads; i++) {
			int limInf=this.limits.get(i)[0];
			int limSup=this.limits.get(i)[1];
			//System.out.println(limInf + " " + limSup);
			SumaThread f=new SumaThread(limInf, limSup, this.immortals);
			this.threads.add(f);
			f.start();
		}
	}
	
	public int getSumaTotal() {
		for(int i=0;i<this.threads.size();i++) {
			try {
				this.threads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sumaTotal;
	}
	
		
	
	/*public static void main(String args[]) throws InterruptedException {
		
		ArrayList<Integer> ints=new ArrayList<Integer>();
		
		for(int i=1; i<=100; i++) {
			ints.add(i);
		}
		
		Sumas suma=new Sumas(50, ints, 100);
		suma.sumaTotal();
		System.out.println(suma.getSumaTotal());
	}*/
}


class SumaThread extends Thread{
	
	private int limInf;
	private int limSup;
	private List<Immortal> immortals;
	
	public SumaThread (int limInf, int limSup, List<Immortal>immortals) {
		this.limInf=limInf;
		this.limSup=limSup;
		this.immortals=immortals;
	}
	
	
	public void run() {
		
		Sumas.sumar(limInf, limSup, immortals);
		
	}
	
}










