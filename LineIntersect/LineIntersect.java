/*
 *      Given 4 points (x1,y1), (x2,y2), (x3,y3), (x4,y4) :
 * 
 * 
 *      getIntersect method returns a double[] array with the coordinates of the intersected point.
 *      If the value of array[2] is 1, then the intersected point is between the line segments of 
 *      {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)}.
 *      If the value of array[2] is 2, then the intersected point is NOT between the line segments of 
 *      {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)}.
 *      If the value of array[2] is -1, then the lines {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} are parallel.
 *      
 *      Intersected method returns true if the lines {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} intersect and
 *      false if the lines are parallel.
 *      
 *      IntersectBetween method returns true if the intersected point is between the line segments of 
 *      {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} and false if the intersected point is NOT between or if the
 *      lines are parallel.
 *      
 *      
 */

import java.awt.Point;

public class LineIntersect {
 
	private double Intersect[] = new double[3]; // Coordinates of intersected point
	private double slope1; // Slope of line {(x1,y1),(x2,y2)}
	private double slope2; // Slope of line {(x3,y3),(x4,y4)}
	                  

	public LineIntersect() {

	}
	

	public double[] getIntersect(final double x1,final double y1,final double x2,final double y2,final double x3, final double y3, final double x4, final double y4){


		// Check if lines are parallel 
		if (x2-x1 != 0){
			slope1 = (y2-y1)/(x2-x1);
		}
		else {
			slope1 = 0;
		}
		if (x4-x3 != 0){
			slope2 = (y4-y3)/(x4-x3);
		}
		else {
			slope2 = 0;
		}
		
		int parallel=0;
		double slopediff = Math.abs(slope1-slope2);
		if ((y1==y2 && x3==x4) || (x1==x2 && y3==y4)){
			parallel = 1;
		}
		else if (slope1==0 && slope2==0){
			Intersect = new double[]{0,0,-1};
			return Intersect;
		}
		else if(slopediff <0.001){
			Intersect = new double[]{0,0,-1};
			return Intersect;
		}
		
		
		if (parallel == 0 || parallel == 1){ 

		if ((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4) != 0) {
		Intersect[0] = ((x1*y2 - y1*x2)*(x3-x4) - (x1 - x2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)); // Coordinate x of intersected point between the lines {(x1,y1),(x2,y2) } and {(x3,y3)-(x4,y4)}
		Intersect[1] = ((x1*y2 - y1*x2)*(y3-y4) - (y1 - y2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)); // Coordinate y of intersected point between the lines {(x1,y1),(x2,y2) } and {(x3,y3)-(x4,y4)}
		
		
		// Check if P[0],P[1] is very close to x1,x2
		if (Math.abs(Intersect[0] - x1) < 0.01) {
			Intersect[0] = x1;
		}
		if (Math.abs(Intersect[0] - x2) < 0.01) {
			Intersect[0] = x2;
		}

		
		if ((Intersect[0] > x1 && Intersect[0] < x2) || (Intersect[0] < x1 && Intersect[0] > x2)){ // Check if intersected point is between the values x1 , x2
			if ((Intersect[1] > y3 && Intersect[1] < y4) || (Intersect[1] < y3 && Intersect[1] > y4)){ // Check if intersected point is between the values y3 and y4
				Intersect[2] = 1;
				return Intersect;
			}
			else{
				Intersect[2] = 2;
				return Intersect;
			}
		}
		else {
			Intersect[2] = 2;
			return Intersect;
			
		}
		
		}
		else{
			Intersect = new double[]{0,0,-1};
			return Intersect;
		}
		}

		return Intersect;
	}
	
	
	
	
	// -------------------------------------------------------------------------------------------------------------------
	
	
	public Boolean Intersected(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
		double getR[] = getIntersect(x1,y1,x2,y2,x3,y3,x4,y4);
		if (getR[2] == 1 || getR[2] == 2){
			return true;
		}
		else{
			return false;
		}
	}

	
	public Boolean Intersected(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		
		double xa = (double)x1;
		double ya = (double)y1;
		double xb = (double)x2;
		double yb = (double)y2;
		double xc = (double)x3;
		double yc = (double)y3;
		double xd = (double)x4;
		double yd = (double)y4;
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	public Boolean Intersected(Point p1, Point p2, Point p3, Point p4){
		
		double xa = (double)p1.x;
		double ya = (double)p1.y;
		double xb = (double)p2.x;
		double yb = (double)p2.y;
		double xc = (double)p3.x;
		double yc = (double)p3.y;
		double xd = (double)p4.x;
		double yd = (double)p4.y;
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	public Boolean Intersected(int[] p1, int[] p2, int[] p3, int[] p4){
		
		double xa = (double)p1[0];
		double ya = (double)p1[1];
		double xb = (double)p2[0];
		double yb = (double)p2[1];
		double xc = (double)p3[0];
		double yc = (double)p3[1];
		double xd = (double)p4[0];
		double yd = (double)p4[1];
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	
	public Boolean Intersected(double[] p1, double[] p2, double[] p3, double[] p4){
		
		double xa =  p1[0];
		double ya =  p1[1];
		double xb =  p2[0];
		double yb =  p2[1];
		double xc =  p3[0];
		double yc =  p3[1];
		double xd =  p4[0];
		double yd =  p4[1];
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	
	// -------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	// -------------------------------------------------------------------------------------------------------------------
	
	
	public Boolean IntersectedBetween(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
		double getR[] = getIntersect(x1,y1,x2,y2,x3,y3,x4,y4);
		if (getR[2] == 1){
			return true;
		}
		else{
			return false;
		}
	}

	
	public Boolean IntersectedBetween(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		
		double xa = (double)x1;
		double ya = (double)y1;
		double xb = (double)x2;
		double yb = (double)y2;
		double xc = (double)x3;
		double yc = (double)y3;
		double xd = (double)x4;
		double yd = (double)y4;
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	public Boolean IntersectedBetween(Point p1, Point p2, Point p3, Point p4){
		
		double xa = (double)p1.x;
		double ya = (double)p1.y;
		double xb = (double)p2.x;
		double yb = (double)p2.y;
		double xc = (double)p3.x;
		double yc = (double)p3.y;
		double xd = (double)p4.x;
		double yd = (double)p4.y;
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	public Boolean IntersectedBetween(int[] p1, int[] p2, int[] p3, int[] p4){
		
		double xa = (double)p1[0];
		double ya = (double)p1[1];
		double xb = (double)p2[0];
		double yb = (double)p2[1];
		double xc = (double)p3[0];
		double yc = (double)p3[1];
		double xd = (double)p4[0];
		double yd = (double)p4[1];
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}
	
	
	public Boolean IntersectedBetween(double[] p1, double[] p2, double[] p3, double[] p4){
		
		double xa =  p1[0];
		double ya =  p1[1];
		double xb =  p2[0];
		double yb =  p2[1];
		double xc =  p3[0];
		double yc =  p3[1];
		double xd =  p4[0];
		double yd =  p4[1];
		
		return Intersected(xa,ya,xb,yb,xc,yc,xd,yd);
		
	}


}
