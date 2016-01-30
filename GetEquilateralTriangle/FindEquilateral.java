/*
 * 
 *         -------------- Find third point of equilateral triangle given 2 points --------------
 * 
 */

import java.awt.Point;
import java.util.LinkedList;

public class FindEquilateral {

	private double finalxy[] = new double[4]; // 0:x1, 1:y1, 2:x2, 3:y2
	
	public FindEquilateral() {
		
	}
	
	public double[] getEquilateral(final int xa,final int ya,final int xb,final int yb) {
		
		
		finalxy[0] = (xb+xa)/2 - Math.sqrt(3)*(yb-ya)/2; // x1
		finalxy[1] = (yb + ya)/2 + Math.sqrt(3)*(xb - xa)/2; //y1
		finalxy[2] = (xb+xa)/2 + Math.sqrt(3)*(yb-ya)/2; // x1'
		finalxy[3] = (yb + ya)/2 - Math.sqrt(3)*(xb - xa)/2; //y1'

	    return finalxy;
	}
	
	public double[] getEquilateral(final double xa,final double ya,final double xb,final double yb) {
		
	     return getEquilateral(xa,ya,xb,yb);
	}
	
	public double[] getEquilateral(Point p1, Point p2) {
		 int xa = p1.x;
		 int ya = p1.y;
		 int xb = p2.x;
		 int yb = p2.y;
	     return getEquilateral(xa,ya,xb,yb);
	}
	
	public double[] getEquilateral(int[] xy1, int[] xy2) {
		 int xa = xy1[0];
		 int ya = xy1[1];
		 int xb = xy2[0];
		 int yb = xy2[1];
	     return getEquilateral(xa,ya,xb,yb);
	}
	
	public double[] getEquilateral(double[] xy1, double[] xy2) {
		double xa = xy1[0];
		double ya = xy1[1];
		double xb = xy2[0];
		double yb = xy2[1];
	    return getEquilateral(xa,ya,xb,yb);
	}
	
	public double[] getEquilateral(LinkedList<Point> points) {
		double xa = points.get(0).x;
		double ya = points.get(0).y;
		double xb = points.get(1).x;
		double yb = points.get(1).y;
	    return getEquilateral(xa,ya,xb,yb);
	}
	

}
