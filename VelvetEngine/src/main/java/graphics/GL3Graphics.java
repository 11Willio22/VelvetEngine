package graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GLCapabilities;

import core.Window;

public class GL3Graphics implements Graphics
{
	@Override
	public boolean initGraphics()
	{
		boolean init = GLFW.glfwInit();
		if(!init)
		{
			//TODO: add error handling
			return false;
		}
		
		return true;
	}
	
	@Override
	public GraphicsContext createContext(Window window) {
		GraphicsContext context = new GraphicsContext(window.getWindowLong());
		return context;
	}
	
	@Override
	public boolean setContextCurrent(GraphicsContext context) {
		GLFW.glfwMakeContextCurrent(context.getContext());
		return true;
	}

	@Override
	public boolean createCapibilities() {
		GLCapabilities capibilities = GL.createCapabilities();
		return capibilities != null;
	}
	
	@Override
	public GraphicsBuffer createBuffer(GraphicsBufferType type, int size)
	{
		int buffer = GL15.glGenBuffers();
		return new GraphicsBuffer(buffer, size, type);
	}

	@Override
	public boolean setClearColor(float red, float green, float blue, float alpha) {
		GL11.glClearColor(red, green, blue, alpha);
		return true;
	}

	@Override
	public boolean clearBuffers() {
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_COLOR_BUFFER_BIT);
		return true;
	}

	@Override
	public boolean swapBuffers(GraphicsContext context) {
		GLFW.glfwSwapBuffers(context.getContext());
		return true;
	}

}
