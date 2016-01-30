<b>Find the third point to create an equilateral triangle given 2 points</b>


The method getEquilateral(args ...) returns a double[] array with 4 values:

        array[0] : X coordinate of point1
        array[1] : Y coordinate of point1
        array[2] : X coordinate of point2
        array[3] : Y coordinate of point2
        

This method returns two points, because there are two possible equilateral triangles for a every line segment.  
  
  
  
You can call this method with the following input formats:

       getEquilateral(double x1, double y1, double x2, double y2)
       
       getEquilateral(int x1, int y1, int x2, int y2)
       
       getEquilateral(Point p1, Point p2, Point p2)
       
       getEquilateral(double[] xy1, double[] xy2)
       
       getEquilateral(int[] xy1, int[] xy2)
       
       getEquilateral(LinkedList<Point> points)
       
       
<b> Example: </b>

      double getPoints[] = new double[4];
      FindEquilateral equilateral = new FindEquilateral();
      int xy1[] = new int[]{10,20}; // {x,y}
      int xy2[] = new int[]{40,50}; // {x,y}
    
      getPoints = equilateral.getEquilateral(xy1,xy2);
