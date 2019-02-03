import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
<<<<<<< HEAD
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Polygongen
{
	private Polygon polylist[] = new Polygon[50];
	private Color farbe[] = new Color[50];
	private static int Counter = 0;
	public Polygongen(){
		int xPoly[] = {150, 250, 325, 375, 450};
        int yPoly[] = {125, 225, 250, 375, 300};
        for(int i=0;i<50;i++)
        {
        this.setPolygon(new Polygon(xPoly,yPoly,5), i);
        this.setColor(Color.GRAY, i);
        }
        
	}
	public Polygon getPolygon(int i)
	{
		return polylist[i];
	}
	public void setPolygon(Polygon p, int i)
	{
		polylist[i]=p;
	}
	public Color getColor(int i)
	{
		return farbe[i];
	}
	public void setColor(Color c, int i)
	{
		farbe[i]=c;
	}
	public static void imageSave(BufferedImage Img, String Path)
	{
		try {
		    // retrieve image
		    File outputfile = new File(Path+Counter+".png");
		    ImageIO.write(Img, "PNG", outputfile);
		    Counter++;
		} catch (IOException e) {}
	}
}
=======
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
>>>>>>> refs/remotes/origin/Integrate
