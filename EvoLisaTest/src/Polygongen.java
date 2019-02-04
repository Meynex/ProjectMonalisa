import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Polygongen
{
	private final int PolyNum = 50;
	private static File isBetterFile;
	private static boolean isBetter;
	private static String Path ="D:\\pics\\";
	private static BufferedImage pic;
	private static Polygon polylist[] = new Polygon[50];
	private static Color farbe[] = new Color[50];
	private static int Counter = 0;
	private static Dimension OriDimension;

	private int xPoly[] = {150, 250, 325, 375, 450};
    private int yPoly[] = {125, 225, 250, 375, 300};
	public Polygongen(int height, int width){
        OriDimension = new Dimension(height, width);
        
        pic = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);;
    	Graphics2D image = pic.createGraphics();
    	
    	
    	for(int i=0;i<PolyNum;i++)
        {
        this.setPolygon(new Polygon(xPoly,yPoly,5), i);
        this.setColor(Color.GRAY, i);
        
        //make Graphic
        image.setColor(this.getColor(i));
        image.fillPolygon(this.getPolygon(i));
    	//pic.createGraphics(image);
        }
    	Polygongen.imageSave(pic);
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
		} catch (IOException e) {}
	}
	public void setDirPath(String Path)
	{
		Polygongen.Path = Path;
	}
	public String getDirPath()
	{
		return Path;
	}
	public static String getFilePath()
	{
		return isBetterFile.getAbsolutePath();
	}
	public static void isBetter()
	{
		GUI.BetterFilePath(isBetterFile.getAbsolutePath());
		Counter++;
	}
	/**
	 * 
	 */
	public void render() {
		pic = new BufferedImage(OriDimension.height,OriDimension.width, BufferedImage.TYPE_INT_ARGB);;
    	Graphics2D image = pic.createGraphics();
    	
    	for(int i=0 ;i<PolyNum;i++)
    	{
    		image.setColor(this.getColor(i));
            image.fillPolygon(this.getPolygon(i));
    	}
    	Polygongen.imageSave(pic);
	}
}
