package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int height;
	private int width;
	
	public Rectangle() 
	{
			this.upperLeftPoint = new Point (height,height);
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
	
	
	
	
	
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
