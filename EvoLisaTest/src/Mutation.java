

import java.util.Random;

public class Mutation {


// insert array of colored Polygons here
	
<<<<<<< master
	private int corners = 5;					//Number of corners in the polygon
	private int choiceA = 0;					//rng choice of which polygon
	private int choiceB = 0;					//rng choice of the omponent
	private int plumi = 0;						//rng choice of +/-
	private int change = 0;						//rng generate value of change
	private Random  Rand = new Random();		//generates a new start random 
	private Polygon poly = new Polygon();		//generates new polygon 
	private Color col = new Color(0, 0, 0);		//generates new color 
	private int Red = 0;						//color component red
	private int Green = 0;						//color component green
	private int Blue = 0;						//color component blue
	private int[] xpoints;						//polygon component xpoints
	private int[] ypoints;						//polygon component ypoints
	private int hight;							//hight of the original image
	private int width;							//width of the original image
	Polygongen po = new Polygongen();
	
	Mutation(int x, int y)
	{
		hight = x;
		width = y;
	}
	
	
	//method to mutate a polygon
	public void Mutate()
=======
	int corners = 6;
	int choiceA = 0;
	int choiceB = 0;
	int plumi = 0;
	int change = 0;
	Random  Rand = new Random();

	// or a return new Polygon
	protected void Mutate()
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...
	{
	
<<<<<<< master
		
		choiceA = Rand.nextInt(50);
		choiceB = Rand.nextInt(3+2*corners)+1;
		plumi = Rand.nextInt(2)+1;
		change = Rand.nextInt(100)+1;
		System.out.print("Polygon " + (choiceA+1) + "s ");
=======
	choiceA = Rand.nextInt(50);
	choiceB = Rand.nextInt(3+2*corners)+1;
	plumi = Rand.nextInt(2)+1;
	change = Rand.nextInt(10)+1;
	System.out.print("Polygon " + (choiceA+1) + "s ");
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...
	
<<<<<<< master

		// gets the polygon Nr <choiceA>
		poly = po.getPolygon(choiceA);
		col = po.getColor(choiceA);
		
		// splits the color into components
		Red = col.getRed();
		Green = col.getGreen();
		Blue = col.getBlue();
		
		// gets the polygons x[] and y[]
		xpoints = poly.xpoints;
		ypoints = poly.ypoints;
		
		
//		Poly[choiceA]'s polygon gets selected
		if(choiceB == 1)
		{
			if(plumi == 1)
			{
	  			Red += change;
	  			// checks if out of bounds and sets to bound
	  			if(Red > 255)
	  			{
	  				Red = 255;
	  			}
	  		}
	  		else
	  		{
	  			Red -= change;
	  			// checks if out of bounds and sets to bound
	  			if(Red < 0)
	  			{
	  				Red = 0;
	  			}
	  		}
		}
		else if(choiceB == 2)
		{
			if(plumi == 1)
			{
	  			Green += change;
	  			// checks if out of bounds and sets to bound
	  			if(Green > 255)
	  			{
	  				Green = 255;
	  			}
			}
	  		else
	  		{
	  			Green -= change;
	  			// checks if out of bounds and sets to bound
	  			if(Green < 0)
	  			{
	  				Green = 0;
	  			}
	  		}
		}
		else if(choiceB == 3)
		{
=======
	
//	 Poly[choiceA]'s polygon gets selected
// 	 posion change needs check to make sure it stays within highs/width of picture	
	  if(choiceB == 1)
	  {
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...
	  		if(plumi == 1)
	  		{
//	  			Red += change;
	  			System.out.println("Red changed by +" + change);
	  		}
	  		else
	  		{
//	  			Red -= change;
	  			System.out.println("Red changed by -" + change);
	  		}
	  }
	  else if(choiceB == 2)
	  {
	  		if(plumi == 1)
	  		{
//	  			Green += change;
	  			System.out.println("Green changed by +" + change);
	  		}
	  		else
	  		{
//	  			Green -= change;
	  			System.out.println("Green changed by -" + change);
	  		}
	  }
	  else if(choiceB == 3)
	  {
	  		if(plumi == 1)
	  		{
//	  			Blue += change;
	  			System.out.println("Blue changed by +" + change);
	  		}
	  		else
	  		{
//	  			Blue -= change;
	  			System.out.println("Blue changed by -" + change);
	  		}
<<<<<<< master
	  		
	  		// since neither polygon nor color can change their components we generate new ones.
	  		Polygon newPoly = new Polygon(xpoints, ypoints, 5);
	  		Color newCol = new Color(Red, Green, Blue, 25);
	  		
	  		// gives the data back to the Polygongen class
	  		po.setPolygon( newPoly, choiceA);
	  		po.setColor( newCol, choiceA);
		}
	}	
=======
	  }
	  else if(choiceB % 2 == 0)
	  {
	  		if(plumi == 1)
	  		{
//	  			X[(choiceB-3)/2] += change;		// -3 to get rid of the rgb results and /2 to get the set of X|Y coordinates in question
	  			System.out.println("X " + (choiceB-3)/2 + "changed by +" + change);
	  		}
	  		else
	  		{
//	  			X[(choiceB-3)/2] -= change;	// -3 to get rid of the rgb results and /2 to get the set of X|Y coordinates in question
	  			System.out.println("X " + (choiceB-3)/2 + "changed by -" + change);
	  		}
	  }
	  else if(choiceB % 2 != 0)
	  {
	  		if(plumi == 1)
	  		{
//	  			Y[(choiceB-3)/2-1] += change;		// -3 to get rid of the rgb results and /2-1 to get the set of X|Y coordinates in question
	  			System.out.println("Y " + ((choiceB-3)/2-1) + "changed by +" + change);
	  		}
	  		else
	  		{
//	  			Y[(choiceB-3)/2-1] -= change;	// -3 to get rid of the rgb results and /2-1 to get the set of X|Y coordinates in question
	  			System.out.println("Y " + ((choiceB-3)/2-1) + "changed by -" + change);
	  		}
	  }
	  
	  
	 
	
	}
	
>>>>>>> 7941a26 since it didnt work from my lapi here are the new files...
}
