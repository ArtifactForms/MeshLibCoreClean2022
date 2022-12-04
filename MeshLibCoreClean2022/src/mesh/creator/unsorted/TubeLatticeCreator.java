package mesh.creator.unsorted;

import mesh.Mesh3D;
import mesh.creator.IMeshCreator;
import mesh.creator.primitives.SegmentedTubeCreator;
import mesh.modifier.SolidifyModifier;
import mesh.operators.ExtrudeIndividualFacesOperator;
import mesh.selection.FaceSelection;
import mesh.util.Mesh3DUtil;

public class TubeLatticeCreator implements IMeshCreator {

	private int segments;
	private int vertices;
	private float outerRadius;
	private float innerRadius;
	private float height;
	private float scaleExtrude;
	private float thickness;
	private Mesh3D mesh;

	public TubeLatticeCreator() {
		segments = 10;
		vertices = 32;
		outerRadius = 1f;
		innerRadius = 0.9f;
		height = 2f;
		scaleExtrude = 0.5f;
		thickness = 0.1f;
	}

	@Override
	public Mesh3D create() {
		SegmentedTubeCreator creator = new SegmentedTubeCreator();
		creator.setHeight(height);
		creator.setInnerRadius(innerRadius);
		creator.setOuterRadius(outerRadius);
		creator.setSegments(segments);
		creator.setVertices(vertices);

		mesh = creator.create();

		FaceSelection selection = new FaceSelection(mesh);
		selection.selectTopFaces();
		selection.selectBottomFaces();
		selection.invert();

		ExtrudeIndividualFacesOperator operator = new ExtrudeIndividualFacesOperator(mesh);
		operator.setScale(scaleExtrude);
		operator.setRemoveFace(true);
		operator.apply(selection.getFaces());

		Mesh3DUtil.flipDirection(mesh);
		new SolidifyModifier(thickness).modify(mesh);
		return mesh;
	}

	public float getThickness() {
		return thickness;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public int getSegments() {
		return segments;
	}

	public void setSegments(int segments) {
		this.segments = segments;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public float getOuterRadius() {
		return outerRadius;
	}

	public void setOuterRadius(float outerRadius) {
		this.outerRadius = outerRadius;
	}

	public float getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(float innerRadius) {
		this.innerRadius = innerRadius;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getScaleExtrude() {
		return scaleExtrude;
	}

	public void setScaleExtrude(float scaleExtrude) {
		this.scaleExtrude = scaleExtrude;
	}

}
