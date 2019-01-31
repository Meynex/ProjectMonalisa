import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
 class Polygongen extends JPanel {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//erstellen der Klasse Polygon
	 final double alpha = 0.1;
	 //private int x;		// x-Koordinaten der Polygone
	 //private int y;		// y-Koordinaten der Polygone
	 private Polygon p[];
	 final int npoints = 5; 	// Anzahl der Knoten der Polygone
	 private int rot[];
	 private int gruen[];
	 private int blau[];
	 
	 {
		 for(int i = 0 ; i<npoints; i++) 
		 { 
			 p[0].xpoints[i] = 20;
			 p[0].ypoints[i] = 30;
		 }
	 }
	
	 public void setPointY(Point po, int i, int y) 
	  {
		p[i].ypoints[y]= new Point();
	  }
	  
	  public void setGruen(int i, int z)
	  {
		  gruen[i]=z;
	  }
	  
	  public int getGruen(int i)
	  {
		  return gruen[i];
	  }
	  public void setRot(int i, int z)
	  {
		  rot[i]=z;
	  }
	  
	  public int getRot(int i)
	  {
		  return rot[i];
	  }
	  public void setBlau(int i, int z)
	  {
		  blau[i]=z;
	  }
	  
	  public int getBlau(int i)
	  {
		  return blau[i];
	  }
 }