package scene;

import java.nio.IntBuffer;

import org.lwjgl.assimp.AIFace;
import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIVector3D;

public class AssimpMalha implements IAssimpMalha{
	
	private AIMesh mesh;
	
	public AssimpMalha(AIMesh malha) {
		mesh = malha;
	}

	@Override
	public int countOssos() {
		return mesh.mNumBones();
	}

	@Override
	public int countVertices() {
		return mesh.mNumVertices();
	}

	@Override
	public int countTriangulos() {
		return mesh.mNumFaces();
	}

	@Override
	public int countCamadasUV() {
		int contUV = 0;
		while(mesh.mTextureCoords(contUV) != null) {
			contUV++;
		}
		return contUV;
	}

	@Override
	public void getPosicaoVertice(float[] dados, int posicao, int indice) {
		AIVector3D vec = mesh.mVertices().get(indice);
		dados[posicao] = vec.x();
		dados[posicao + 1] = vec.y();
		dados[posicao + 2] = vec.z();
		
	}

	@Override
	public void getVerticeNormal(float[] dados, int posicao, int indice) {
		AIVector3D vec = mesh.mNormals().get(indice);
		dados[posicao] = vec.x();
		dados[posicao + 1] = vec.y();
		dados[posicao + 2] = vec.z();		
	}

	@Override
	public void getVerticeTangente(float[] dados, int posicao, int indice) {
		AIVector3D vec = mesh.mTangents().get(indice);
		dados[posicao] = vec.x();
		dados[posicao + 1] = vec.y();
		dados[posicao + 2] = vec.z();	
	}

	@Override
	public void getVerticeBitangente(float[] dados, int posicao, int indice) {
		AIVector3D vec = mesh.mBitangents().get(indice);
		dados[posicao] = vec.x();
		dados[posicao + 1] = vec.y();
		dados[posicao + 2] = vec.z();	
	}

	@Override
	public void getVerticeUV(float[] dados, int posicao, int indice, int camadaUV) {
		AIVector3D vec = mesh.mTextureCoords(camadaUV).get(indice);
		dados[posicao] = vec.x();
		dados[posicao + 1] = vec.y();
		dados[posicao + 2] = vec.z();	
	}

	@Override
	public void getTriangulo(int[] dados, int posicao, int indice) {
		AIFace face = mesh.mFaces().get(indice);
		IntBuffer index = face.mIndices();
		dados[posicao] = index.get(0);
		dados[posicao + 1] = index.get(1);
		dados[posicao + 2] = index.get(2);	
	}

}
