package test.creator.basetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mesh.Mesh3D;
import util.MeshTest;
import mesh.creator.IMeshCreator;

import mesh.creator.assets.SimpleSciFiCrateCreator;

// Auto-generated test class to execute base tests for mesh creators
public class SimpleSciFiCrateCreatorBaseTest {

    private Mesh3D mesh;

    @Before
    public void setUp() {
        mesh = new SimpleSciFiCrateCreator().create();
    }

    public void implementsCreatorInterface() {
        SimpleSciFiCrateCreator creator = new SimpleSciFiCrateCreator();
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
        Mesh3D mesh0 = new SimpleSciFiCrateCreator().create();
        Mesh3D mesh1 = new SimpleSciFiCrateCreator().create();
        Assert.assertTrue(mesh0 != mesh1);
    }

    @Test
    public void creationOfVerticesIsConsistentIfNotChangingParameters() {
        Mesh3D mesh0 = new SimpleSciFiCrateCreator().create();
        Mesh3D mesh1 = new SimpleSciFiCrateCreator().create();
        mesh0.vertices.removeAll(mesh1.getVertices());
        Assert.assertEquals(0, mesh0.getVertices().size());
        Assert.assertEquals(0, mesh0.getVertexCount());
    }

    @Test
    public void getSetExtrudeAmount() {
        float expected = 9.471817229255445E37f;
        SimpleSciFiCrateCreator creator = new SimpleSciFiCrateCreator();
        creator.setExtrudeAmount(expected);
        Assert.assertEquals(expected, creator.getExtrudeAmount(), 0);
    }

    @Test
    public void getExtrudeAmountReturnsDefaultValue() {
        float expected = 0.05f;
        SimpleSciFiCrateCreator creator = new SimpleSciFiCrateCreator();
        Assert.assertEquals(expected, creator.getExtrudeAmount(), 0);
    }

    @Test
    public void getSetExtrudeScale() {
        float expected = 3.296370507349843E38f;
        SimpleSciFiCrateCreator creator = new SimpleSciFiCrateCreator();
        creator.setExtrudeScale(expected);
        Assert.assertEquals(expected, creator.getExtrudeScale(), 0);
    }

    @Test
    public void getExtrudeScaleReturnsDefaultValue() {
        float expected = 0.9f;
        SimpleSciFiCrateCreator creator = new SimpleSciFiCrateCreator();
        Assert.assertEquals(expected, creator.getExtrudeScale(), 0);
    }

}
