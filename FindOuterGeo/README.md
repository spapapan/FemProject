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
<img width="400" height="300" src="https://40.media.tumblr.com/980acc62e37b0c2276029f3551e29744/tumblr_o1zy73BDBy1s1v7hso1_1280.png"></img>
<br></br>

 
        int outerGeo;
		FindOuterGeo getGeo = new FindOuterGeo();
		LinkedList<Point> points = new LinkedList<Point>();
		LinkedList<LinkedList<Point>> pointsList = new LinkedList<LinkedList<Point>>();
        // First geometry
		points.add(new Point(20,20));
		points.add(new Point(30,20));
		points.add(new Point(30,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add first geometry to pointList
		points.clear();
		// Second geometry		
		points.add(new Point(10,10));
		points.add(new Point(50,10));
		points.add(new Point(10,50));
		points.add(new Point(50,50));
		pointsList.add((LinkedList<Point>) points.clone()); // add Second geometry to pointList
		points.clear();
		// Third geometry		
		points.add(new Point(35,10));
		points.add(new Point(45,10));
		points.add(new Point(45,30));
		points.add(new Point(35,40));
		pointsList.add((LinkedList<Point>) points.clone()); // add Second geometry to pointList
		points.clear();
		
		outerGeo = getGeo.getFindOuterGeo(pointsList);
		
        System.out.println("Index of outer geometry: " + outerGeo);
