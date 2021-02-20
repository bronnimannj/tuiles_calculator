package tuiles_calculator;


// contient tous les details concernant un point: 
// ses coordonnes, son angle, et quel type d'angle a ete donne
public class Point {

	private String name;
	private double X, Y;
	private double angle;
	
	public Point(String nom, double x1, double y1, double alpha, boolean angle_is_degree)
	{
		X = x1;
		Y = y1;
		name = nom;
		
		if(angle_is_degree) {
			angle = Math.toRadians(alpha);			
		}else {
			angle = Math.atan(alpha/100);	
		}

	}
	
	public void set_coordonnee(int axis, double coordonnee) {
		if(axis == 0) {
			X = coordonnee;
		}else if(axis == 1) {
			Y = coordonnee;
		}
	}
	
	public double point_dist(Point P2) {
		return( Math.sqrt(Math.pow(X - P2.details()[0], 2) + Math.pow(Y - P2.details()[1], 2)) );
	}	
	
	// donne la partie "a" de ax+by+cz+d = 0
	public double[] details() {
		double[] point_details = new double[3];

		point_details[0] = X;
		point_details[1] = Y;
		point_details[2] = angle;
		return point_details;		
	}
	
	public String point_name() {
		return name;
	}
		
	public boolean check_equal(Point P) {
		return( (X == P.details()[0]) && 
				(Y == P.details()[1]) && 
				((double)Math.round(angle*1000)/1000 == (double)Math.round(P.details()[2]*1000)/1000 ) );
	}
	
	public String point_details() {
		return(name +"( " + String.valueOf(X) + " ; " +
				String.valueOf(Y) + " ), angle " +
				String.valueOf( (double)Math.round(angle*1000)/1000 ) +
				" Rad  --  ( ou " +
				String.valueOf( (double)Math.round( Math.toDegrees(angle) * 1000)/1000 ) + 
				" deg ou " +
				String.valueOf( (double)Math.round( Math.tan(angle) * 1000)/10 ) + 
				" % )");
	}
}
