package tuiles_calculator;

import java.util.Scanner;


public class TuilesCalculator {


	private Plan plan;

	// definition d'un calculateur
	public TuilesCalculator() {

		// Creates a reader instance which takes
		Scanner reader = new Scanner(System.in);

		System.out.print("Enter X1: ");
		double x1 = reader.nextDouble();        
		System.out.println("You entered: " + x1);

		System.out.print("Enter Y1: ");
		double y1 = reader.nextDouble();        
		System.out.println("You entered: " + y1);

		System.out.print("Enter X2: ");
		double x2 = reader.nextDouble();        
		System.out.println("You entered: " + x2);

		System.out.print("Enter Y2: ");
		double y2 = reader.nextDouble();        
		System.out.println("You entered: " + y2);

		System.out.print("Enter alpha (in degrees): ");
		double alpha = reader.nextDouble();        
		System.out.println("You entered: " + alpha);

		// close the scanner
		reader.close();

		plan = new Plan(x1,y1,x2,y2,alpha);

	}


	public double[] plan_coordonnees() {

		double[] coordinates = new double[4];

		coordinates[0] = plan.plana();
		coordinates[1] = plan.planb();
		coordinates[2] = plan.planc();
		coordinates[3] = plan.pland();

		return coordinates;
	}

	public static void main(String args[]) {

		TuilesCalculator tc = new TuilesCalculator();
		double[] coordonnees = tc.plan_coordonnees();

		System.out.println("The value a is: " + coordonnees[0]);
		System.out.println("The value b is: " + coordonnees[1]);
		System.out.println("The value c is: " + coordonnees[2]);
		System.out.println("The value d is: " + coordonnees[3]);


	}


}

