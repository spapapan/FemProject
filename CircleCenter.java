import java.awt.Point;
import java.util.LinkedList;

public class CircleCenter {
	
    private double ma; // slope a
    private double mb; // slope b
    private double center_radius[] = new double[3]; // [0: x, 1: y, 2: r]

	public CircleCenter() {
		// TODO Auto-generated constructor stub
	}
	
	public double[] GetCircleCenter(final double x1,final double y1,final double x2,final double y2,final double x3,final double y3){
		
	 final double yDa = y2-y1;
	 final double xDa = x2-x1;
	 final double yDb = y3-y2;
	 final double xDb = x3-x2;
		
	 final double ab_mid_x = (x1+x2)/2;
	 final double ab_mid_y = (y1+y2)/2;
	 final double bc_mid_x = (x2+x3)/2;
	 final double bc_mid_y = (y2+y3)/2;
 
	 if (xDa !=0){
		ma = yDa/xDa; 
	 }
	 if (xDb !=0){
		mb = yDb/xDb; 
	 }
	 
	 
	 // -- Case 1 ---------------------------------------------------
	 if (yDa == 0){
		 
		 center_radius[0] = ab_mid_x;
		 
		 if(xDb == 0){
			 center_radius[1] = bc_mid_y;
		 }
		 else {
			 center_radius[1] = bc_mid_y + (bc_mid_x - center_radius[0])/mb;
		 }
		 
	 }
	 
	 // -- Case 2 ---------------------------------------------------
	 else if (yDb == 0){
		 
		 center_radius[0] = bc_mid_x;
		 
		 if (xDa == 0){
			 center_radius[1] = ab_mid_y;
		 }
		 else{
			center_radius[1] = ab_mid_y + (ab_mid_x - center_radius[0])/ma; 
		 }
		
	 }
	 
	 // -- Case 3 ---------------------------------------------------
	 else if (xDa == 0){
		center_radius[1] = ab_mid_y;
		center_radius[0] = mb*(bc_mid_y - center_radius[1]) + bc_mid_x;
	 }
	 
	 // -- Case 4 ---------------------------------------------------
	 else if (xDb == 0){
		center_radius[1] = bc_mid_y;
		center_radius[0] = ma*(ab_mid_y - center_radius[1]) + ab_mid_y;
	 }
	 
	 // -- Case 5 ---------------------------------------------------
	 else {
		center_radius[0] = (ma*mb*(ab_mid_y-bc_mid_y) - ma*bc_mid_x + mb*ab_mid_x)/(mb-ma);
		center_radius[1] = ab_mid_y - (center_radius[0] - ab_mid_x)/ma;
	 }
	 
	 // Calculate Radius
	 center_radius[2] =  Math.sqrt(Math.pow(center_radius[0]-x1, 2) + Math.pow(center_radius[1]-y1, 2)); 
	 
		return center_radius; 
		
	}
	

	public double[] GetCircleCenter(Point p1, Point p2, Point p3){
		
		 final double x1 = (double)p1.x;
		 final double y1 = (double)p1.y;
		 final double x2 = (double)p2.x;
		 final double y2 = (double)p2.y;
		 final double x3 = (double)p3.x;
		 final double y3 = (double)p3.y;
		 
		return GetCircleCenter(x1,y1,x2,y2,x3,y3);
	}
	
	public double[] GetCircleCenter(final int x11,final int y11,final int x22,final int y22,final int x33,final int y33){
		
		 final double x1 = (double)x11;
		 final double y1 = (double)y11;
		 final double x2 = (double)x22;
		 final double y2 = (double)y22;
		 final double x3 = (double)x33;
		 final double y3 = (double)y33;
		 
		return GetCircleCenter(x1,y1,x2,y2,x3,y3);
	}
	
	public double[] GetCircleCenter(double[] p1, double[] p2, double[] p3){
		
		 final double x1 = p1[0];
		 final double y1 = p1[1];
		 final double x2 = p2[0];
		 final double y2 = p2[1];
		 final double x3 = p3[0];
		 final double y3 = p3[1];
		 
		return GetCircleCenter(x1,y1,x2,y2,x3,y3);
	}
	
	
	public double[] GetCircleCenter(int[] p1, int[] p2, int[] p3){
		
		 final double x1 = (double)p1[0];
		 final double y1 = (double)p1[1];
		 final double x2 = (double)p2[0];
		 final double y2 = (double)p2[1];
		 final double x3 = (double)p3[0];
		 final double y3 = (double)p3[1];
		 
		return GetCircleCenter(x1,y1,x2,y2,x3,y3);
	}
	
	public double[] GetCircleCenter(LinkedList<Point> list){
		
		 final double x1 = (double)list.get(0).x;
		 final double y1 = (double)list.get(0).y;
		 final double x2 = (double)list.get(1).x;
		 final double y2 = (double)list.get(1).y;
		 final double x3 = (double)list.get(2).x;
		 final double y3 = (double)list.get(2).y;
		 
		return GetCircleCenter(x1,y1,x2,y2,x3,y3);
	}
	
	
	

}
