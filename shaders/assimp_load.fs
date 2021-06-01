#version 410

layout (location = 0) out vec4 color;

in vec2 TexCoord;
in vec3 normals;

uniform sampler2D texture_diffuse1;
uniform sampler2D texture_specular1;
uniform sampler2D texture_normal1;

void main(){
	vec3 normalized = normalize(normals);
  	//color = texture(texture_diffuse1, TexCoord) * vec4(normalized, 1.0) * texture(texture_specular1, TexCoord) * texture(texture_normal1, TexCoord);
	//color = vec4(normalized, 1.0) * texture(texture_diffuse1, TexCoord);
	//color = texture2D(texture_diffuse1, TexCoord) * vec4(normalized, 1.0) * texture2D(texture_specular1, TexCoord) * texture2D(texture_normal1, TexCoord);
	color = texture(texture_diffuse1, TexCoord)
}