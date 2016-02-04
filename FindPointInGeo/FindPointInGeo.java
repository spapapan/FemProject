/*
 *
 *     Finds a point which lies within a simple polygon. The polygon can have holes. The method getPointInGeo 
 *     return a double[][] array. The value double[0][0] and double[0][1] represent the coordinates (x0,y0) of
 *     the point which lies within the geometry of the polygon. The values of double[n][0] and double[n][1],
 *     n>0 represent the coordinates (xn,yn) which are inside the polygon but near the inner geometries.
 *     
 *     You can call getPointInGeo using a List of LinkedList<Point>, but the first  LinkedList<Point> must contain
 *     the coordinates of the outer geometry.
 * 
 */


import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

public class FindPointInGeo {
	
	private double x1;
	private double y1;
	private boolean isinside = false;
	private double a1;
	private final double dthi = 0.1;
	private double r;
	private double thi;
	private int Xp;
	private int Yp;
    public int counter[];
    public double intersect[][][];

	public FindPointInGeo() {
		// TODO Auto-generated constructor stub
	}
	
	// ------------------ MAIN FUNCTION ----------------------------
	private double[][] getPointInGeo(int Xgeopoints[][], int Ygeopoints[][], int Linegeo[][][], int numpgeo[], int c2geo, double Vecgeo[][][], int totalpoints){
		
	
	    counter = new int[c2geo];
	    intersect = new double[totalpoints][c2geo][2];
	    double returnxy[][] = new double[c2geo][2];
		
		for (int j = 0; j<c2geo; j++){// For all geometries (Outer and internal)

        isinside = false;
        
		Xp = Xgeopoints[1][j];
		Yp = Ygeopoints[1][j];
		x1 = Xp + 10;  //  |  Start Point
		y1 = Yp + 10;  //  |
		
		
		    // Find radius of circle and angle 
			r = Math.sqrt(Math.pow((x1 -Xp), 2) + Math.pow((y1 - Yp), 2));
			
			if (x1 > Xp) {	
				thi = Math.atan2(y1 - Yp, x1 - Xp);
			}
			else if (x1 < Xp) {
				thi = Math.atan2(y1 - Yp, Xp - x1);
			}
			else {
				thi = 0;
			}
			

			x1 = r*Math.cos(thi) + Xp; // Calculate new coordinates
			y1 = r*Math.sin(thi) + Yp;
			a1 = y1/x1;  // angle of line y = a1*x
 
			
		    while (isinside == false){// if we didn't find a solution:
				
			  if (!isonGeo(x1,y1,numpgeo,Vecgeo,Linegeo,j)){ // If the point we chose is not on the geometry continue
				
				  if (!checkalign(a1, Vecgeo,numpgeo,j)){ // if line y = a1*x is not identical with a line from the geometry continue
					
					  if (FindInter(a1,numpgeo,Vecgeo,Linegeo,j)) { // Find if the line y = a1*x intersect the geometry
			
						   if (oddeven(x1,y1,j)){ // Find if the total intersections are odd or even number
							   
							  if (edge(Xgeopoints, Ygeopoints,numpgeo, j)){ // Check if point (x1,y1) is very close to an edge

							     
							     returnxy[j][0] = x1;
							     returnxy[j][1] = y1;
							     isinside = true;
							     
							     
							  }

						   }
						  
					  }
					
				}
				
			}
			
			if (!isinside){
				
			thi = thi + dthi; // Calculate new angle
			
			// --- 0 < thi < 2π
			if (thi > 6.283) {
				thi = thi - 6.283;
			}
			
			x1 = r*Math.cos(thi) + Xp; // Calculate new coordinates
			y1 = r*Math.sin(thi) + Yp;

			a1 = y1/x1;

			}
 
		} // END WHILE
	  } // END FOR j
		
			return returnxy;
	}
	
	
 
