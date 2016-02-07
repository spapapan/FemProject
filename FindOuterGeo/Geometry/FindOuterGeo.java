/*
 * 
 *          Given N simple polygons, find which one encloses the others
 * 
 */

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

public class FindOuterGeo {

	public FindOuterGeo() {
		// TODO Auto-generated constructor stub
	}
	
	
	private int getFindOuterGeo(int Xpoint[][], int Ypoint[][], int nump[], int c2){
		
		       int getMin = 0;
		       int checkMin=0;
		       getMin = Xpoint[0][0];
		       for (int j=0; j<c2; j++){
			       for (int i=0; i<nump[j]; i++){
				       if (Xpoint[i][j] < getMin){
					       getMin = Xpoint[i][j];
				     	   checkMin = j;
				       }
			        } 
		        } 
		   
		        return checkMin;

	} 
		
		
	public int getFindOuterGeo(LinkedList<LinkedList<Point>> pointsList){
			
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
			
		    	return getFindOuterGeo(xpoints,ypoints,tnump,tc2);
	}

}
