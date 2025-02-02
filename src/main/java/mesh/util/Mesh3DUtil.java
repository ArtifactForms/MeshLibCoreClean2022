package mesh.util;

import math.Mathf;
import math.Matrix3f;
import math.Vector3f;
import mesh.Face3D;
import mesh.Mesh3D;
import mesh.modifier.ExtrudeModifier;

@Deprecated
public class Mesh3DUtil {

	@Deprecated
	public static float perimeter(Mesh3D mesh, Face3D face) {
		float perimeter = 0;
		for (int i = 0; i < face.indices.length - 2; i++) {
			i++;
			Vector3f v0 = mesh.getVertexAt(face.indices[i]);
			Vector3f v1 = mesh.getVertexAt(face.indices[i + 1]);
			perimeter += v0.distance(v1);
		}
		return perimeter;
	}

	@Deprecated
	private static void scaleFace(Mesh3D mesh, Face3D face, float scale) {
		Vector3f center = mesh.calculateFaceCenter(face);
		for (int i = 0; i < face.indices.length; i++) {
			Vector3f v = mesh.vertices.get(face.indices[i]);
			v.subtractLocal(center).multLocal(scale).addLocal(center);
		}
	}

	@Deprecated
	public static void scaleFaceAt(Mesh3D mesh, int index, float scale) {
		Face3D f = mesh.faces.get(index);
		scaleFace(mesh, f, scale);
	}

	@Deprecated
	public static void rotateFaceX(Mesh3D mesh, Face3D face, float a) {
		Matrix3f m = new Matrix3f(1, 0, 0, 0, Mathf.cos(a), -Mathf.sin(a), 0, Mathf.sin(a), Mathf.cos(a));

		for (int i = 0; i < face.indices.length; i++) {
			Vector3f v = mesh.vertices.get(face.indices[i]);
			Vector3f v0 = v.mult(m);
			v.set(v.getX(), v0.getY(), v0.getZ());
		}
	}

	@Deprecated
	public static void rotateFaceY(Mesh3D mesh, Face3D face, float a) {
		Matrix3f m = new Matrix3f(Mathf.cos(a), 0, Mathf.sin(a), 0, 1, 0, -Mathf.sin(a), 0, Mathf.cos(a));

		for (int i = 0; i < face.indices.length; i++) {
			Vector3f v = mesh.vertices.get(face.indices[i]);
			Vector3f v0 = v.mult(m);
			v.set(v0.getX(), v.getY(), v0.getZ());
		}
	}

	@Deprecated
	public static void rotateFaceZ(Mesh3D mesh, Face3D face, float a) {
		Matrix3f m = new Matrix3f(Mathf.cos(a), -Mathf.sin(a), 0, Mathf.sin(a), Mathf.cos(a), 0, 0, 0, 1);

		for (int i = 0; i < face.indices.length; i++) {
			Vector3f v = mesh.vertices.get(face.indices[i]);
			Vector3f v0 = v.mult(m);
			v.set(v0.getX(), v0.getY(), v.getZ());
		}
	}

	/**
	 * @deprecated Use {@link ExtrudeModifier} instead.
	 */
	@Deprecated
	public static void extrudeFace(Mesh3D mesh, Face3D face, float scale, float amount) {
		ExtrudeModifier modifier = new ExtrudeModifier();
		modifier.setScale(scale);
		modifier.setAmount(amount);
		modifier.modify(mesh, face);
	}

}
