import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Poly.Polygongen;
public class Polygongen
{
	private final int PolyNum = 50;
	private static File isBetterFile;
	private static String Path ="C:\\";
	private static BufferedImage pic;
	private static Polygon polylist[] = new Polygon[50];
	private static Color farbe[] = new Color[50];
	private static int Counter = 0;
	public Polygongen(Dimension ObjMax){
		int xPoly[] = {150, 250, 325, 375, 450};
        int yPoly[] = {125, 225, 250, 375, 300};
        
        
        pic = new BufferedImage(ObjMax.height, ObjMax.width, BufferedImage.TYPE_INT_RGB);;
    	Graphics2D image = pic.createGraphics();
    	for(int i=0;i<PolyNum;i++)
        {
        this.setPolygon(new Polygon(xPoly,yPoly,5), i);
        this.setColor(Color.GRAY, i);
        image.setColor(this.getColor(i));
        image.fillPolygon(this.getPolygon(i));
    	//pic.createGraphics(image);
        Polygongen.imageSave(pic);
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
	public static void imageSave(BufferedImage Img)
	{
		try {
		    // retrieve image
		   isBetterFile = new File(Path+Counter+".png");
		    ImageIO.write(Img, "PNG", isBetterFile);
		    Counter++;
		} catch (IOException e) {}
	}
	public void setPath(String Path)
	{
		Polygongen.Path = Path;
	}
	public String getPath()
	{
		return Path;
	}
}