	/*
	 *             ---------- SUB FUNCTIONS  -------------
	 */
	
	
	
	
	// ------------------ EDGE ---------------------------------------------------------
	private boolean edge(int[][] Xgeopoints, int[][] Ygeopoints,int[] numpgeo, int jj) {
		
		   boolean edge = true;
 
		   for (int i = 0; i< numpgeo[jj]; i++) {
              for (int j = 0; j< counter[jj]; j++){
			    if (Math.round(intersect[j][jj][0]) == Xgeopoints[i][jj]){  
                  if (Math.round(intersect[j][jj][1]) == Ygeopoints[i][jj])  {
				      edge = false;
                  }
			    }
			   }
			   
		   } 
		   return edge;
	}
	
	
	// ---------------------- ODD EVEN -------------------------
	private boolean oddeven(double x12, double y12, int jj) {
	   boolean oddeven = false;
	   int counter1 = 0;
	   for (int i = 0; i< counter[jj]; i++) { 
		   if (x12 <= intersect[i][jj][0]) {
			   counter1++;

		   }
	   }
	   
	   if (jj==0){// For outer geometry
	   if (counter1%2 == 0) { // If the number of intersections is even
		   oddeven = false;  
	   }
	   else {// If the number of intersections is odd
		   oddeven = true;
	   }
	   }
	   else{// For inner geometries
		   if (counter1%2 == 0) {
			   oddeven = true;  
		   }
		   else {
			   oddeven = false;
		   }   
	   }
	   
	   return oddeven;
	}
	

	
	// ------------------------------------------ FIND INTER ------------------------------------------------
	private boolean FindInter(double a12, int numpgeo2[], double Vecgeo2[][][], int Linegeo2[][][], int jj) {
		 double x;
		 double y;
		 long xx;
		 long yy;
	
         boolean findinter = false;
         counter[jj] = 0;

         for (int i = 0; i< numpgeo2[jj]; i++) { // For all points 
        	  if (a12 != Vecgeo2[i][0][jj]) { // If lines don't have same slope
        		  
        		  x = Vecgeo2[i][1][jj]/(-Vecgeo2[i][0][jj] + a12);
        		  xx = Math.round(x); // Rounding 
        		  if ((xx >= Linegeo2[i][0][jj] && xx <= Linegeo2[i][2][jj]) ||  (xx <= Linegeo2[i][0][jj] && xx >= Linegeo2[i][2][jj])){
        			
        			  y = a12*Vecgeo2[i][1][jj]/(-Vecgeo2[i][0][jj] + a12);
        			  yy = Math.round(y);// Rounding 
        			   if ((yy >= Linegeo2[i][1][jj] && yy <= Linegeo2[i][3][jj]) ||  (yy <= Linegeo2[i][1][jj] && yy >= Linegeo2[i][3][jj])) {
        				  intersect[counter[jj]][jj][0] = x;
        				  intersect[counter[jj]][jj][1] = y;
        				  findinter = true;
        			 
        				  counter[jj]++;
        			  }
        		  }
        	  }
         }
         return findinter;
	}
	


	// ------------------------------ CHECK ALIGN ----------------------------------------
	private boolean checkalign(double a12, double Vecgeo2[][][], int numpgeo2[], int jj) {
		
		boolean checkalign = false;
        for (int i = 0; i < numpgeo2[jj]; i++){
        	
        	if (a12 == Vecgeo2[i][0][jj]) {
        		checkalign = true;
        	}
        }
		
		return checkalign;
	}
	
 
	// ---------------------------------------------- IS ON GEO ------------------------------------------------------
	private boolean isonGeo(double x12, double y12, int numpgeo2[], double Vecgeo2[][][], int Linegeo2[][][],int jj) {
		
		boolean isonGeo = false;
		for (int i= 0; i< numpgeo2[jj]; i++) {
		double checkGeo = y12 - Vecgeo2[i][0][jj]*x12 + Vecgeo2[i][1][jj];
		
		if (checkGeo == 0){
			
			if (i==0){ // If point (x12,y12) is on the first line 
				isonGeo = true;
			}
			
			if ((x12 >= Linegeo2[i][0][jj] && x12 <= Linegeo2[i][2][jj]) ||  (x12 <= Linegeo2[i][0][jj] && x12 >= Linegeo2[i][2][jj])){
		    if ((y12 >= Linegeo2[i][1][jj] && y12 <= Linegeo2[i][3][jj]) ||  (y12 <= Linegeo2[i][1][jj] && y12 >= Linegeo2[i][3][jj])) {
		    	
		    	isonGeo = true;
		    }		    
			}
			
		}
		}
		return isonGeo;
	}
	

	
	// ----------------------------------- call methods --------------------------------------------
	
