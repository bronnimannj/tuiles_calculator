package tuiles_calculator;


// contient tous les details concernant un point: 
// ses coordonnes, son angle, et quel type d'angle a ete donne
public class Point {


	private double X, Y;
	private double angle;
	
	public Point(double x1, double y1, double alpha, String type_angle)
	{
		X = x1;
		Y = y1;

		if(type_angle == "d") {
			angle = Math.toRadians(alpha);			
		}else if(type_angle == "p") {
			angle = Math.atan(alpha);	
		}

	}
	

	// donne la partie "a" de ax+by+cz+d = 0
	public double[] details() {
		double[] point_details = new double[3];

		point_details[0] = X;
		point_details[1] = Y;
		point_details[2] = angle;
		return point_details;		
	}
}
