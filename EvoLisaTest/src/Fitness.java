

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.text.DecimalFormat;


public class Fitness  
{
	private static BufferedImage OriImage;			//the original Image
	private BufferedImage CompImage;		//the Image that gets compared
	private double deltaRed=0;				//the difference in Red between the two versions of a Pixel
	private double deltaGreen=0;			//the difference in Green between the two versions of a Pixel
	private double deltaBlue=0;				//the difference in Blue between the two versions of a Pixel
	private double pixleFitness=0;			//the Fitness coefficient for the individual Pixel
	private double fitness = 0;		  		//the Fitness coefficient for the current Image
    private static double OldFitness = 0;			//the Fitness coefficient for the old best Image
    private boolean better = false;			//used to tell if the result is better
  
    Fitness(BufferedImage Ori) throws IOException
    
	  {
		  OriImage = Ori;
	  }
 //   GUI gu = new GUI();
    Polygongen po = new Polygongen(OriImage.getHeight(), OriImage.getWidth());
    DecimalFormat df = new DecimalFormat("#.000"); 
    
    
//************************Handle Fitness internally***********************************************    
    
    // compares the image to the original and calculates the difference in %
    protected boolean getFitness(String CompPath) throws IOException
    {
    	// gets the new inage to compare
    	CompImage = ImageIO.read(new File (CompPath));
    	// restets the variables
    	pixleFitness =0;
    	fitness = 0;
    	better = false; 
    	
    	//goes through each pixle
    	for(int x=0; x<OriImage.getWidth(); x++)
    	{
    		for(int y=0; y<OriImage.getHeight(); y++)
    		{
    			// gets the originals ARGB as an int and extracts the colors
    			int ori_argb = OriImage.getRGB(x, y);
//  			int ori_alpha = (ori_argb >> 24) & 0xFF;
    			int ori_red =   (ori_argb >> 16) & 0xFF;
    			int ori_green = (ori_argb >>  8) & 0xFF;
    			int ori_blue =  (ori_argb      ) & 0xFF;
  		  
    			// same with the comapritive image
    			int comp_argb = CompImage.getRGB(x, y);
//  			int comp_alpha = (comp_argb >> 24) & 0xFF;
    			int comp_red =   (comp_argb >> 16) & 0xFF;
    			int comp_green = (comp_argb >>  8) & 0xFF;
    			int comp_blue =  (comp_argb      ) & 0xFF;

    			// calculated the difference between the colors
    			deltaRed = ori_red - comp_red;
    			deltaGreen = ori_green - comp_green;
    			deltaBlue = ori_blue - comp_blue;
  		  
    			// calculates the difference for the pixle overall
    			pixleFitness = java.lang.Math.abs(deltaRed + deltaGreen + deltaBlue);
 		    		  
    			// calculates overall fitness (lower is better)
    			fitness += pixleFitness;
  		  	
    		}
    	}

		// converts it into percentile value
		fitness = 100 * (1 - fitness / (OriImage.getWidth()*OriImage.getHeight()*3*255)); 
		
		

		// checks if the result is better then the old optimum
		if(fitness > OldFitness)
		{
			// sets the new optimum
			OldFitness = fitness;
			//gives the fitness value to the GUI
			GUI.setFitnessVal(fitness);
			//gives the Polygongen the info that its a new optimum
			better = true;
//			po.isBetter();
		}
		return better;
    }	
}
