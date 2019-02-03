
import java.io.*;



public class Main 
{

	  public static void main(String[] args) throws IOException 
	  {
		  
		  String PathOri = "C:\\Users\\Robin\\eclipse-workspace\\MonaLisaProjekt\\src\\CompanionCubeOri.png";
		  String Path;
<<<<<<< master
		  
<<<<<<< HEAD
		  //opens the original Image
		  OriImage = ImageIO.read(new File (PathOri));	
=======
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...
  
	      // Initializes fitness and Mutation objects and gives the original image to fitness
<<<<<<< master
=======
		
		  //loads the images => should go to external class for final product
//	      BufferedImage OriImage = ImageIO.read(Main.class.getResource("CompanionCubeOri.png"));
		  //BufferedImage OriImage = ImageIO.read(new File ("C:\\Users\\Robin\\git\\Meynex\\ProjectMonalisa\\EvoLisaTest\\src\\CompanionCubeOri.png"));
		  BufferedImage OriImage = ImageIO.read(new File (args[0]));
 	
	      		  
	  
	      // maybe add to Fitness class?
	      
	      //initialises the new and old fitness for comparison
	      double OldFitness = 0;
	      double NewFitness = 0;
	      
	      // gets the starting fitness
>>>>>>> refs/remotes/origin/Integrate
	      Fitness f = new Fitness(OriImage);
<<<<<<< HEAD
	      Mutation M = new Mutation(OriImage.getHeight(), OriImage.getWidth());      
=======
	      
	      f.setImage(args[0]);
	      NewFitness = f.getFitness();
	      OldFitness = NewFitness;
	      System.out.println(NewFitness);
>>>>>>> refs/remotes/origin/Integrate
=======
	      Fitness f = new Fitness(PathOri);
	      Mutation M = new Mutation();      
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...

	      // start of the do-while Loop
	      // checks the image its given on its fitness and afterwards mutates the next version
	      Path = "C:\\Users\\Robin\\eclipse-workspace\\MonaLisaProjekt\\src\\CompanionCubeComp.png";
	      f.getFitness(Path);
	      M.Mutate();

	      // end of the do-while loop
	      
	      // for testing only. usually handled by do-while loop
	      // checks the image its given on its fitness and afterwards mutates the next version
	      Path = "C:\\Users\\Robin\\eclipse-workspace\\MonaLisaProjekt\\src\\CompanionCubeComp2.png";
	      f.getFitness(Path);
	      M.Mutate();
	  }	  
}




/*
Meine Main is basicly unnötig!
in der haut main müssen nur die beiden Objekte instanziert werden (Fitness und Mutation)
Fitness baraucht den PFAD für das Original bild als argument (string)
danach kann man mir über <Fitness name>.getFitness(<Vergleichsbild pfad>) die fitness abrufen
auch hier ist der pfad des vergleichsbild im argument wieder ein string

achtung die klasse die meine sachen aufruft erwartet das " throws IOException " und damit einhergehend 
" import java.io.*; "

*/