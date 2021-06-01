#version 410

layout (location = 1) in vec3 position;
layout (location = 2) in vec2 tex_coords;
layout (location = 3) in vec3 normal;
layout (location = 4) in vec3 tangent;
layout (location = 5) in vec3 bitangent;

uniform mat4 projection = mat4(1.0);
uniform mat4 view = mat4(1.0);
uniform mat4 model = mat4(1.0);

out vec2 TexCoord;
out vec3 normals;


void main() {
	TexCoord = tex_coords;
	normals = normal;
	gl_Position = projection * view * model * vec4(position,1.0);
}