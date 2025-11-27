package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Doughnut extends Shape {
	
	private int radius;
	private int innerRadius;
	private Point center;
	
	
	public Doughnut() 
	{
		
	}
	
	
	public Doughnut(int radius,int innerRadius,Point center) 
	{
		this.radius = radius;
		this.innerRadius = innerRadius;
		this.center = center;
	}
	
	
	public Doughnut (int radius, int innerRadius,Point center, boolean selected) 
	{
		this(radius,innerRadius,center);
		this.selected = selected;
	}

	
	public Doughnut (int radius, int innerRadius, Point center, boolean selected, Color color) 
	{
		this(radius,innerRadius,center,selected);
		setColor(color);
	}
	
	
	public Doughnut (int radius, int innerRadius, Point center, boolean selected, Color color, Color innerColor) 
	{
		this(radius,innerRadius,center,selected,color);
		setInnerColor(innerColor);
	}
	
	
	public int getRadius() 
	{
		return this.radius;
	}
	
	
	public void setRadius(int radius) throws Exception 
	{
		if(radius <= 0) 
		{
			throw new Exception("Radius mora biti veci od 0");

		}
		if(innerRadius >= radius) 
		{
			throw new Exception("Unutrasnji radius mora biti manji od spoljasnjeg");
		}
		this.radius = radius;
	}
	
	
	public int getInnerRadius() 
	{
		return this.innerRadius;
	}
	
	
	public void setInnerRadius(int innerRadius) throws Exception
	{
		if(innerRadius <= 0)
		{
			throw new Exception("Unutrasnji radius mora biti veci od 0");
			
		}
		
		if(innerRadius >= radius) 
		{
			throw new Exception("Unutrasnji radius ne sme biti veci od spoljasnjeg");
		}
		this.innerRadius = innerRadius;
	}
	
	
	public Point getCenter() 
	{
		return this.center;
	}
	
	
	public void setCenter(Point center) 
	{
		this.center = center;
	}
	
	
	public double area() 
	{
		return Math.PI * (radius * radius - innerRadius * innerRadius);
	}
	
	
	@Override
	public String toString() 
	{
		return ("Radius : " + this.radius + " , Inner Radius : " + this.innerRadius + ", Centar : " + this.center);
	}
	
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Doughnut) 
		{
			Doughnut d = (Doughnut) obj;
			
			if(this.getCenter().equals(d.getCenter()) && this.getRadius() == d.getRadius() && this.getInnerRadius() == d.getInnerRadius()) 
			{
				return true;
			}
			else 
			{
				return false;
			}
			
		}
		return false;
	}
	
	
	
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.center.moveTo(x, y);
	}

	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		this.center.moveBy(ByX, ByY);
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Doughnut) 
		{
			Doughnut dd = (Doughnut) obj;
			return (int) (this.area() - dd.area());
		}
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
		
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - radius + 1, center.getY() - radius + 1, radius * 2 - 2, radius * 2 - 2);
		
		g.setColor(Color.WHITE);  
		g.fillOval(center.getX() - innerRadius, center.getY() - innerRadius, innerRadius * 2, innerRadius * 2);
		
		if(getSelected()) 
		{
			g.setColor(Color.GREEN);
			
			 g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			 g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			 g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			 g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			 g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		double d = center.distance(x, y);
	    return d <= radius && d >= innerRadius;
	}

	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		 double d = center.distance(point.getX(), point.getY());
		 return d <= radius && d >= innerRadius;
	}
	
	
}
