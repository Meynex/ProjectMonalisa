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
}import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
public class Main {

    private JFrame mainMap;
    private Polygon poly;
    private static BufferedImage pic;

    public Main() {

        initComponents();

    }

    private void initComponents() {

        mainMap = new JFrame();
        mainMap.setResizable(false);

        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int xPoly[] = {150, 250, 325, 375, 450};
        int yPoly[] = {125, 225, 250, 375, 300};

        poly = new Polygon(xPoly, yPoly, 5);
    	
    	
    	JFrame notification = new JFrame();
        notification.setSize(new Dimension(320,64));
        notification.setLocation(0, 0);
        notification.setUndecorated(true);
        notification.setVisible(true);

        JPanel JP = new JPanel();
        /*
        JLabel notifyline1 = new JLabel();
        notifyline1.setText("test");
        notifyline1.setLocation(0, 0);*/
        JLabel Im = new JLabel();
        Im.setIcon(new ImageIcon(pic));
        Im.add(JP);
        	//add.label(Im);
            /*@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                //g.setColor(Co));
                //g.drawPolygon(poly);
                g.fillPolygon(poly);*/
            

        mainMap.add(JP);
        mainMap.pack();
        mainMap.setVisible(true);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	Dimension ObjMax = new Dimension(500,500);
    	pic = new BufferedImage(ObjMax.height, ObjMax.width, BufferedImage.TYPE_INT_RGB);;
    	Graphics2D image = pic.createGraphics();
    	Polygongen po = new Polygongen();
    	
    	System.out.println(po.getPolygon(0).xpoints[4]);
    	
    	for(int i=0;i<50;i++)
    	{
    	image.setColor(po.getColor(i));
        image.fillPolygon(po.getPolygon(i));
    	//pic.createGraphics(image);
        Polygongen.imageSave(pic,"E:\\Pics\\");
    	}
    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
		
		
	/*static final int AnzPoly=50; //erzeugen der Polygone
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
}*/
	
	// youtube : java draw polygon --> use ellipse, polygon, polyline video
	
	/*Polygon test = new Polygon (
			 test [] new double { 175.0, 45.0, 225.0, 45.0,
			 					265.0, 75.0, 265.0, 125.0,
			 					225.0, 155.0, 175.0, 155.0,
			 					135.0, 125.0, 135.0, 75.0}
			 );
	
}*/
	
	
	
	
