import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
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
