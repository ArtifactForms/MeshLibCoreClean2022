package test.creator.basetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mesh.Mesh3D;
import util.MeshTest;
import mesh.creator.IMeshCreator;

import mesh.creator.archimedian.TruncatedTetrahedronCreator;

// Auto-generated test class to execute base tests for mesh creators
public class TruncatedTetrahedronCreatorBaseTest {

    private Mesh3D mesh;

    @Before
    public void setUp() {
        mesh = new TruncatedTetrahedronCreator().create();
    }

    public void implementsCreatorInterface() {
        TruncatedTetrahedronCreator creator = new TruncatedTetrahedronCreator();
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
        Mesh3D mesh0 = new TruncatedTetrahedronCreator().create();
        Mesh3D mesh1 = new TruncatedTetrahedronCreator().create();
        Assert.assertTrue(mesh0 != mesh1);
    }

    @Test
    public void creationOfVerticesIsConsistentIfNotChangingParameters() {
        Mesh3D mesh0 = new TruncatedTetrahedronCreator().create();
        Mesh3D mesh1 = new TruncatedTetrahedronCreator().create();
        mesh0.vertices.removeAll(mesh1.getVertices());
        Assert.assertEquals(0, mesh0.getVertices().size());
        Assert.assertEquals(0, mesh0.getVertexCount());
    }

}