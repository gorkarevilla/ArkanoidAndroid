package arkanoid.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class ActivityArkanoid extends Activity {

	//Vista del Arkanoid
	private VistaArkanoid _vista;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		// Quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // Ponemos pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		_vista = new VistaArkanoid(this);

		setContentView(_vista);

	}
}