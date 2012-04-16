package arkanoid.android;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/*
 * Esta clase nos permitira crear un hilo que se encargue de dibujar. De esta forma
 * primero prepara el dibujado y luego lo muestra de forma paralela al hilo principal.
 */
public class HiloArkanoid extends Thread {
    private SurfaceHolder _surfaceHolder;
    private VistaArkanoid _vista;
    //Controla si el hilo esta funcionando.
    private boolean _run = false;
 
    public HiloArkanoid(SurfaceHolder surfaceHolder, VistaArkanoid vista) {
        _surfaceHolder = surfaceHolder;
        _vista = vista;
    }
 
    //Setter del run
    public void setRunning(boolean run) {
        _run = run;
    }
 
    @Override
    public void run() {
        Canvas c;
        while (_run) {
            c = null;
            try {
                c = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {
                    _vista.onDraw(c);
                }
            } finally {
                // do this in a finally so that if an exception is thrown
                // during the above, we don't leave the Surface in an
                // inconsistent state
                if (c != null) {
                    _surfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
    }
    
    public SurfaceHolder getSurfaceHolder() {
        return _surfaceHolder;
    }
    
    
}
