

import java.util.Random;

public class Mutation {


// insert array of colored Polygons here
	
	int corners = 6;
	int choiceA = 0;
	int choiceB = 0;
	int plumi = 0;
	int change = 0;
	Random  Rand = new Random();

	// or a return new Polygon
	protected void Mutate()
	{
	
	choiceA = Rand.nextInt(50);
	choiceB = Rand.nextInt(3+2*corners)+1;
	plumi = Rand.nextInt(2)+1;
	change = Rand.nextInt(10)+1;
	System.out.print("Polygon " + (choiceA+1) + "s ");
	
	
//	 Poly[choiceA]'s polygon gets selected
// 	 posion change needs check to make sure it stays within highs/width of picture	
	  if(choiceB == 1)
	  {
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
	
}
