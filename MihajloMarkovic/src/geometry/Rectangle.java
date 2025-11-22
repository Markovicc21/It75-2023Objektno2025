package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int height;
	private int width;
	
	public Rectangle () 
	{
		
	}
	
	public Rectangle(Point upperLeftPoint,int height,int width) 
	{
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeftPoint,int height,int width, boolean selected) 
	{
		this(upperLeftPoint,height,width);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint,int height,int width, boolean selected, Color color) 
	{
		this(upperLeftPoint,height,width,selected);
		setColor(color);
	}
	
	public Rectangle (Point upperLeftPoint,int height,int width, boolean selected, Color color,Color innerColor) 
	{
		this(upperLeftPoint,height,width,selected,color);
		setInnerColor(innerColor);
	}
	
	
	public double area() 
	{
		return (this.height * this.width);
	}
	
	public double circumference() 
	{
		return 2*(this.height + this.width);
	}
	
	public Point getUpperLeftPoint() 
	{
		return this.upperLeftPoint;
	}
	
	public void setUpperLeftPoint(Point upperLeftPoint)
	{
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public int getHeight() 
	{
		return this.height;
	}
	
	public void setHeight(int height) 
	{
		this.height = height;
	}
	
	public int getWidth() 
	{
		return this.width;
	}
	
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	@Override
	public String toString() 
	{
		return ("Upper Left Point: " + this.upperLeftPoint + ", Width: " + this.width + ", Height: " + this.height);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Rectangle) 
		{
			Rectangle r = (Rectangle)obj;
			return (r.getUpperLeftPoint().equals(this.upperLeftPoint) && r.height == this.height && r.width == this.width);
		}
		else 
		{
			return false;
		}
		
	}
		
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.upperLeftPoint.moveTo(x,y);
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		this.upperLeftPoint.moveBy(x,y);
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Rectangle) 
		{
			Rectangle r = (Rectangle)obj;
			return (int) (this.area() - r.area());
		}
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawRect(this.upperLeftPoint.getX(),this.upperLeftPoint.getY(),this.width,this.height);
		
		this.fill(g);
		
		if(getSelected()) 
		{
			g.setColor(Color.GREEN);
			g.drawRect(upperLeftPoint.getX() - 3 , upperLeftPoint.getY() - 3,6,6);
			g.drawRect(upperLeftPoint.getX() + getWidth() -3,upperLeftPoint.getY() -3 ,6,6);
			g.drawRect(upperLeftPoint.getX() - 3,upperLeftPoint.getY() + getHeight() -3,6,6);
			g.drawRect(upperLeftPoint.getX() + getWidth() -3 , upperLeftPoint.getY() + getHeight() - 3 ,6,6);
		}
	}
	
	public void fill(Graphics g) 
	{
		g.setColor(innerColor);
		g.fillRect(this.upperLeftPoint.getX() + 1, this.upperLeftPoint.getY() + 1, width - 1, width -1);
	}
	
	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		if (x > this.upperLeftPoint.getX() && x < this.upperLeftPoint.getX() + width && y > this.upperLeftPoint.getY() && y < this.upperLeftPoint.getY() + height ) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	
	}

	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		if (point.getX() > this.upperLeftPoint.getX() && point.getX() < this.upperLeftPoint.getX() + width && point.getY() > this.upperLeftPoint.getY() && point.getY() < this.upperLeftPoint.getY() + height ) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
}
