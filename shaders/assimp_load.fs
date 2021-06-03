#version 410

layout (location = 0) out vec4 color;

in vec2 TexCoord;
in vec3 normals;

uniform sampler2D texture_diffuse1;
uniform sampler2D texture_specular1;
uniform sampler2D texture_normal1;

void main(){
  	//color = texture(texture_diffuse1, TexCoord) * vec4(normalized, 1.0) * texture(texture_specular1, TexCoord) * texture(texture_normal1, TexCoord);
	//color = vec4(normalized, 1.0) * texture(texture_diffuse1, TexCoord);
	//color = texture2D(texture_diffuse1, TexCoord) * vec4(normalized, 1.0) * texture2D(texture_specular1, TexCoord) * texture2D(texture_normal1, TexCoord);
	
	//vec3 teste_diffuse = vec3(texture(texture_diffuse1, TexCoord));
	//vec3 teste_specular = vec3(texture(texture_specular1,TexCoord));
	//vec3 teste_normal = vec3(texture(texture_normal1,TexCoord));
	//teste_normal = normalize(TBN * teste_normal);
	//color = texture(texture_diffuse1, TexCoord) + texture(texture_normal1, TexCoord);
	//color = vec4(normals + teste_diffuse, 1.0);
	//color = texture2D(texture_diffuse1, TexCoord);
	
	//color = color + texture(texture_specular1,TexCoord);
	//color = color + texture(texture_normal1, TexCoord);
	
	
	color = texture(texture_diffuse1, TexCoord);
	
}