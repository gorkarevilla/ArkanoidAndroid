package arkanoid.android.juego;

import android.arkanoid.R;

public class Barra extends Actor{

	private static int _dibujo = R.drawable.barrasinsombra;

	private static int _y = 720;
	
	public Barra(int x) {
		super(x, _y, _dibujo);
	
	}
	

}
