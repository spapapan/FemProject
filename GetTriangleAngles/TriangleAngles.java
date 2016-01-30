/*
 *             --------- Returns the angles (in degrees) of a triangle given 3 points --------------
 */

public class TriangleAngles {

	private double angletr1[] = new double[3];
	private double angletr2[] = new double[3];
	private double angletr[] = new double[3];
	private double passtrangles[] = new double[3]; 
	                                               
                                                 

	public TriangleAngles() {
		// TODO Auto-generated constructor stub
	}
	
	
	public double[] getAngles(final double x1,final double y1,final double x2,final double y2,final double x3,final double y3){
 
		 
		
		   // -------- Angle for passtrangles[0] -------- 
		   if (x2 - x1 >= 0){
			   angletr1[0] = Math.atan2(y2 -y1, x2 - x1);
			   angletr2[0] = Math.atan2(y3 - y1, x3 - x1);
			   
			   angletr[0] = angletr1[0] - angletr2[0];
			   
		   }
		   if (x2 - x1 < 0){
			   angletr1[0] = Math.atan2(y2 -y1, -x2 + x1);
			   angletr2[0] = Math.atan2(y3 - y1, -x3 + x1);
			   
			   angletr[0] = angletr2[0] - angletr1[0];
			   
		   }
		   
 
		   
		   
		   // ------- Angle for passtrangles[1] ---------
		   if (x1 - x2 >= 0){
			   angletr1[1] = Math.atan2(y1 -y2, x1 - x2);
			   angletr2[1] = Math.atan2(y3 - y2, x3 - x2);
			   
			   angletr[1] = angletr1[1] - angletr2[1];
			   
		   }
		   if (x1 - x2 < 0){
			   angletr1[1] = Math.atan2(y1 -y2, -x1 + x2);
			   angletr2[1] = Math.atan2(y3 - y2, -x3 + x2);
			   
			   angletr[1] = angletr2[1] - angletr1[1];
			   
		   }
		   
 
		   
		   
		   // ------- Angle for passtrangles[2] ---------
		   if (x1 - x3 >= 0){
			   angletr1[2] = Math.atan2(y1 -y3, x1 - x3);
			   angletr2[2] = Math.atan2(y2 - y3, x2 - x3);
			   
			   angletr[2] = angletr1[2] - angletr2[2];
			   
		   }
		   if (x1 - x3 < 0){
			   angletr1[2] = Math.atan2(y1 -y3, -x1 + x3);
			   angletr2[2] = Math.atan2(y2 - y3, -x2 + x3);
			   
			   angletr[2] = angletr2[2] - angletr1[2];
			   
		   }
		   
		   // ---------------------------------------------------------
		   
		   
		   
		   
		   for (int i =0; i<3; i++){
			   
			   angletr[i] = (180/Math.PI)*angletr[i]; // convert angle to degrees
			   
			   // Parameterization of angle so it will be always inside the range -180 < angle < 180
			   if (angletr[i] < -180) {
				   angletr[i] = 360 + angletr[i];
			   }
			   if (angletr[i] > 180) {
				   angletr[i] = angletr[i] - 360;
			   }
			   
			   angletr[i] = Math.abs(angletr[i]);
			   
			   passtrangles[i] = angletr[i];
			   
		   }
		   
		   
		
		return passtrangles;
		
	}
	
	
	public double[] getAngles(int x1, int y1, int x2, int y2, int x3, int y3){
		
		double xa = (double)x1;
		double ya = (double)y1;
		double xb = (double)x2;
		double yb = (double)y2;
		double xc = (double)x3;
		double yc = (double)y3;
				
		return getAngles(xa,ya,xb,yb,xc,yc);
	}
	
	public double[] getAngles(Point p1, Point p2, Point p3){
		
		double xa = (double)p1.x;
		double ya = (double)p1.y;
		double xb = (double)p2.x;
		double yb = (double)p2.y;
		double xc = (double)p3.x;
		double yc = (double)p3.y;
				
		return getAngles(xa,ya,xb,yb,xc,yc);
	}
	
	public double[] getAngles(int[] p1, int[] p2, int[] p3){
		
		double xa = (double)p1[0];
		double ya = (double)p1[1];
		double xb = (double)p2[0];
		double yb = (double)p2[1];
		double xc = (double)p3[0];
		double yc = (double)p3[1];
				
		return getAngles(xa,ya,xb,yb,xc,yc);
	}
	
	public double[] getAngles(double[] p1, double[] p2, double[] p3){
		
		double xa =  p1[0];
		double ya =  p1[1];
		double xb =  p2[0];
		double yb =  p2[1];
		double xc =  p3[0];
		double yc =  p3[1];
				
		return getAngles(xa,ya,xb,yb,xc,yc);
	}
	

}
