package scene;

/**
 * Interface que define métodos para uma malha carregada pelo Assimp
 * @author Lucas Sommer <lucas.sommer@multi24h.com.br>
 * @since  27 de mai. de 2021
 */
public interface IAssimpMalha {
	
	public int countOssos();
	
	public int countVertices();
	
	public int countTriangulos();
	
	public int countCamadasUV();
	
	public void getPosicaoVertice(float[] dados, int posicao, int indice);
	
	public void getVerticeNormal(float[] dados, int posicao, int indice);
	
	public void getVerticeTangente(float[] dados, int posicao, int indice);
	
	public void getVerticeBitangente(float[] dados, int posicao, int indice);
	
	public void getVerticeUV(float[] dados, int posicao, int indice, int camadaUV);
	
	public void getTriangulo(int[] dados, int posicao, int indice);
}
