package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;

	public Line() {
		
	}
	
	public Line (Point startPoint, Point endPoint) {
		
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) 
	{
		this(startPoint,endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint,Point endPoint, boolean selected,Color color) {
		this(startPoint,endPoint,selected);
		setColor(color);
	}
	 public double length() {
		 return this.endPoint.distance(this.startPoint.getX(), this.endPoint.getY());
	 }
	 
	 public Point getStartpoint() {
		 return this.startPoint;
	 }
	 
	 public void setStartpoint (Point startPoint) 
	 {
		 	this.startPoint = startPoint;
	 }
	 
	 public Point getEndpoint () 
	 {
		 return this.endPoint;
	 }
	 
	 
	 public void setEndpoint (Point endPoint) 
	 {
		 this.endPoint = endPoint;
	 }
	 
	 @Override
	 public String toString() 
	 {
		 return this.startPoint + "-->" + this.endPoint;
	 }
	 
	 @Override
	 public boolean equals (Object obj) 
	 {
		 if(obj instanceof Line) 
		 {
			 Line l  = (Line)obj;
			 if (this.getStartpoint().equals(l.getStartpoint()) && this.getEndpoint().equals(l.getEndpoint())) 
			 {
				 return true;
			 }else 
			 {
				 return false;
			 }
		 }
		 else 
		 {
			 return false;
		 }
		 
	 }
	 
	 public boolean contains (int x, int y) 
	 {
		 double d = this.getStartpoint().distance(x, y) + this.getEndpoint().distance(x, y);
		 return d - this.length() <= 2;
	 }
	 
	 public boolean contains(Point point) 
	 {
		 double d = this.getStartpoint().distance(point.getX(),point.getY()) + this.getEndpoint().distance(point.getX(), point.getY());
		 return d - this.length() <= 2;
	 }

	 @Override
	 public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.getStartpoint().moveTo(x,y);
		this.getEndpoint().moveTo(x,y);
	 }

	 @Override
	 public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		this.getStartpoint().moveBy(byX, byY);
		this.getEndpoint().moveBy(byX, byY);
	 }

	 @Override
	 public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Line) 
		{
			Line l =(Line)obj;
			return (int)(this.length() - l.length());
		}
		return 0;
	 }

	 @Override
	 public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		
		if(getSelected()) 
		{
			g.setColor(Color.GREEN);
			g.drawRect(this.startPoint.getX() - 3 , this.startPoint.getY() - 3,6,6);
			g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3,6,6);
		}
		
	 }
	 
	 
	 
	
}