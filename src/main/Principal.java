package main;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;

import java.io.File;

import org.joml.Vector3f;
import org.lwjgl.assimp.AIPropertyStore;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.Assimp;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLUtil;

import io.Window;
import render.Camera;
import render.Model;
import render.Shader;
import render.Transform;

public class Principal implements Runnable{
	private Thread thread;
	private boolean rodando = false;
	private Window window = null;
	private Model model = null;
	private Camera camera;
	private Transform transform;
	
	public void start() {
		thread = new Thread(this, "Jogo");
		rodando = true;
		thread.start();
	}
	
	private void init() {
		if (!glfwInit()) {
			return;
		}

		window = new Window();
		window.setFullscreen(false);
		window.createWindow("game");

		GL.createCapabilities();
		
		glGetError();

		glEnable(GL_BLEND);
		glEnable(GL_DEPTH_TEST);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		camera = new Camera();
		transform = new Transform();
		
		camera.setPerspective((float)Math.toRadians(90), (float)window.getWidth()/ (float)window.getHeight() , 0.01f, 100.0f);
		camera.setPosicao(new Vector3f(0.1f, 1.0f, 3.0f));
		Shader.loadAllShaders();
//		Shader.ASSIMP_LOADER.bind();
	
		model = new Model("./cyborg/cyborg.obj");
		
//		Shader.ASSIMP_LOADER.setUniform("texture_diffuse1", 0);
	}
	
	private void update() {
		glfwPollEvents();
		if (window.getInput().isKeyReleased(GLFW_KEY_ESCAPE)) {
			System.exit(1);
		}
		if(window.getInput().isKeyPressed(GLFW_KEY_UP)) {
//			transform.setEscala(new Vector3f(2.0f, 0.5f, 3.0f));
		}
		window.update();
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0.05f, 0.05f, 0.05f, 1.0f);
		Shader.ASSIMP_LOADER.bind();
		Shader.ASSIMP_LOADER.setCamera(camera);
		Shader.ASSIMP_LOADER.setTransformacao(transform);
		model.Draw(Shader.ASSIMP_LOADER);
//		Shader.ASSIMP_LOADER.detach();
		window.swapBuffers();
	}
	
	@Override
	public void run() {
		init();
		while (rodando) {
			update();
			render();
		}
		
	}
	
	public static void main(String[] args) {
		new Principal().start();
	}

}
