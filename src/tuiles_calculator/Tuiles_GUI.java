package tuiles_calculator;

//import java.util.*;  
import java.awt.*; 
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

import org.math.plot.*;

@SuppressWarnings("serial")
public class Tuiles_GUI extends JFrame {
	// for the Frame
	private JTable tableinput;
	private JTextArea txtOutput;
	private Plot2DPanel planOutput;

	// For the calculator
	private int nb_points = 0;
	public Point[] points;	
	double[] Pointsx;
	double[] Pointsy;
	public Plan[] plans;	
	public DroiteIntersect[][] droites;

	// Frame creation
	public Tuiles_GUI() {

		// Title
		setTitle("Commande de tuile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 626);
		getContentPane().setLayout(null);

		// Global menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1208, 22);
		getContentPane().add(menuBar);

		// Menu/Fichier 
		JMenu MFile = new JMenu("Fichier");
		menuBar.add(MFile);
		JMenuItem MFilesave = new JMenuItem("Sauvegarder");
		MFile.add(MFilesave);
		JMenuItem Mfileopen = new JMenuItem("Ouvrir");
		MFile.add(Mfileopen);
		JMenuItem Mfileimport = new JMenuItem("Importer");
		MFile.add(Mfileimport);
		JMenuItem Mfileexport = new JMenuItem("Exporter");
		MFile.add(Mfileexport);
		JMenuItem Mfileclose = new JMenuItem("Quitter");
		MFile.add(Mfileclose);

		// Menu/Ajouter
		JMenu Madd = new JMenu("Ajouter");
		menuBar.add(Madd);
		JMenu Maddopenning = new JMenu("Ouvertures");
		Madd.add(Maddopenning);
		JMenuItem MaddEdge = new JMenuItem("Rive");
		Madd.add(MaddEdge);

		// Menu/Ajouter/Ouvertures
		JMenuItem MaddopSkylight = new JMenuItem("Lucarne");
		Maddopenning.add(MaddopSkylight);
		JMenuItem MaddopRoofWindow = new JMenuItem("Fen\u00EAtre de toit");
		Maddopenning.add(MaddopRoofWindow);

		// Menu/Parametres
		JMenu Moption = new JMenu("Param\u00E8tres");
		menuBar.add(Moption);
		JMenu Moptionlang = new JMenu("langue");
		Moption.add(Moptionlang);
		JMenuItem Moptionunit = new JMenuItem("Unit\u00E9s...");
		Moption.add(Moptionunit);
		JMenuItem Moptiondetails = new JMenuItem("D\u00E9tails techniques");
		Moption.add(Moptiondetails);

		// Menu/Parametres/Langues
		JMenuItem MlangFr = new JMenuItem("Fran\u00E7ais");
		Moptionlang.add(MlangFr);
		JMenuItem MlangDE = new JMenuItem("Deutsch");
		Moptionlang.add(MlangDE);
		JMenuItem MlangEN = new JMenuItem("English");
		Moptionlang.add(MlangEN);

		// Menu/Sources
		JMenu Msources = new JMenu("Sources");
		menuBar.add(Msources);
		JMenuItem Msourcedata = new JMenuItem("Fiches techniques tuiles");
		Msources.add(Msourcedata);
		JMenuItem Msourceabout = new JMenuItem("\u00E0 propos");		
		Msources.add(Msourceabout);


		// Titles of each Panel		
		JLabel LbTopview = new JLabel("Vue en plan");
		LbTopview.setFont(new Font("Tahoma", Font.BOLD, 14));
		LbTopview.setBounds(580, 30, 93, 25);
		getContentPane().add(LbTopview);

		JLabel LbInput = new JLabel("<html>Entrées (pente en \u00B0 si box clicked). <br>1ère pente = pente quand on ferme le cercle.</html>");
		LbInput.setFont(new Font("Tahoma", Font.BOLD, 14));
		LbInput.setBounds(10, 30, 537, 50);
		getContentPane().add(LbInput);

		tableinput = new JTable();
		tableinput.setRowSelectionAllowed(false);
		tableinput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableinput.setBorder(null);
		tableinput.setModel(new DefaultTableModel(
				new Object[][] {
					{"A",   null, null, null, false},
					{"B",   null, null, null, false},
					{"C",   null, null, null, false},
					{"D",   null, null, null, false},
					{"E",   null, null, null, false},
					{"F",   null, null, null, false},
					{"G",   null, null, null, false},
					{"H",   null, null, null, false},
					{"I",   null, null, null, false},
					{"J",   null, null, null, false},
					{"K",   null, null, null, false},
					{"...", null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false},
					{null,  null, null, null, false}},
				new String[] {
						"#point", "Coordonn\u00E9e X", "Coordonn\u00E9e Y", "Pente", "%/\u00B0"
					}
				) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, Double.class, Double.class, Double.class, Boolean.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableinput.getColumnModel().getColumn(0).setResizable(false);
		tableinput.getColumnModel().getColumn(0).setPreferredWidth(44);
		tableinput.getColumnModel().getColumn(1).setResizable(false);
		tableinput.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableinput.getColumnModel().getColumn(2).setResizable(false);
		tableinput.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableinput.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableinput.getColumnModel().getColumn(4).setResizable(false);
		tableinput.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableinput.setRowHeight(15);


		JScrollPane scrollPane_1 = new JScrollPane(tableinput);
		scrollPane_1.setToolTipText("");
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 80, 520, 275);
		getContentPane().add(scrollPane_1);

		// Plot area
		draw_init(true);

		// Area for outputs
		txtOutput = new JTextArea();
		txtOutput.setEditable(false);
		txtOutput.setBackground(Color.WHITE);
		txtOutput.setForeground(Color.BLACK);
		txtOutput.setText("Output");
		txtOutput.setColumns(10);
		JScrollPane scrollPane_2 = new JScrollPane(txtOutput);
		scrollPane_2.setBounds(10, 425, 1150, 157);
		getContentPane().add(scrollPane_2);



		/* button to make everything run, and actions when the button is pressed:
		 *  1. Get the number of COMPLETE points. Stops as soon as there is one incomplete
		 *  2. Read all the points
		 *  3. Create the plans
		 */
		JButton btnNewButton = new JButton("Calculer");
		btnNewButton.setBounds(430, 375, 100, 25);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				get_nb_points();
				get_Points();
				get_Plans();
				get_Droites();
			}
		});

	}

	// (re) - initialise the plot
	public void draw_init(boolean start) {
		if(!start) {
			getContentPane().remove(planOutput);
		}
		planOutput = new Plot2DPanel();
		planOutput.setBackground(Color.WHITE);
		planOutput.setBorder(null);
		planOutput.setBounds(580, 60, 580, 340);
		getContentPane().add(planOutput);

	}

	// test if a point has had all the details inputed
	public boolean check_line_complete( int row) {

		return( (tableinput.getValueAt(row, 0) != null) &&
				(tableinput.getValueAt(row, 1) != null) &&
				(tableinput.getValueAt(row, 2) != null) &&
				(tableinput.getValueAt(row, 3) != null) &&
				(tableinput.getValueAt(row, 4) != null )	);	
	}

	// read the line of the table and output a point
	public Point read_line( int row) {
		Point point = new Point( (String) tableinput.getValueAt(row, 0),
				(Double) tableinput.getValueAt(row, 1),
				(Double) tableinput.getValueAt(row, 2),
				(Double) tableinput.getValueAt(row, 3),
				(Boolean) tableinput.getValueAt(row, 4));
		return( point );
	}

	public void get_nb_points() {
		// reinitialise the nb of points
		nb_points = 0;
		for(int i = 0; i<30; i++ ) {
			if(check_line_complete(i)) {
				nb_points += 1;
			}else {
				break;
			}
		}
	}

	// Points reading and outputing
	public void get_Points() {	

		// reinitialisation if needed
		Pointsx = new double[nb_points+1];
		Pointsy = new double[nb_points+1];
		points = new Point[nb_points];

		txtOutput.setText( "Vous avez donné " + String.valueOf(nb_points) + " points : \n\n" );
		for(int i = 0; i<nb_points; i++ ) {
			txtOutput.append( "Point nb " + String.valueOf( i+1 ) +" : " );
			// reading
			points[i] = read_line( i);

			// outputing
			Pointsx[i] = points[i].details()[0];
			Pointsy[i] = points[i].details()[1];				
			txtOutput.append(points[i].point_details() + "\n");
		}

		// plot the points
		if(nb_points > 0) {
			draw_init(false);
			// close the cicle
			Pointsx[nb_points] = points[0].details()[0];
			Pointsy[nb_points] = points[0].details()[1];	
			planOutput.addLegend("SOUTH");
			planOutput.addLinePlot("Points given", Color.BLACK ,Pointsx, Pointsy);	

		}	

		txtOutput.append("\n\n");

	}


	public void get_Plans() {
		plans = new Plan[nb_points];

		if(nb_points>1) {
			// inputs
			for(int i = 1; i<nb_points; i++ ) {
				plans[i-1] = new Plan(points[i-1], points[i]);
			}
			plans[nb_points-1] = new Plan(points[nb_points - 1], points[0]);


			// outputs
			txtOutput.append("Les details des plans entre les points sont:\n\n");
			for(int i = 0; i<nb_points; i++ ) {
				txtOutput.append(plans[i].plan_details() + "\n");
			}
		}else if(nb_points == 1) {
			txtOutput.append("Nous avons besoin d'au moins 2 points pour un plan");
		}	

		txtOutput.append("\n\n");	
	}

	public double min_vec(double[] vecinput) {
		int lengthinput = vecinput.length;
		double output = vecinput[0];
		if(lengthinput>1) {
			for(int i = 1; i < lengthinput; i++) {
				output = Math.min(output, vecinput[i]);
			}
		}
		return(output);		
	}
	public double max_vec(double[] vecinput) {
		int lengthinput = vecinput.length;
		double output = vecinput[0];
		if(lengthinput>1) {
			for(int i = 1; i < lengthinput; i++) {
				output = Math.max(output, vecinput[i]);
			}
		}
		return(output);		
	}

	// matrice triangulaire superieure où D_ij = droite d'intersection entre plan Pi et Pj
	public void get_Droites() {
		droites = new DroiteIntersect[nb_points][nb_points];

		// values to plot the segments
		double[] x1  = {min_vec(Pointsx), 0.0};
		double[] x2 = {max_vec(Pointsx),0.0};


		if(nb_points>2) {
			// inputs
			for(int i = 0; i < nb_points - 1; i++ ) {
				for(int j = i + 1; j < nb_points; j++ ) {
					droites[i][j] = new DroiteIntersect(plans[i], plans[j]);
				}
			}	

			// outputs
			txtOutput.append("Les details des droites d'intersection entre les points sont:\n\n");
			for(int i = 0; i < nb_points - 1; i++ ) {
				for(int j = i + 1; j < nb_points; j++ ) {
					txtOutput.append(droites[i][j].droite_details() + "\n");
				}
			}

			// plot the droites
			for(int i = 0; i < nb_points - 1; i++ ) {
				for(int j = i + 1; j < nb_points; j++ ) {
					x1[1] = (double) Math.round(droites[i][j].y_value(x1[0]) *1000)/1000;
					x2[1] = (double) Math.round(droites[i][j].y_value(x2[0]) *1000)/1000;

					planOutput.addLinePlot( droites[i][j].droite_name(),
							new double[] {x1[0],x1[1]},new double[] {x2[0],x2[1]});
				}
			}
		}else {
			txtOutput.append("Nous avons besoin d'au moins 3 points pour des droites d'intersection");
		}	

		txtOutput.append("\n\n");
	}



	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tuiles_GUI frame = new Tuiles_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
