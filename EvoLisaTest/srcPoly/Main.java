import java.awt.Graphics;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

public class Main
{
	static final int AnzPoly=50; //erzeugen der Polygone
	public static void main(String[] args) 
	{
		
		Polygongen poly[] = new Polygongen();
		for (int i=0; i < AnzPoly; i++)
		{
			poly[i];
			poly.setX(i,50);
			poly.setY(i, 45);
			//polygon.npoints;
			//polygon.alpha;
			poly.setRot(i, 235);
			poly.setGruen(i, 0);
			poly.setBlau(i, 0);
		}
	}
}