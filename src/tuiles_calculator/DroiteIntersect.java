package tuiles_calculator;

public class DroiteIntersect {

	// values for d:ax +by+c=0
	private Double a = null;
	private Double b = null;
	private Double c = null;
	private String name = "";
	
	// values for z = az * x + bz * y + cz
	private double az = 0;
	private double bz = 0;
	private double cz = 0;
	
	
	public DroiteIntersect(Plan plan1, Plan plan2)	{
		name = plan1.plan_name() + " vs " + plan2.plan_name();
		if(plan1.check_parallel(plan2) ) {
			// do nothing			
		}else if(plan2.planc() == 0){
			a = plan2.plana();
			b = plan2.planb();
			c = plan2.pland();
			// do nothing for az, bz and cz
		}else {
			a = plan1.plana() - ( plan1.planc() * plan2.plana() / plan2.planc()  );
			b = plan1.planb() - ( plan1.planc() * plan2.planb() / plan2.planc()  );
			c = plan1.pland() - ( plan1.planc() * plan2.pland() / plan2.planc()  );
			
			az = -plan2.plana() / plan2.planc();
			bz = -plan2.planb() / plan2.planc();
			cz = -plan2.pland() / plan2.planc();
		}
	}
			

	public String droite_name() {
		return name;
	}

	

	// donne la partie "a" de ax+by+c = 0
	public double droitea() {
		return (a);		
	}

	// donne la partie "b" de ax+by+c = 0
	public double droiteb() {
		return (b);		
	}

	// donne la partie "c" de ax+by+c = 0
	public double c() {
		return (c);		
	}
	
	public double y_value(double x) {
		if(b == 0) {
			return( Math.random() * 10 + x);
		}else {
			return( -(c + a * x) / b );
		}
	}
	
	public String droite_details() {
		return(name + " --  d: "+
				String.valueOf(  (double)Math.round(a*1000)/1000 ) + "*x  +  " +
				String.valueOf(  (double)Math.round(b*1000)/1000 ) + "*y  +  " +
				String.valueOf(  (double)Math.round(c*1000)/1000 ) + " = 0");
	}
	
	public String droite_z_details() {
		return("z = "+
				String.valueOf(  (double)Math.round(az*1000)/1000 ) + "*x  +  " +
				String.valueOf(  (double)Math.round(bz*1000)/1000 ) + "*y  +  " +
				String.valueOf(  (double)Math.round(cz*1000)/1000 ) );
	}
}
