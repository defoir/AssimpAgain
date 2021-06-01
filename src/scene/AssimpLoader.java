package scene;

import java.nio.ByteBuffer;

import org.lwjgl.assimp.AIPropertyStore;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.Assimp;

public class AssimpLoader {
	private AssimpCena scene;
	
	public IAssimpCenario carregaCena(String file) {
		AIPropertyStore config = Assimp.aiCreatePropertyStore();
//		Assimp.aiSetImportPropertyInteger(config, Assimp.AI_CONFIG_PP_SLM_VERTEX_LIMIT, 65535);
		
		AIScene cena = Assimp.aiImportFile(file, 
				Assimp.aiProcess_Triangulate | 
				Assimp.aiProcess_FlipUVs | Assimp.aiProcess_CalcTangentSpace);
		if(cena == null) {
			return null;
		}
		scene = new AssimpCena(cena);
		return scene;
	}
	
	public void processaMalha(AssimpMalha mesh) {
		for(int i=0;i<scene.getCena().mNumMeshes();i++) {
			
		}
	}
}
