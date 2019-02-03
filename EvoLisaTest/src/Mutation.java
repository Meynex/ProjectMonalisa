

import java.util.Random;
import java.awt.Polygon;
import java.awt.Color;


public class Mutation {


	
	private int corners = 5;					//Number of corners in the polygon
	private int choiceA = 0;					//rng choice of which polygon
	private int choiceB = 0;					//rng choice of the omponent
	private int plumi = 0;						//rng choice of +/-
	private int change = 0;						//rng generate value of change
	private int var;							//coefficeint of the change range
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
	
	
	Mutation(int x, int y)
	{
		hight = x;
		width = y;
	}
	
	
	//method to mutate a polygon
	protected void Mutate()
	{
	
		
		choiceA = Rand.nextInt(50);
		choiceB = Rand.nextInt(3+2*corners)+1;
		plumi = Rand.nextInt(2)+1;
		change = Rand.nextInt(10)+1;
		System.out.print("Polygon " + (choiceA+1) + "s ");
	

		// gets the polygon Nr <choiceA>
		poly = Polygongen.getPolygon(choiceA);
		col = Polygongen.getColor(choiceA);
		
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
	  		if(plumi == 1)
	  		{
	  			Blue += change;
	  			// checks if out of bounds and sets to bound
	  			if(Blue > 255)
	  			{
	  				Blue = 255;
	  			}
	  		}
	  		else
	  		{
	  			Blue -= change;
	  			// checks if out of bounds and sets to bound
	  			if(Blue < 0)
	  			{
	  				Blue = 0;
	  			}
	  		}
		}
		else if(choiceB % 2 == 0)
		{
	  		if(plumi == 1)
	  		{
	  			// -3 to get rid of the rgb results and /2 to get the set of X|Y coordinates in question
//	  			System.out.println("X " + (choiceB-3)/2 + "changed by +" + change);
	  			xpoints[((choiceB-3)/2)] += change;
	  	
	  			// checks if out of bounds and sets to bound
	  			if(xpoints[((choiceB-3)/2)] > hight)
				{
					xpoints[((choiceB-3)/2)] = hight;
				}
	  		}
	  		else
	  		{
	  			// -3 to get rid of the rgb results and /2 to get the set of X|Y coordinates in question
//	  			System.out.println("X " + (choiceB-3)/2 + "changed by -" + change);
	  			xpoints[((choiceB-3)/2)] -= change;
	  			
	  			// checks if out of bounds and sets to bound
	  			if(xpoints[((choiceB-3)/2)] < 0)
				{
					xpoints[((choiceB-3)/2)] = 0;
				}
	  			
	  		}
		}
		else if(choiceB % 2 != 0)
		{
	  		if(plumi == 1)
	  		{
	  			// -3 to get rid of the rgb results and /2-1 to get the set of X|Y coordinates in question
//	  			System.out.println("Y " + ((choiceB-3)/2-1) + "changed by +" + change);
	  			ypoints[(choiceB-3)/2-1] += change;
	  			
	  			// checks if out of bounds and sets to bound
	  			if(ypoints[(choiceB-3)/2-1] > width)
	  			{
	  				ypoints[(choiceB-3)/2-1] = width;
	  			}
	  		}
	  		else
	  		{
	  			// -3 to get rid of the rgb results and /2-1 to get the set of X|Y coordinates in question
//	  			System.out.println("Y " + ((choiceB-3)/2-1) + "changed by -" + change);
	  			ypoints[(choiceB-3)/2-1] -= change;

	  			// checks if out of bounds and sets to bound
	  			if(ypoints[(choiceB-3)/2-1]<0)
	  			{
	  				ypoints[(choiceB-3)/2-1] = 0;
	  			}
	  		}
	  		
	  		// since neither polygon nor color can change their components we generate new ones.
	  		Polygon newPoly = new Polygon(xpoints, ypoints, 5);
	  		Color newCol = new Color(Red, Green, Blue);
	  		
	  		// gives the data back to the Polygongen class
	  		Polygongen.setPolygon(choiceA, newPoly);
	  		Polygongen.setColor(choiceA, newCol);
		}
	}	
}
