package scene;

import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.Assimp;

public class AssimpCena implements IAssimpCenario{
	private AIScene cena;
	private boolean solto;
	
	public AssimpCena(AIScene cena) {
		this.cena = cena;
	}
	
	@Override
	public int contarMalhas() {
		return cena.mNumMeshes();
	}

	@Override
	public void soltar() {
		if(isSolto())
			return;
		
		solto = true;
		// solta toda os recursos associados com esse importação
		Assimp.aiReleaseImport(cena);
	}

	@Override
	public boolean isSolto() {
		return solto;
	}

	@Override
	public IAssimpMalha getMalha(int indice) {
		return new AssimpMalha(AIMesh.create(cena.mMeshes().get(indice)));
	}

	public AIScene getCena() {
		return cena;
	}

	public void setCena(AIScene cena) {
		this.cena = cena;
	}

}
