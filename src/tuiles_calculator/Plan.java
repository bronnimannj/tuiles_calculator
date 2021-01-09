package tuiles_calculator;

// a partir de 2 points et un angle alpha, calculons le plan tel que:
// - passe par le segment entre les deux points
// - son angle avec le plan horizontal est alpha
// - si on suit le segment, le plan est penché "à gauche".
public class Plan {

	private double Px1, Px2, Py1, Py2;
	private double angle;

	public Plan(double x1, double y1, double x2, double y2, double alpha)
	{
		Px1 = x1;
		Px2 = x2;
		Py1 = y1;
		Py2 = y2;
		angle = Math.toRadians(alpha);
	}

	// donne la partie "a" de ax+by+cz+d = 0
	public double plana() {
		return (Py2 - Py1);		
	}

	// donne la partie "b" de ax+by+cz+d = 0
	public double planb() {
		return (Px1 - Px2);		
	}

	// donne la partie "c" de ax+by+cz+d = 0
	public double planc() {
		double d = 1 / Math.tan(angle) * Math.sqrt( Math.pow(Py2 - Py1,2) + Math.pow(Px2 - Px1,2) ) ;
		return (Math.round(d * 1000) / 1000);		
	}

	// donne la partie "d" de ax+by+cz+d = 0
	public double pland() {
		return ( Py1 * Px2 - Px1 * Py2  );		
	}

	
}
