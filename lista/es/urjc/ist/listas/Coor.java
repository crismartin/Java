package es.urjc.ist.listas;

public class Coor {
	private int x;
	private int y;
	
	// Constructor
	public Coor (int cx, int cy) {	
		x = cx;
		y = cy;			
	}
		
	public int getX (){
		return x;		
	}
	
	public int getY (){
		return y;		
	}
	
	public String toString (){
		return "("+x+", "+y+")";
	}
}
