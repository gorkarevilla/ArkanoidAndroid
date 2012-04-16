package arkanoid.android.juego;

import android.arkanoid.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

public class Actor {

	protected int _x;
	protected int _y;
	
	protected int _dibujo;
	
	
	public Actor(int x,int y,int dibujo)
	{
		_x=x;
		_y=y;
		this.setDibujo(dibujo);
	}
	
	
	/**
	 * Se encarga de dibujar el bitmap sobre el lienzo
	 * @param canvas
	 */
	public void draw(Canvas canvas)
	{
	
	}
	
	
	public void setX(int x)
	{
		_x=x;
	}
	public void setY(int y)
	{
		_y=y;
	}
	
	public int getX()
	{
		return _x;
	}
	public int getY()
	{
		return _y;
	}
	
	
	public void setDibujo(int dibujo)
	{
		_dibujo=dibujo;
	}
	public int getDibujo()
	{
		return _dibujo;
	}

	
}