	public double[][] getPointInGeo(LinkedList<LinkedList<Point>> pointsList){
		
        int tc2 = pointsList.size();
    	int tnump[] = new int[tc2]; 
    	int getSize[] = new int[tc2]; 
    	int sizecount = 0;// Μετρητής
    	for (LinkedList<Point> listpoints : pointsList){
    		getSize[sizecount] = listpoints.size();
    		sizecount++;
    	}
    	Arrays.sort(getSize);
    	int totalpoints = getSize[getSize.length-1]+1;
    	int xpoints[][] = new int[totalpoints][tc2];
    	int ypoints[][] = new int[totalpoints][tc2];
    	int Lines[][][] = new int[totalpoints][4][tc2];
 
 
    	int k1=0;
    	int k2=0;
    	for (LinkedList<Point> listpoints : pointsList){  
    		for (int i=0; i<listpoints.size(); i++){ 
    			tnump[k1]++;
    			   xpoints[k2][k1] = listpoints.get(k2).x;
    			   ypoints[k2][k1] = listpoints.get(k2).y;
 
    			   if (i<listpoints.size()-1){
                   Lines[k2][0][k1] = listpoints.get(k2).x;
                   Lines[k2][1][k1] = listpoints.get(k2).y;
                   Lines[k2][2][k1] = listpoints.get(k2+1).x;
                   Lines[k2][3][k1] = listpoints.get(k2+1).y;
    			   }
                   k2++;
    		}
 
    		xpoints[k2][k1] = xpoints[0][k1];
    		ypoints[k2][k1] = ypoints[0][k1];
    		
            Lines[k2-1][0][k1] = listpoints.get(k2-1).x;
            Lines[k2-1][1][k1] = listpoints.get(k2-1).y;
            Lines[k2-1][2][k1] = listpoints.get(0).x;
            Lines[k2-1][3][k1] = listpoints.get(0).y;
 
    		k2=0;
    		k1++;
    	}
    	
    	double Vec[][][] = new double[totalpoints][totalpoints][tc2];
    	
        for (int j = 0; j < tc2; j++) {
            for (int i = 0; i < tnump[j]; i++) {
           		double xa =  xpoints[i][j];
        		double ya = ypoints[i][j];
        		double xb =  xpoints[i+1][j];
        		double yb = ypoints[i+1][j];
 
        		if (xb-xa==0){
        			xb=xb+1;
        			Vec[i][0][j] = (yb - ya)/(xb - xa);
        		}
        		else{
        		Vec[i][0][j] = (yb - ya)/(xb - xa);
        		}
        		Vec[i][1][j] = ya - xa*Vec[i][0][j];
            }
        }

    	return getPointInGeo(xpoints,ypoints,Lines,tnump,tc2,Vec,totalpoints);
     }
	
	
	public double[][] getPointInGeo(LinkedList<Point> geo1, LinkedList<Point> geo2){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		
		return getPointInGeo(pointslist);
	}
	
	public double[][] getPointInGeo(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		
		return getPointInGeo(pointslist);
	}
	
	public double[][] getPointInGeo(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3, LinkedList<Point> geo4){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		pointslist.add(geo4);
		
		return getPointInGeo(pointslist);
	}
	
	public double[][] getPointInGeo(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3, LinkedList<Point> geo4, LinkedList<Point> geo5){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		pointslist.add(geo4);
		pointslist.add(geo5);
		
		return getPointInGeo(pointslist);
	}

} // END CLASS FindPointInGeo
