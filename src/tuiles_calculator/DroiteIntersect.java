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
		
		if(plan1.plan_name() == "Default plan2" &
				plan2.plan_name() == "Default plan2") {
			name = "Default Droite";
		}else {
			name = plan1.plan_name() + " vs " + plan2.plan_name();
		}
				
		
		if(plan1.check_parallel(plan2) | 
				name == "Default Droite" |
				plan1.check_vertical() | plan2.check_vertical()   ) {
			// do nothing			
		}else if(plan2.planc() == 0){
			a = plan2.plana();
			b = plan2.planb();
			c = plan2.pland();
			// do nothing for az, bz and cz
		}else if(plan1.planc() == 0){
			a = plan1.plana();
			b = plan1.planb();
			c = plan1.pland();
			// do nothing for az, bz and cz
		}else {
			a = plan1.plana() - ( plan1.planc() * plan2.plana() / plan2.planc()  );
			b = plan1.planb() - ( plan1.planc() * plan2.planb() / plan2.planc()  );
			c = plan1.pland() - ( plan1.planc() * plan2.pland() / plan2.planc()  );
			
			az = -plan2.plana() / plan2.planc();
			bz = -plan2.planb() / plan2.planc();
			cz = -plan2.pland() / plan2.planc();
		}
		
		if(b != null && b != 0) {
			a = a / b;
			c = c / b;
			b = 1.0;
		}else if(a != null && a != 0) {
			b = b / a;
			c = c / a;
			a = 1.0;
		}
	}
			

	public String droite_name() {
		return name;
	}

	public boolean real_droite() {
		return(!(a == null | 
				b == null |
				c == null | 
				name == "Default Droite") &&
				!( (a == 0 && c == 0) |
					(b == 0 && c == 0) ));
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
	public double droitec() {
		return (c);		
	}
	
	public double y_value(double x) {
		if(b == 0) {
			return( Math.random() * 10 + x);
		}else {
			return( -(c + a * x) / b );
		}
	}
	
	public Point point_intersec(DroiteIntersect dr2) {
		
		String nom = "PT:" + name + " .int. " + dr2.droite_name();
		
		if(b * dr2.droitea() + a * dr2.droiteb() == 0) {
			return new Point("DefaultIntersection", 0.0, 0.0, 0.0, true);
		}else {
			double x1 = ( b * dr2.droitec() - c *  dr2.droiteb() ) / ( a* dr2.droiteb() - b * dr2.droitea() );
			double y1;
			if(dr2.droiteb() != 0) {
				y1 = - 1 / dr2.droiteb() * ( dr2.droitec()  + dr2.droitea() * x1 )  ;
			}else{
				y1 = - 1 / b * ( c  + a * x1 )  ;
			}
						
			return new Point(nom, x1, y1, 0.0, true);
		}

	}
	
	public String droite_details() {
		if(real_droite()) {
			return(name + " --  d: "+
					String.valueOf(  (double)Math.round(a*1000)/1000 ) + "*x  +  " +
					String.valueOf(  (double)Math.round(b*1000)/1000 ) + "*y  +  " +
					String.valueOf(  (double)Math.round(c*1000)/1000 ) + " = 0");
		} else {
			return(name + " -- d: pas une droite");
		}
		
	}
	
	public String droite_z_details() {
		return("z = "+
				String.valueOf(  (double)Math.round(az*1000)/1000 ) + "*x  +  " +
				String.valueOf(  (double)Math.round(bz*1000)/1000 ) + "*y  +  " +
				String.valueOf(  (double)Math.round(cz*1000)/1000 ) );
	}
}
