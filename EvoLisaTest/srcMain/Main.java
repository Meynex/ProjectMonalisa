
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;



public class Main 
{

	  public static void main(String[] args) throws IOException 
	  {
		  
		
		  //loads the images => should go to external class for final product
//	      BufferedImage OriImage = ImageIO.read(Main.class.getResource("CompanionCubeOri.png"));
		  BufferedImage OriImage = ImageIO.read(new File ("C:\\Users\\Robin\\git\\Meynex\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeOri.png"));

	      		  
	  
	      // maybe add to Fitness class?
	      
	      //initialises the new and old fitness for comparison
	      double OldFitness = 0;
	      double NewFitness = 0;
	      
	      // gets the starting fitness
	      Fitness f = new Fitness(OriImage);
	      
	      f.setImage("C:\\Users\\Robin\\git\\Meynex\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeComp.png");
	      NewFitness = f.getFitness();
	      OldFitness = NewFitness;
	      System.out.println(NewFitness);

	      
	      // gets the fitness for the new image => will be looped in the final version
	      
	      f.setImage("C:\\Users\\Robin\\git\\Meynex\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeComp2.png");
	      NewFitness = f.getFitness();
	      
	      System.out.println(NewFitness);
	      
	      // checks if the new fitness is better than the old and if so replaces it.
	      if(NewFitness < OldFitness)
	      {
	    	  System.out.println("improvement.");
	    	  OldFitness = NewFitness;
	      }
	      
	      
	      Mutation M = new Mutation();
	      M.Mutate();
	      

	  }

		  
}



//C:\Users\Robin\eclipse-workspace\EvoLisaTest\src\pic\CompanionCube.jpg