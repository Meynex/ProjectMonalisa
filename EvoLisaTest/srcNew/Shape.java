import java.awt.Color;
import java.awt.Polygon;
public class Shape
{
	public Color color;
	public Polygon polygon;
	public Shape(Color color, Polygon polygon)
	{
		this.color = color;
		this.polygon = polygon;
	}
	public Shape(Shape shape)
	{
		this.color = shape.color;
		this.polygon = shape.polygon;
	}
	public void print()
	{
		System.out.println("("+polygon.xpoints[0]+","+polygon.ypoints[0]+")");
	}
	public String toString()
	{
		return polygon.xpoints[0]+","+polygon.ypoints[0];	
	}
}