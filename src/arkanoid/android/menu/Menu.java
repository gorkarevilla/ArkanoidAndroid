package arkanoid.android.menu;

public class Menu {
	
	//Estado del menu
	private int estado;
	//ESTADOS DEL MENU:
	public static final int SIN_MENU=0; 
	public static final int MENU_PRINCIPAL=0; 
	public static final int MENU_OPCIONES=0; 
	
	
	
	
	
	
	
	public void setEstado(int e)
	{
		estado=e;
	}
	public int getEstado()
	{
		return estado;
	}

}
