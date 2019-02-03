import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
// Author: Jan Schulze
/**
 * @author Jan
 *
 */
public class Image{

        
		public Image() {
				// TODO Auto-generated constructor stub
        	String AbsPath = null;
        	String Name = "";
        	
			}

		public BufferedImage getBufImg(String AbsPath){
        try
        {
            BufferedImage picture = ImageIO.read(new File(AbsPath));
        
            return picture;
        }
        catch (IOException e)
        {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
        return null;
        }
		
		public static void DisplayImage(String AbsPath) throws IOException
	    {
	        BufferedImage img=ImageIO.read(new File(AbsPath));
	        ImageIcon icon=new ImageIcon(img);
	        JFrame frame=new JFrame();
	        frame.getContentPane().setLayout(new FlowLayout());
	        frame.setSize(200,300);
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.getContentPane().add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
		public static void DisplayImage(String AbsPath, JLabel lbl) throws IOException
	    {
	        BufferedImage img=ImageIO.read(new File(AbsPath));
	        ImageIcon icon=new ImageIcon(img);
	        lbl.setIcon(icon);
	    }
		
		public static void ResizeAbs(String inputImagePath,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException {
	        // reads input image
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }
	 
	    /**
	     * Resizes an image by a percentage of original size (proportional).
	     * @param inputImagePath Path of the original image
	     * @param outputImagePath Path to save the resized image
	     * @param percent a double number specifies percentage of the output image
	     * over the input image.
	     * @throws IOException
	     */
	    public static void ResizePer(String inputImagePath,
	            String outputImagePath, double percent) throws IOException {
	        File inputFile = new File(inputImagePath);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	        int scaledWidth = (int) (inputImage.getWidth() * percent);
	        int scaledHeight = (int) (inputImage.getHeight() * percent);
	        ResizeAbs(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	    }
	    public static ImageIcon ResizeImg(String AbsPath, JPanel pan) {
	    	
	    	BufferedImage img = null;
	    	try {
	    	    img = ImageIO.read(new File(AbsPath));
	    	} catch (IOException e) {
	    	    e.printStackTrace();
	    	}
	    	
	    	java.awt.Image dimg = img.getScaledInstance(pan.getWidth(), pan.getHeight(),
	    	        java.awt.Image.SCALE_SMOOTH);
	    	
	    	ImageIcon imageIcon = new ImageIcon(dimg);
	    	return imageIcon;
	    }
    }