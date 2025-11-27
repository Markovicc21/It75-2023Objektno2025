package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

	
	private int radius;
	private Point center;
	
	public Circle() 
	{
		
	}
	public Circle (int radius, Point center) 
	{
		this.radius = radius;
		this.center = center;
		
	}
	
	public Circle(int radius, Point center, boolean selected) 
	{
		this(radius,center);
		this.selected = selected;
	}
	
	public Circle(int radius,Point center, boolean selected,Color color) 
	{
		this(radius,center,selected);
		setColor(color);
	}
	
	public Circle(int radius, Point center, boolean selected,Color color,Color innerColor ) 
	{
		this(radius,center,selected,color);
		setInnerColor(innerColor);
	}
	
	public double area() 
	{
		return this.radius*this.radius*Math.PI;

	}
	
	public double circumference() 
	{
		return 2*this.radius*Math.PI;
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
		this.radius = radius;
	}
	
	
	 public Point getCenter() 
	 {
		 return this.center;
	 }
	 
	 public void  setCenter(Point center)
	 {
		  this.center = center;
	 }
	 
	 
	 @Override
	 public String toString() 
	 {
		 return ("Radius : " + this.radius + ", Center : " + this.center );
	 }
	 
	 @Override
	 public boolean equals(Object obj) 
	 {
		 if(obj instanceof Circle) 
		 {
			 Circle c = (Circle) obj;
			 if(this.getCenter().equals(c.getCenter()) && this.getRadius() == c.getRadius()) 
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
		this.center.moveTo(x,y);
	}

	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		this.center.moveBy(ByX, ByY);
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub	
		if(obj instanceof Circle) 
		{
			Circle o = (Circle)obj;
			return (int) (this.area() - o.area());
		}
		
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, radius*2, radius*2);
		
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - radius + 1, center.getY() - radius + 1, radius*2 - 2, radius*2 - 2 );
		
		if(getSelected()) 
		{
			g.setColor(Color.GREEN);
			g.drawRect(center.getX() - 2 ,center.getY() - 2 ,4,4);
			g.drawRect(center.getX() - radius - 2 , center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2,4,4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			
		}
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return this.getCenter().distance(x,y) <= this.radius;
	}

	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return this.getCenter().distance(point.getX(),point.getY()) <= this.radius;
	}

}
