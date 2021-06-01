package scene;

/**
 * Interface que define o cenario carregado pelo Assimp
 * @author Lucas Sommer <lucas.sommer@multi24h.com.br>
 * @since  27 de mai. de 2021
 */
public interface IAssimpCenario {
	
	public int contarMalhas();
	
	public void soltar();
	
	public boolean isSolto();
	
	public IAssimpMalha getMalha(int indice);
}
