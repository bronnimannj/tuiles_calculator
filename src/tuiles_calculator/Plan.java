package tuiles_calculator;

// a partir de 2 points et un angle alpha, calculons le plan tel que:
// - passe par le segment entre les deux points
// - son angle avec le plan horizontal est alpha
// - si on suit le segment, le plan est penché "à gauche".
public class Plan {

	private double Px1, Px2, Py1, Py2;
	private double angle;
	private String name;

	public Plan(Point P1, Point P2)
	{
		Px1 = P1.details()[0];
		Px2 = P2.details()[0];
		Py1 = P1.details()[1];
		Py2 = P2.details()[1];
		angle = P2.details()[2];
		name = P1.point_name() + "->" + P2.point_name();
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
		return ((double)Math.round(d * 1000) / 1000);		
	}

	// donne la partie "d" de ax+by+cz+d = 0
	public double pland() {
		return ( Py1 * Px2 - Px1 * Py2  );		
	}

	public String plan_name() {
		return name;
	}

	public double[] plan_coordonnees() {

		double[] coordinates = new double[4];

		coordinates[0] = plana();
		coordinates[1] = planb();
		coordinates[2] = planc();
		coordinates[3] = pland();

		return coordinates;
	}
	

	public String plan_details() {
		return(name + ": "+
				String.valueOf(  (double)Math.round(plana()*1000)/1000 ) + "*x  +  " +
				String.valueOf(  (double)Math.round(planb()*1000)/1000 ) + "*y  +  " +
				String.valueOf(  (double)Math.round(planc()*1000)/1000 ) + "*z  +  " +
				String.valueOf(  (double)Math.round(pland()*1000)/1000 ) + " = 0");
	}
}
