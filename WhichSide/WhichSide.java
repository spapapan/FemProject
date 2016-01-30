/*
 *             ------------- Returns in which side of the line the point(xk,yk) lies ----------------
 */

import java.awt.Point;
import java.util.LinkedList;

public class WhichSide {
	
	private double side;
	private int whichside;

	public WhichSide() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSide(final double xa,final double ya,final double xb,final double yb,final double xk,final double yk){ 
		 side = (xk - xa)*(yb- ya) - (yk - ya)*(xb-xa);                                      
		 if (side > 0){
			 whichside = 1;
		 }
		 else if (side<0){
			 whichside =-1;
		 }
		 else{
			 whichside = 0;
		 }
		 
		 return whichside;
	}
	
	public int getSide(int xa,int ya,int xb,int yb,int xk,int yk){ 
		
		double x1 = (double)xa;
		double y1 = (double)ya;
		double x2 = (double)xb;
		double y2 = (double)yb;
		double x3 = (double)xk;
		double y3 = (double)yk;
		
		return getSide(x1,y1,x2,y2,x3,y3);
	}
	
	public int getSide(Point p1, Point p2, Point p3){ 
		
		double x1 = (double)p1.x;
		double y1 = (double)p1.y;
		double x2 = (double)p2.x;
		double y2 = (double)p2.y;
		double x3 = (double)p3.x;
		double y3 = (double)p3.y;
		
		return getSide(x1,y1,x2,y2,x3,y3);
	}
	
	public int getSide(int[] p1, int[] p2, int[] p3){ 
		
		double x1 = (double)p1[0];
		double y1 = (double)p1[1];
		double x2 = (double)p2[0];
		double y2 = (double)p2[1];
		double x3 = (double)p3[0];
		double y3 = (double)p3[1];
		
		return getSide(x1,y1,x2,y2,x3,y3);
	}
	
	public int getSide(double[] p1, double[] p2, double[] p3){ 
		
		double x1 = p1[0];
		double y1 = p1[1];
		double x2 = p2[0];
		double y2 = p2[1];
		double x3 = p3[0];
		double y3 = p3[1];
		
		return getSide(x1,y1,x2,y2,x3,y3);
	}
	
	public int getSide(LinkedList<Point> points){
		
		double x1 = points.get(0).x;
		double y1 = points.get(0).y;
		double x2 = points.get(1).x;
		double y2 = points.get(1).y;
		double x3 = points.get(2).x;
		double y3 = points.get(2).y;
		
		return getSide(x1,y1,x2,y2,x3,y3);
		
	}
	

}
