package util;

import java.util.ArrayList;
import java.util.List;

public class ObjConverter {
	
	public static int[] convertToSimpleIndices(List<Integer> indices) {
		int[] simpleIndices = new int[indices.size()];
		for(int i=0;i<indices.size();i++) {
			simpleIndices[i] = indices.get(i);
		}
		return simpleIndices;
	}
	
	public static float[] convertToGiantFloat(List<Vertex> vertices) {
		float[] allIn = new float[vertices.size() * 14];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			//position
			allIn[j++] = vertices.get(i).Position.x;
			allIn[j++] = vertices.get(i).Position.y;
			allIn[j++] = vertices.get(i).Position.z;
			//textura
			allIn[j++] = vertices.get(i).TexCoords.x;
			allIn[j++] = vertices.get(i).TexCoords.y;
			//normal
			allIn[j++] = vertices.get(i).Normal.x;
			allIn[j++] = vertices.get(i).Normal.y;
			allIn[j++] = vertices.get(i).Normal.z;
			//tangent
			allIn[j++] = vertices.get(i).Tangent.x;
			allIn[j++] = vertices.get(i).Tangent.y;
			allIn[j++] = vertices.get(i).Tangent.z;
			//bitangent
			allIn[j++] = vertices.get(i).Bitangent.x;
			allIn[j++] = vertices.get(i).Bitangent.y;
			allIn[j++] = vertices.get(i).Bitangent.z;
		}
		return allIn;
	}
	
	public static float[] convertVertexPositionToFloat(List<Vertex> vertices) {
		float[] posicoes = new float[vertices.size() * 3];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			posicoes[j] = vertices.get(i).Position.x;
			posicoes[j+1] = vertices.get(i).Position.y;
			posicoes[j+2] = vertices.get(i).Position.z;
			j = j+3;
		}
		
		return posicoes;
	}
	
	public static float[] convertVertexNormalToFloat(List<Vertex> vertices) {
		float[] normal = new float[vertices.size() * 3];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			normal[j] = vertices.get(i).Normal.x;
			normal[j+1] = vertices.get(i).Normal.y;
			normal[j+2] = vertices.get(i).Normal.z;
			j = j + 3;
		}
		return normal;
	}
	
	public static float[] convertVertexTexCoordsToFloat(List<Vertex> vertices) {
		float[] texcoords = new float[vertices.size() * 2];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			texcoords[j] = vertices.get(i).TexCoords.x;
			texcoords[j+1] = vertices.get(i).TexCoords.y;
			j = j + 2;
		}
		return texcoords;
	}
	
	public static float[] convertVertexTangentToFloat(List<Vertex> vertices) {
		float[] tangent = new float[vertices.size() * 3];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			tangent[j] = vertices.get(i).Tangent.x;
			tangent[j+1] = vertices.get(i).Tangent.y;
			tangent[j+2] = vertices.get(i).Tangent.z;
			j = j + 3;
		}
		return tangent;
	}
	
	public static float[] convertVertexBitangentToFloat(List<Vertex> vertices) {
		float[] bitangent = new float[vertices.size() * 3];
		int j = 0;
		for(int i=0;i<vertices.size();i++) {
			bitangent[j] = vertices.get(i).Bitangent.x;
			bitangent[j+1] = vertices.get(i).Bitangent.y;
			bitangent[j+2] = vertices.get(i).Bitangent.z;
			j = j + 3;
		}
		return bitangent;
	}
}
