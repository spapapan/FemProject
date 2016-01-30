
<b>Find the center and radius of a circle given 3 points</b>


The method GetCircleCenter(args[]) returns a double[] array with 3 values:

        double[0] : X coordinate of Circle
        double[1] : Y coordinate of Circle
        double[2] : Radius of Circle
        
  
  
  
  
You can call this method with the following point formats:

       GetCircleCenter(double x1, double y1, double x2, double y2, double x3, double y3)
       
       GetCircleCenter(int x1, int y1, int x2, int y2, int x3, int y3)
       
       GetCircleCenter(Point p1, Point p2, Point p2, Point p3)
       
       GetCircleCenter(double[] xy1, double[] xy2, double xy3)
       
       GetCircleCenter(int[] xy1, int[] xy2, int[]xy3)
       
       GetCircleCenter(LinkedList<Point> points)
       
       
<b> Example: </b>

      double getCircle[] = new double[3];
      CircleCenter circleM = new CircleCenter();
      int xy1[] = new int[]{10,20}; // {x,y}
      int xy2[] = new int[]{40,50}; // {x,y}
      int xy3[] = new int[]{15,25}; // {x,y}
    
      getCircle = circleM.GetCircleCenter(xy1,xy2,xy3);
