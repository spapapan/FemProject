/*
 * 
 *     Returns the intermediate points of a polygon, given N polygons. The parameter density defines 
 *     the amount of the intermediate points. It can take integer values from 1 to 10.
 * 
 */

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
 
public class DiscretizePolygon {
 
	private int nkom;
	
	public DiscretizePolygon() {
		// TODO Auto-generated constructor stub
	}

	private LinkedList<LinkedList<Point>> createOutGeomesh(int Xpoint[][], int Ypoint[][], int nump[],int n) {
		
	int c2 = Xpoint[0].length;
	int field1 = Xpoint.length;
	double field2 = Xpoint.length*(1/(0.01*n));
	double Xmpoint[][][] = new double[field1][(int) field2][c2]; //Coordinate X of intermediate points
	double Ympoint[][][] = new double[field1][(int) field2][c2]; //Coordinate Y of intermediate points
	double Slope[][][] = new double[field1][2][c2]; // coefficient a,b of a line ( y = a*x + b) 
	double dist[][] = new double[field1][c2]; // Distance between two points
	int numpoints[][] = new int[field1][c2]; // Number of intermediate points of a line
 
        for (int j = 0; j < c2; j++) {
            for (int i = 0; i < nump[j]; i++) {

           		double xa =  Xpoint[i][j];
        		double ya = Ypoint[i][j];
        		
        		double xb =  Xpoint[i+1][j];
        		double yb = Ypoint[i+1][j];
        		
        		// Calculate coefficient a,b of a line ( y = a*x + b) 
        		if (xb-xa==0){
        			xb=xb+1;
        			Slope[i][0][j] = (yb - ya)/(xb - xa);
        		}
        		else{
        		Slope[i][0][j] = (yb - ya)/(xb - xa);
        		}
        		Slope[i][1][j] = ya - xa*Slope[i][0][j];

        		//Find distance   
        		dist[i][j] = Math.sqrt(Math.pow(xa - xb,2) + Math.pow(ya - yb, 2));

        			 
        	// Calculate intermediate points
        			 
        	double nkomdou = dist[i][j]/(n*10);  // Partition of distance 
        			
                if ( nkomdou - Math.floor(nkomdou)>0.7){//Integer value of partitions 
                    	nkom = (int) nkomdou + 1;
                }
                else{
        		nkom = (int) nkomdou;  
                }
                
        	double xsa =  Xpoint[i][j];
            	double ysa = Ypoint[i][j];

        		for (int ii = 0; ii <= nkom; ii++) {
        		if (ii == 0){
        				Xmpoint[i][ii][j] = Xpoint[i][j];
        				Ympoint[i][ii][j] = Ypoint[i][j];
        				if (nkom==0){
        					Xmpoint[i][ii+1][j] = Xpoint[i+1][j];
            				        Ympoint[i][ii+1][j] = Ypoint[i+1][j];
        					numpoints[i][j]++;
        				}
        		 	    }
        		else {
        		
        			
        	        double a = Slope[i][0][j];
        	        double b = Slope[i][1][j];
        			
        	        // Solution for positive sign
        		double Xthe = (-((2*a)*(b - ya) - 2*xa) + Math.sqrt(Math.abs(Math.pow(((2*a)*(b - ya) - 2*xa), 2) - 4*(1 + a*a)*(xa*xa + Math.pow((b - ya),2) -  Math.pow(dist[i][j]/nkom,2)))))/(2 + 2*a*a);
        		// Solution for negative sign
        		double Xarn = (-((2*a)*(b - ya) - 2*xa) - Math.sqrt(Math.abs(Math.pow(((2*a)*(b - ya) - 2*xa), 2) - 4*(1 + a*a)*(xa*xa + Math.pow((b - ya),2) -  Math.pow(dist[i][j]/nkom,2)))))/(2 + 2*a*a); 
        				
        		// Solution for positive sign
        		double Ythe = a*Xthe + b; 
        		// Solution for negative sign
        		double Yarn = a*Xarn + b; 
        		
        		
        		// ------ Select positive or negative discriminant ------------
        		if (xsa < xb){ 
        			if (xa < Xthe) {
        				Xmpoint[i][ii][j] = Xthe;
        			}
        				else {
        				Xmpoint[i][ii][j] = Xarn;
        			}
        		}
        		
        		if (xsa > xb){ 
        			if (xa > Xthe) {
        				Xmpoint[i][ii][j] = Xthe;
        			}
        				else {
        				Xmpoint[i][ii][j] = Xarn;
        			}
        		}
        		
        		if (xsa == xb){ 
        			
        		 Xmpoint[i][ii][j] = xb;
        		
        		}
        		
        		
        		if (ysa < yb){ 
        			if (ya < Ythe) {
        				Ympoint[i][ii][j] = Ythe;
        			}
        				else {
        				Ympoint[i][ii][j] = Yarn;
        			}
        		}
        		
        		if (ysa > yb){ 
        			if (ya > Ythe) {
        				Ympoint[i][ii][j] = Ythe;
        			}
        				else {
        				Ympoint[i][ii][j] = Yarn;
        			}
        		}
        		
        		if (ysa == yb){ 
        			
        		 Ympoint[i][ii][j] = yb;
        		
        		}
 

                    xa = Xmpoint[i][ii][j];
                    ya = Ympoint[i][ii][j];
                    
                    numpoints[i][j]++;  

 
        			
        			} 
                    

                }  
                
            } 
            
        } 
 
        LinkedList<Point> points = new LinkedList<Point>();
        LinkedList<LinkedList<Point>> pointList = new LinkedList<LinkedList<Point>>();
        
        for (int j=0; j< Xmpoint[0][0].length; j++){
        for (int i=0; i< Xmpoint.length; i++){
        	for (int k=0; k<numpoints[i][j]; k++){
        	if (Xmpoint[i][k][j] != 0 && Ympoint[i][k][j] != 0){
        		points.add(new Point((int)Math.round(Xmpoint[i][k][j]), (int)Math.round(Ympoint[i][k][j])));
        	}
        	}
        }
        pointList.add((LinkedList<Point>) points.clone());
        points.clear();
        }
	    
        return pointList;

        
    }  
	
	
	public LinkedList<LinkedList<Point>> getDiscretizePolygon(LinkedList<LinkedList<Point>> pointsList,int density){
		
		    int tc2 = pointsList.size();
	    	int tnump[] = new int[tc2];   //How many points each geometry have
	    	int getSize[] = new int[tc2]; //How many points each geometry have (sorted)
	    	int sizecount = 0;// Μετρητής
	    	for (LinkedList<Point> listpoints : pointsList){
	    		getSize[sizecount] = listpoints.size();
	    		sizecount++;
	    	}
	    	Arrays.sort(getSize);
	    	int xpoints[][] = new int[getSize[getSize.length-1]+1][tc2];
	    	int ypoints[][] = new int[getSize[getSize.length-1]+1][tc2];

	 

	    	int k1=0;
	    	int k2=0;
	    	for (LinkedList<Point> listpoints : pointsList){  
	    		for (int i=0; i<listpoints.size(); i++){ 
	    			tnump[k1]++;
	    			   xpoints[k2][k1] = listpoints.get(k2).x;
	    			   ypoints[k2][k1] = listpoints.get(k2).y;

	                   k2++;
	    		}
	    		xpoints[k2][k1] = xpoints[0][k1];
	    		ypoints[k2][k1] = ypoints[0][k1];

	    		k2=0;
	    		k1++;
	    	}
	    	
	    	return createOutGeomesh(xpoints,ypoints,tnump,density);
		
	}
 
	
	public LinkedList<LinkedList<Point>> getDiscretizePolygon(LinkedList<Point> geo1, LinkedList<Point> geo2, int density){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		
		return getDiscretizePolygon(pointslist,density);
	}
	
	public LinkedList<LinkedList<Point>> getDiscretizePolygon(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3, int density){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		
		return getDiscretizePolygon(pointslist,density);
	}
	
	public LinkedList<LinkedList<Point>> getDiscretizePolygon(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3, LinkedList<Point> geo4, int density){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		pointslist.add(geo4);
		
		return getDiscretizePolygon(pointslist,density);
	}
	
	public LinkedList<LinkedList<Point>> getDiscretizePolygon(LinkedList<Point> geo1, LinkedList<Point> geo2, LinkedList<Point> geo3, LinkedList<Point> geo4, LinkedList<Point> geo5, int density){
		LinkedList<LinkedList<Point>> pointslist = new LinkedList<LinkedList<Point>>();
		pointslist.add(geo1);
		pointslist.add(geo2);
		pointslist.add(geo3);
		pointslist.add(geo4);
		pointslist.add(geo5);
		
		return getDiscretizePolygon(pointslist,density);
	}

} 
