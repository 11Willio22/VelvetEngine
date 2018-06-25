import core.Application;
import core.Window;
import graphics.Graphics;
import graphics.GraphicsAPI;

public class Main
{
	public static void main(String[] args)
	{
		Application app = Application.createApplication("VelvetEngine", GraphicsAPI.GRAPHICS_OPENGL3);
		app.createWindow("VelvetEngine", 640, 480, 0, 0, Window.CENTERED);
		
		Graphics gfx = app.getGraphics();
		gfx.setClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		
		while(true)
		{
			gfx.clearBuffers();
			app.update();
		}
	}

}
