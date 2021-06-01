package render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;

import util.ObjConverter;
import util.Texture;
import util.Vertex;

public class Mesh {
	private List<Vertex> vertices;
	private List<Integer> indices;
	private List<Texture> textures;
	private int VAO, VBO, EBO;
	
	public Mesh(List<Vertex> vertices, List<Integer> indices, List<Texture> textures) {
		this.vertices = vertices;
		this.indices = indices;
		this.textures = textures;
		
		this.setupMesh();
	}
	
	public void Draw(Shader shader) {
		int diffuseNr = 1;
		int specularNr = 1;
		int normalNr = 1;
		int heightNr = 1;
		for(int i=0;i< textures.size();i++) {
			glActiveTexture(GL_TEXTURE0 + i);
			String number = null;
			String name = textures.get(i).type;
			if(name == "texture_diffuse") {
				number = String.valueOf(diffuseNr);
				diffuseNr++;
			}else if(name == "texture_specular") {
				number = String.valueOf(specularNr);
				specularNr++;
			}else if(name == "texture_normal") {
				number = String.valueOf(normalNr);
				normalNr++;
			}else if(name == "texture_height") {
				number = String.valueOf(heightNr);
				heightNr++;
			}
			glUniform1i(glGetUniformLocation(shader.program, (name + number).toString()), i);
//			System.out.println(textures.get(i).id);
			glBindTexture(GL_TEXTURE_2D, textures.get(i).id);
		}
		
		// draw the mesh
		glBindVertexArray(VAO);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
//		glDrawElements(GL_TRIANGLES, indices.size(), GL_UNSIGNED_INT, 0);
		glDrawArrays(GL_TRIANGLES, 0, indices.size());
		glBindVertexArray(0);
		
		// set back to default
		glActiveTexture(GL_TEXTURE0);
	}
	
	private void setupMesh() {
		VAO = glGenVertexArrays();
		VBO = glGenBuffers();
		EBO = glGenBuffers();
		
		glBindVertexArray(VAO);
		
//		float[] allIn = ObjConverter.convertToGiantFloat(vertices);
//		glBindBuffer(GL_ARRAY_BUFFER, VBO);
//		glBufferData(GL_ARRAY_BUFFER, createBuffer(allIn), GL_STATIC_DRAW);
		
		
		float[] posicao = ObjConverter.convertVertexPositionToFloat(vertices);
		glBindBuffer(GL_ARRAY_BUFFER, 1);
		glBufferData(GL_ARRAY_BUFFER, createBuffer(posicao), GL_STATIC_DRAW);
		
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.size() * Integer.BYTES, GL_STATIC_DRAW);
		
		// vertices
		glVertexAttribPointer(1, 3, GL_FLOAT, false, 3 * Float.BYTES, 0);
		glEnableVertexAttribArray(1);
		
		float[] normal = ObjConverter.convertVertexNormalToFloat(vertices);
		glBindBuffer(GL_ARRAY_BUFFER, 2);
		glBufferData(GL_ARRAY_BUFFER, createBuffer(normal), GL_STATIC_DRAW);
		
		glVertexAttribPointer(2, 3, GL_FLOAT, false,  3 * Float.BYTES,0);
		glEnableVertexAttribArray(2);
		
		// normals
//		glVertexAttribPointer(1, 3, GL_FLOAT, false,  3 * Float.BYTES,3 * Float.BYTES);
//		glEnableVertexAttribArray(1);
		
		float[] texcoords = ObjConverter.convertVertexTexCoordsToFloat(vertices);
		glBindBuffer(GL_ARRAY_BUFFER, 3);
		glBufferData(GL_ARRAY_BUFFER, createBuffer(texcoords), GL_STATIC_DRAW);
		glVertexAttribPointer(3, 2, GL_FLOAT, false,  2 * Float.BYTES, 0);
		glEnableVertexAttribArray(3);
		
		// tex coordinates
//		glVertexAttribPointer(2, 2, GL_FLOAT, false,  2 * Float.BYTES, 6 * Float.BYTES);
//		glEnableVertexAttribArray(2);
		
		
		float[] tangents = ObjConverter.convertVertexTangentToFloat(vertices);
		glBindBuffer(GL_ARRAY_BUFFER, 4);
		glBufferData(GL_ARRAY_BUFFER, createBuffer(tangents), GL_STATIC_DRAW);
		glVertexAttribPointer(4, 2, GL_FLOAT, false,  3 * Float.BYTES, 0);
		glEnableVertexAttribArray(4);
		
		// tangents
//		glVertexAttribPointer(3, 3, GL_FLOAT, false, 3 * Float.BYTES, 8 * Float.BYTES);
//		glEnableVertexAttribArray(3);
		
		
		float[] bitangents = ObjConverter.convertVertexBitangentToFloat(vertices);
		glBindBuffer(GL_ARRAY_BUFFER, 5);
		glBufferData(GL_ARRAY_BUFFER, createBuffer(bitangents), GL_STATIC_DRAW);
		glVertexAttribPointer(5, 3, GL_FLOAT, false, 3 * Float.BYTES, 0);
		glEnableVertexAttribArray(5);
		
		// bitangents
//		glVertexAttribPointer(4, 3, GL_FLOAT, false, 3 * Float.BYTES, 11 * Float.BYTES);
//		glEnableVertexAttribArray(4);
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		
		glBindVertexArray(0);
	}
	
	private FloatBuffer createBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	private IntBuffer createBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
}
