package mesh.creator.archimedian.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import math.Mathf;
import mesh.Mesh3D;
import mesh.creator.IMeshCreator;
import mesh.creator.archimedian.TruncatedTetrahedronCreator;
import util.MeshTest;

public class TruncatedTetrahedronTest {

    private Mesh3D mesh;

    @Before
    public void setUp() {
        mesh = new TruncatedTetrahedronCreator().create();
    }

    @Test
    public void testImplementsMeshCreatorInterface() {
        TruncatedTetrahedronCreator creator = new TruncatedTetrahedronCreator();
        assertTrue(creator instanceof IMeshCreator);
    }

    @Test
    public void testCreatesNewInstances() {
        TruncatedTetrahedronCreator creator = new TruncatedTetrahedronCreator();
        Mesh3D mesh0 = creator.create();
        Mesh3D mesh1 = creator.create();
        Mesh3D mesh2 = creator.create();
        assertTrue(mesh0 != mesh1);
        assertTrue(mesh1 != mesh2);
    }

    @Test
    public void testVertexCount() {
        assertEquals(12, mesh.getVertexCount());
    }

    @Test
    public void testFaceCount() {
        assertEquals(8, mesh.getFaceCount());
    }

    @Test
    public void testTriangularFacesCount() {
        assertTrue(MeshTest.isTriangleCountEquals(mesh, 4));
    }

    @Test
    public void testHexagonalFacesCount() {
        assertTrue(MeshTest.isHexagonCountEquals(mesh, 4));
    }

    @Test
    public void testEdgeCount() {
        MeshTest.assertEdgeCountEquals(mesh, 18);
    }

    @Test
    public void testIsManifold() {
        assertTrue(MeshTest.isManifold(mesh));
    }

    @Test
    public void testFulfillsEulerCharacteristic() {
        assertTrue(MeshTest.fulfillsEulerCharacteristic(mesh));
    }

    @Test
    public void testNormalsPointOutwards() {
        assertTrue(MeshTest.normalsPointOutwards(mesh));
    }

    @Test
    public void testEdgeLengths() {
        float delta = 0;
        float expected = Mathf.sqrt(8);
        MeshTest.assertEveryEdgeHasALengthOf(mesh, expected, delta);
    }

}
