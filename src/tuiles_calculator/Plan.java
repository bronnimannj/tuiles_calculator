package tuiles_calculator;

// a partir de 2 points et un angle alpha, calculons le plan tel que:
// - passe par le segment entre les deux points
// - son angle avec le plan horizontal est alpha
// - si on suit le segment, le plan est penché "à gauche".
public class Plan {

	private double Px1, Px2, Py1, Py2;
	private double angle;
	private String name;
	
	private double a,b,c,d;

	public Plan(Point P1, Point P2)
	{
		
		Px1 = P1.details()[0];
		Px2 = P2.details()[0];
		Py1 = P1.details()[1];
		Py2 = P2.details()[1];
		angle = P2.details()[2];
		
		a = Py2 - Py1;
		b = Px1 - Px2;
		c = (double) Math.round(1 / Math.tan(angle) * Math.sqrt( Math.pow(Py2 - Py1,2) + Math.pow(Px2 - Px1,2) )* 1000) / 1000;
		d = Py1 * Px2 - Px1 * Py2;
		
		// some simplification
		if(d != 0.0 & c == 0.0 & b == 0.0 & a != 0.0) { 	
			d = d / a;
			a = 1;
		}
		if(d != 0.0 & c == 0.0 & b != 0.0 & a == 0.0) {
			d = d / b;
			b = 1;
		}
		
		
		if(P1.point_name() == "Default point" &
				P2.point_name() == "Default point") {
			name = "Default Plan";
		}else {
			name = P1.point_name() + "->" + P2.point_name();
		}
		
	}
	

	// donne la partie "a" de ax+by+cz+d = 0
	public double plana() {
		return a;			
	}

	// donne la partie "b" de ax+by+cz+d = 0
	public double planb() {
		return b;
	}

	// donne la partie "c" de ax+by+cz+d = 0
	public double planc() {
		return c;	
					
	}

	// donne la partie "d" de ax+by+cz+d = 0
	public double pland() {
		return d;				
	}

	public String plan_name() {
		return name;
	}


	public boolean check_equal(Plan P) {
		return( (a == P.plana()) && 
				(b == P.planb()) && 
				(c == P.planc()) && 
				(d == P.pland())  );
	}

	public boolean check_parallel(Plan P) {
		
		double lambda = 0.0;
		if(P.plana() != 0) {
			lambda = a / P.plana();
			return( b / P.planb() == lambda &&
					c / P.planc() == lambda );
		}else if(P.planb() != 0) {
			lambda = b / P.planb();
			return(a == 0 &&  c / P.planc() == lambda );
		}else {
			return(a == 0 && b == 0);
		}
	}

	public boolean check_perpendicular(Plan P) {
		
		return(a  * P.plana() + b * P.planb() + c * P.planc() == 0.0);
	}

	public boolean check_vertical() {
		
		return( (d != 0.0 & c == 0.0 & b == 0.0 & a != 0.0)  |
				(d != 0.0 & c == 0.0 & b != 0.0 & a == 0.0)  |
				(d != 0.0 & c == 0.0 & b != 0.0 & a != 0.0) );			
	}

	public boolean checkreal() {
		
		return( ! (d == 0.0 & c == 0.0 & b == 0.0 & a != 0.0)  |
				! (d == 0.0 & c == 0.0 & b != 0.0 & a == 0.0) |
				! (d == 0.0 & c != 0.0 & b == 0.0 & a == 0.0));			
	}
	
	
	public double[] plan_coordonnees() {

		double[] coordinates = new double[4];

		coordinates[0] = a;
		coordinates[1] = b;
		coordinates[2] = c;
		coordinates[3] = d;

		return coordinates;
	}
	

	public String plan_details() {
		return(name + ": "+
				String.valueOf(  (double)Math.round(a*1000)/1000 ) + "*x  +  " +
				String.valueOf(  (double)Math.round(b*1000)/1000 ) + "*y  +  " +
				String.valueOf(  (double)Math.round(c*1000)/1000 ) + "*z  +  " +
				String.valueOf(  (double)Math.round(d*1000)/1000 ) + " = 0");
	}
}
