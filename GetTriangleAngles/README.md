
<b>Find the angles (in degrees) of a triangle given 3 points</b>


The method getAngles(args[]) returns a double[] array with 3 values:

        double[0] : Angle φ1 
        double[1] : Angle φ2
        double[2] : Angle φ3
        
  
       &raquo; Angle φ1 is the angle between the lines  {(x1,y1),(x2,y2)} and {(x1,y1),(x3,y3)}

       &raquo; Angle φ1 is the angle between the lines  {(x2,y2),(x1,y1)} and {(x2,y2),(x3,y3)}

       &raquo; Angle φ1 is the angle between the lines  {(x3,y3),(x1,y1)} and {(x3,y3),(x2,y2)}
  
  
  
You can call this method with the following input formats:

       getAngles(double x1, double y1, double x2, double y2, double x3, double y3)
       
       getAngles(int x1, int y1, int x2, int y2, int x3, int y3)
       
       getAngles(Point p1, Point p2, Point p2, Point p3)
       
       getAngles(double[] xy1, double[] xy2, double xy3)
       
       getAngles(int[] xy1, int[] xy2, int[]xy3)

       
       
<b> Example: </b>

      double getangles[] = new double[3];
      TriangleAngles anglesM = new TriangleAngles();
      int xy1[] = new int[]{10,20}; // {x,y}
      int xy2[] = new int[]{40,50}; // {x,y}
      int xy3[] = new int[]{15,25}; // {x,y}
    
      getangles = anglesM.getAngles(xy1,xy2,xy3);
