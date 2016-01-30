<b> LineIntersect.java has 3 methods you can call,given 4 points (x1,y1), (x2,y2), (x3,y3), (x4,y4) : </b>

------------------------------------------------------------------------------------------------------------------


   
   
<b>double[] getIntersect(args ...) : </b> 

    Returns a double[] array with the coordinates of the intersected point.
    
    array[0]: x coordinates of intersected point
    array[1]: y coordinates of intersected point

    If the value of array[2] is 1, then the intersected point is between the line segments of 
    {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)}.

    If the value of array[2] is 2, then the intersected point is NOT between the line segments of 
    {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)}.

    If the value of array[2] is -1, then the lines {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} are parallel.

---------- 

<b>Boolean Intersected(args ...) : </b> 

    Returns true if the lines {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} intersect and
    false if the lines are parallel.

---------- 

<b>Boolean IntersectedBetween(args ...) : </b> 

    Returns true if the intersected point is between the line segments of 
    {(x1,y1),(x2,y2)} and {(x3,y3),(x4,y4)} and false if the intersected point is NOT between or if the
    lines are parallel.
    
<br></br>
    
You can call these methods with the following input formats:
    
    getIntersect(double x1, double y1, double x2, double y2, double x3, double y3)
       
    getIntersect(int x1, int y1, int x2, int y2, int x3, int y3)
       
    getIntersect(Point p1, Point p2, Point p2, Point p3)
       
    getIntersect(double[] xy1, double[] xy2, double xy3)
       
    getIntersect(int[] xy1, int[] xy2, int[]xy3)
           
           
Same input formats apply to the methods <b>Intersected(args ...)</b> and <b>IntersectedBetween(args ...)</b> as well.

<br></br>

<b>Example:</b>

    double IntersectedPoint[] = new double[3];
    LineIntersect lineInter = new LineIntersect();
    Point p1 = new Point(0,0);
    Point p2 = new Point(20,5);
    Point p3 = new Point(10,30);
    Point p4 = new Point(45,25);
    
    IntersectedPoint = lineInter.getIntersect(p1,p2,p3,p4);
  
    if (IntersectedPoint[2] == -1){
       System.out.println("Lines are parallel!");
    }
