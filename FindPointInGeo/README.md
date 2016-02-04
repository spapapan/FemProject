<b>Find a point which lies within a simple polygon. It is an implementation of the crossing number 
algorithm also known as the even-odd rule algorithm</b>
 
-------------------------------------------------------------------------------------------------------------------------------
<br></br>

    The polygon can have holes. The method getPointInGeo return a double[][] array. The value double[0][0] 
    and double[0][1] represent the coordinates (x0,y0) of the point which lies within the outer geometry 
    of the polygon. The values of double[n][0] and double[n][1], n>0 represent the coordinates (xn,yn)
    which are inside the polygon but near the inner geometries. 

<br></br>

You can call this method with the following input formats:

    getPointInGeo(LinkedList<Point> geo1,LinkedList<Point> geo2)
       
    getPointInGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3)
       
    getPointInGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4)
       
    getPointInGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4,LinkedList<Point> geo5)
       
    getPointInGeo(LinkedList<LinkedList<Point>> geo)

<br></br>


<b>Important:</b>
    You can call getPointInGeo using a List of LinkedList<Point>, but the first  LinkedList<Point> must 
    contain the coordinates of the outer geometry.



 -------------------------------------------------------------------------------------------------------------------------
 <br></br>
 <b> Example: </b>
<br></br>
        
        int totalGeometries = 3;
        double getPoints[][] = new double[totalGeometries][2];
        FindPointInGeo pointIngeo = new FindPointInGeo();
		LinkedList<Point> points = new LinkedList<Point>();
		LinkedList<LinkedList<Point>> pointsList = new LinkedList<LinkedList<Point>>();
        // First geometry (Always the outer geometry)
		points.add(new Point(10,10));
		points.add(new Point(50,10));
		points.add(new Point(10,50));
		points.add(new Point(50,50));
		pointsList.add((LinkedList<Point>) points.clone()); // add first geometry to pointList
		points.clear();
		// Second geometry		
		points.add(new Point(20,20));
		points.add(new Point(30,20));
		points.add(new Point(30,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add second geometry to pointList
		points.clear();
		// Third geometry		
		points.add(new Point(35,10));
		points.add(new Point(45,10));
		points.add(new Point(45,30));
		points.add(new Point(35,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add third geometry to pointList
	    points.clear();
		
	    getPoints = pointIngeo.getPointInGeo(pointsList);
		
        System.out.println("Coordinates of point inside the polygon: " + getPoints[0][0] + ", " + getPoints[0][1]);
