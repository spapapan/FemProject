<b>Returns the intermediate points of a polygon, given N polygons.</b>

-------------------------------------------------------------

The method getDiscretizePolygon(args ...) returns a LinkedList of LinkedList< Point > with the coordinates of the intermediate points.
 
<br></br>
  
  
You can call this method with the following input formats:

    getDiscretizePolygon(LinkedList<Point> geo1,LinkedList<Point> geo2, int density)
       
    getDiscretizePolygon(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3, int density)
       
    getDiscretizePolygon(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4, int density)
       
    getDiscretizePolygon(LinkedList<Point> geo1,LinkedList<Point> geo2,LinkedList<Point> geo3,LinkedList<Point> geo4,LinkedList<Point> geo5, int density)
       
    getDiscretizePolygon(LinkedList<LinkedList<Point>> geo, int density)

<br></br>
The parameter density defines the amount of the intermediate points. It can take integer values from 1 to 10.
 -------------------------------------------------------------------------------------------------------------------------
 <br></br>
 

<b><i>Sample input</i> (first polygon: 4 points, second polygon: 3 points, third polygon: 3 points):</b>

<img width="500" height="400" src="https://40.media.tumblr.com/532cccfffb4389236023f533008c28d1/tumblr_o25qlgUBMY1s1v7hso1_1280.png"></img>

<b>For density = 5 : </b>


<img width="500" height="400" src="https://36.media.tumblr.com/62d3da57c641d4b5c05966564b24f155/tumblr_o25qye1NLt1s1v7hso1_1280.png"></img>

<b>For density = 2 : </b>


<img width="500" height="400" src="https://40.media.tumblr.com/460470c99a43cea2eb18e8b813acdfe3/tumblr_o25qzmdFAx1s1v7hso1_1280.png"></img>
<br></br>

<b> Example : </b>

		int density = 5;
		LinkedList<LinkedList<Point>> getPoints = new LinkedList<LinkedList<Point>>();
		DiscretizePolygon discretize = new DiscretizePolygon();
	    LinkedList<Point> points = new LinkedList<Point>();
	    LinkedList<LinkedList<Point>> pointsList = new LinkedList<LinkedList<Point>>();
	    // First geometry
	    points.add(new Point(200,200));
	    points.add(new Point(600,200));
	    points.add(new Point(600,600));
	    points.add(new Point(200,600));
	    pointsList.add((LinkedList<Point>) points.clone()); // add first geometry to pointList
	    points.clear();
	    // Second geometry      
	    points.add(new Point(300,300));
	    points.add(new Point(500,300));
	    points.add(new Point(500,500));
	    pointsList.add((LinkedList<Point>) points.clone()); // add second geometry to pointList
	    points.clear();
	    
	    getPoints = discretize.getDiscretizePolygon(pointsList, density);

	    int c1=0;
        for (LinkedList<Point> list : getPoints){
        	System.out.println("Intermediate coordinates for geometry: " + c1);
        	int c2=0;
        	
        	for (Point point : list){
        		System.out.println(c2 + " : " + " x: " + point.x + " , y: "+ point.y);
        		c2++;
        	}
        	c1++;
        }
