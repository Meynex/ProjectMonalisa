
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
import java.io.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Fitness 
{
	BufferedImage OriImage;
	BufferedImage CompImage;
    double fitness = 0;		  
	double deltaRed=0;
    double deltaGreen=0;
    double deltaBlue=0;
    double pixleFitness=0;
    double newFitness=0;
    int[][] ColorsOri;
    
    Fitness(BufferedImage Ori)
	  {
		  OriImage = Ori;
//		  ColorsOri = convert(OriImage);
	  }
	  
	protected void setImage(String CompPath) throws IOException
	{
		CompImage = ImageIO.read(new File (CompPath));
		
	}

    protected double getFitness()
    {
    
    //goes through each pixle
    for(int x=0; x<OriImage.getWidth(); x++)
    {
  	  for(int y=0; y<OriImage.getHeight(); y++)
  	  {
  		  // gets the originals ARGB as an int and extracts the colors
  		  int ori_argb = OriImage.getRGB(x, y);
//  		  int ori_alpha = (ori_argb >> 24) & 0xFF;
  		  int ori_red =   (ori_argb >> 16) & 0xFF;
  		  int ori_green = (ori_argb >>  8) & 0xFF;
  		  int ori_blue =  (ori_argb      ) & 0xFF;
  		  
  		  // same with the comapritive image
  		  int comp_argb = CompImage.getRGB(x, y);
//  		  int comp_alpha = (comp_argb >> 24) & 0xFF;
  		  int comp_red =   (comp_argb >> 16) & 0xFF;
  		  int comp_green = (comp_argb >>  8) & 0xFF;
  		  int comp_blue =  (comp_argb      ) & 0xFF;

  		  // calculated the difference between the colors
  		  deltaRed = ori_red - comp_red;
  		  deltaGreen = ori_green - comp_green;
  		  deltaBlue = ori_blue - comp_blue;
  		  
  		  // calculates the difference for the pixle overall
  		  pixleFitness = Math.sqrt(deltaRed * deltaRed + deltaGreen * deltaGreen + deltaBlue * deltaBlue);
  		  
  		  // calculates overall fitness (lower is better)
  		  fitness += pixleFitness;

  	  }
    }
    return fitness;
    
    }

	
/*	
	protected double getFitness()
	{
		int[][] ColorsCompare = convert(CompImage);
		
		for(int x=0; x<OriImage.getWidth(); x++)
		{
			for(int y=0; y<OriImage.getHeight(); y++)
			{
				System.out.println(ColorsOri[x][y]);
				System.out.println(ColorsCompare[x][y]);
				
			}
		}
		
		return fitness;
	}

	
	   private static int[][] convert(BufferedImage image) {

		      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		      final int width = image.getWidth();
		      final int height = image.getHeight();
		      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

		      int[][] result = new int[height][width];
		      if (hasAlphaChannel) {
		         final int pixelLength = 4;
		         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
		            int argb = 0;
		            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
		            argb += ((int) pixels[pixel + 1] & 0xff); // blue
		            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
		            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
		            result[row][col] = argb;
		            col++;
		            if (col == width) {
		               col = 0;
		               row++;
		            }
		         }
		      }
		      return result;
	   }   
*/	
	
}
