<b>Find which geometry encloses the others, given N simple polygons</b>


The method getFindOuterGeo(args ...) returns an int which pinpoints the outer polygon.
 
<br></br>
  
  
You can call this method with the following input formats:

    getFindOuterGeo(LinkedList<Point> geo1,LinkedList<Point> geo2)
       
    getFindOuterGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3)
       
    getFindOuterGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4)
       
    getFindOuterGeo(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4,LinkedList<Point> geo5)
       
    getFindOuterGeo(LinkedList<LinkedList<Point>> geo)

<br></br>
 -------------------------------------------------------------------------------------------------------------------------
 <br></br>
 <b> Example: </b>
<br></br>
<img width="400" height="300" src="https://36.media.tumblr.com/1641b4291ef5592143d5623f08e8f0d0/tumblr_o209j1Ez3e1s1v7hso1_1280.png"></img>
<br></br>

 
        int outerGeo;
		FindOuterGeo getGeo = new FindOuterGeo();
		LinkedList<Point> points = new LinkedList<Point>();
		LinkedList<LinkedList<Point>> pointsList = new LinkedList<LinkedList<Point>>();
        // geo0
		points.add(new Point(20,20));
		points.add(new Point(30,20));
		points.add(new Point(30,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add geo0 to pointList
		points.clear();
		// geo1		
		points.add(new Point(10,10));
		points.add(new Point(50,10));
		points.add(new Point(10,50));
		points.add(new Point(50,50));
		pointsList.add((LinkedList<Point>) points.clone()); // add geo1 to pointList
		points.clear();
		// geo2		
		points.add(new Point(35,10));
		points.add(new Point(45,10));
		points.add(new Point(45,30));
		points.add(new Point(35,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add geo2 to pointList
		points.clear();
		
		outerGeo = getGeo.getFindOuterGeo(pointsList);
		
        System.out.println("Index of outer geometry: " + outerGeo);
