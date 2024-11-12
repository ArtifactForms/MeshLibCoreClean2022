package test.creator.basetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mesh.Mesh3D;
import util.MeshTest;
import mesh.creator.IMeshCreator;

import mesh.creator.primitives.SegmentedCubeCreator;

// Auto-generated test class to execute base tests for mesh creators
public class SegmentedCubeCreatorBaseTest {

    private Mesh3D mesh;

    @Before
    public void setUp() {
        mesh = new SegmentedCubeCreator().create();
    }

    public void implementsCreatorInterface() {
        SegmentedCubeCreator creator = new SegmentedCubeCreator();
        Assert.assertTrue(creator instanceof IMeshCreator);
    }

    @Test
    public void createdMeshIsNotNullByDefault() {
        Assert.assertNotNull(mesh);
    }

    @Test
    public void vertexListIsNotEmpty() {
        Assert.assertFalse(mesh.vertices.isEmpty());
    }

    @Test
    public void getVertexCountReturnsSizeOfVertexList() {
        int vertexCount = mesh.getVertexCount();
        Assert.assertEquals(vertexCount, mesh.getVertices().size());
    }

    @Test
    public void getFaceCountReturnsSizeOfFaceList() {
        int faceCount = mesh.getFaceCount();
        Assert.assertEquals(faceCount, mesh.getFaces().size());
    }

    @Test
    public void createdMeshHasNoLooseVertices() {
        Assert.assertTrue(MeshTest.meshHasNoLooseVertices(mesh));
    }

    @Test
    public void createdMeshHasNoDuplicatedFaces() {
        // Running this test is very time expensive
        Assert.assertTrue(MeshTest.meshHasNoDuplicatedFaces(mesh));
    }

    @Test
    public void eachCallOfCreateReturnsNewUniqueMeshInstance() {
        Mesh3D mesh0 = new SegmentedCubeCreator().create();
        Mesh3D mesh1 = new SegmentedCubeCreator().create();
        Assert.assertTrue(mesh0 != mesh1);
    }

    @Test
    public void creationOfVerticesIsConsistentIfNotChangingParameters() {
        Mesh3D mesh0 = new SegmentedCubeCreator().create();
        Mesh3D mesh1 = new SegmentedCubeCreator().create();
        mesh0.vertices.removeAll(mesh1.getVertices());
        Assert.assertEquals(0, mesh0.getVertices().size());
        Assert.assertEquals(0, mesh0.getVertexCount());
    }

    @Test
    public void getSetSegments() {
        int expected = 1839646710;
        SegmentedCubeCreator creator = new SegmentedCubeCreator();
        creator.setSegments(expected);
        Assert.assertEquals(expected, creator.getSegments());
    }

    @Test
    public void getSegmentsReturnsDefaultValue() {
        int expected = 10;
        SegmentedCubeCreator creator = new SegmentedCubeCreator();
        Assert.assertEquals(expected, creator.getSegments());
    }

    @Test
    public void getSetSize() {
        float expected = 3.188742844387686E38f;
        SegmentedCubeCreator creator = new SegmentedCubeCreator();
        creator.setSize(expected);
        Assert.assertEquals(expected, creator.getSize(), 0);
    }

    @Test
    public void getSizeReturnsDefaultValue() {
        float expected = 1.0f;
        SegmentedCubeCreator creator = new SegmentedCubeCreator();
        Assert.assertEquals(expected, creator.getSize(), 0);
    }

}
