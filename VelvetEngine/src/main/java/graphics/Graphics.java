package graphics;

import core.Window;

public interface Graphics
{
	boolean initGraphics();
	GraphicsContext createContext(Window window);
	boolean setContextCurrent(GraphicsContext context);
	boolean createCapibilities();
	GraphicsBuffer createBuffer(GraphicsBufferType type, int size);
	boolean setClearColor(float red, float green, float blue, float alpha);
	boolean clearBuffers();
	boolean swapBuffers(GraphicsContext context);

}
