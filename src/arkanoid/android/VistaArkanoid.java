package arkanoid.android;

import android.content.Context;
import android.graphics.*;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import arkanoid.android.juego.Arkanoid;
import arkanoid.android.juego.Actor;

import arkanoid.android.menu.Menu;


public class VistaArkanoid extends SurfaceView implements SurfaceHolder.Callback{
	
	private static int _AnchoPantalla;
	private static int _AltoPantalla;
	
	private Arkanoid _Arkanoid;
	private Menu _Menu;
	
	private HiloArkanoid _hilo;
	
	//Posicion en donde pulsamos sobre la pantalla.
	private int _x;
	private int _y;

	public VistaArkanoid(Context context) {
		super(context);
		
		//Lo añadimos para los callback de surfaceholder
		getHolder().addCallback(this);
		
		_hilo = new HiloArkanoid(getHolder(), this);
		
		_Arkanoid = new Arkanoid();
		_Menu = new Menu();

		setFocusable(true);


	}
	
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println("Boton Pulsado! "+event.getKeyCode() );
		
		return true;
		
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (_hilo.getSurfaceHolder()) 
		{
			if(event.getAction() == MotionEvent.ACTION_MOVE)
			{
				//Pulsacion sobre la pantalla
			    _x = (int) event.getX();
			    _y = (int) event.getY();
			    
			    _Arkanoid._jugador.setX(_x);
			    
			}
			return true;
		}

		
	}

	protected void onDraw(Canvas canvas) {
		
		dibujar(_Arkanoid._jugador,canvas);
		
	}
	
	
	private void dibujar(Actor actor, Canvas canvas)
	{
	    Bitmap dibujo = BitmapFactory.decodeResource(getResources(), actor.getDibujo());
	    canvas.drawColor(Color.BLACK);
	    canvas.drawBitmap(dibujo, actor.getX() - (dibujo.getWidth() / 2), actor.getY() - (dibujo.getHeight() / 2), null);
	
	}


	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		this._AltoPantalla=this.getHeight();
		this._AnchoPantalla=this.getWidth();
		System.out.println("Alto: "+this._AltoPantalla);
		System.out.println("Ancho: "+this._AnchoPantalla);
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
	    _hilo.setRunning(true);
	    _hilo.start();
		
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
	    // simply copied from sample application LunarLander:
	    // we have to tell thread to shut down & wait for it to finish, or else
	    // it might touch the Surface after we return and explode
	    boolean retry = true;
	    _hilo.setRunning(false);
	    while (retry) {
	        try {
	            _hilo.join();
	            retry = false;
	        } catch (InterruptedException e) {
	            // we will try it again and again...
	        }
	    }
		
	}


	public int getAnchoPantalla() {
		return _AnchoPantalla;
	}


	public void setAnchoPantalla(int AnchoPantalla) {
		this._AnchoPantalla = AnchoPantalla;
	}


	public int getAltoPantalla() {
		return _AltoPantalla;
	}


	public void setAltoPantalla(int AltoPantalla) {
		this._AltoPantalla = AltoPantalla;
	}
	
	
}
