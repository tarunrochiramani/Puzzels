package com.tr.dataStrutsOperations;

import com.tr.datastruts.GraphNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GraphOperationsTest {

    private GraphOperations graphOperations = new GraphOperations();
    private GraphNode<String> parentNode;
    private GraphNode<String> level1Child1;
    private GraphNode<String> level1Child2;

    @Before
    public void canCreateGraph() {
        parentNode = new GraphNode<String>("parent");
        level1Child1 = new GraphNode<String>("level1child1");
        level1Child2 = new GraphNode<String>("level1child2");

        graphOperations.addAdjacentNode(parentNode, level1Child1, level1Child2);

        assertFalse(parentNode.getAdjacentNodes().isEmpty());
        assertTrue(parentNode.getAdjacentNodes().contains(level1Child1));
        assertTrue(parentNode.getAdjacentNodes().contains(level1Child2));
        assertEquals(2, parentNode.getAdjacentNodes().size());
    }

    @Test
    public void testBFSWithNull() {
        assertNull(graphOperations.doBFS(null));
    }

    @Test
    public void testBFSWithOneLevel() {
        String traversal = graphOperations.doBFS(parentNode);
        String expected = createExpectedBFSResult(parentNode, level1Child1, level1Child2);

        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }

    @Test
    public void testBFSWithMultipleLevel() {
        GraphNode<String> level2Child1 = new GraphNode<String>("level2child1");
        GraphNode<String> level2Child2 = new GraphNode<String>("level2child2");
        GraphNode<String> level3Child1 = new GraphNode<String>("level3child1");

        graphOperations.addAdjacentNode(level1Child1, level2Child1);
        graphOperations.addAdjacentNode(level1Child2, level2Child2);
        graphOperations.addAdjacentNode(level2Child1, level3Child1);

        String expected = createExpectedBFSResult(parentNode, level1Child1, level1Child2, level2Child1, level2Child2, level3Child1);

        String traversal = graphOperations.doBFS(parentNode);
        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }

    @Test
    public void testBFSWithCircular() {
        GraphNode<String> level2Child1 = new GraphNode<String>("level2child1");

        graphOperations.addAdjacentNode(level1Child1, level2Child1);
        graphOperations.addAdjacentNode(level2Child1, level1Child1);

        String traversal = graphOperations.doBFS(parentNode);
        String expected = createExpectedBFSResult(parentNode, level1Child1, level1Child2, level2Child1);

        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }

    @Test
    public void testDFSForNull() {
        assertNull(graphOperations.doDFS(null));
    }

    @Test
    public void testDFSForOneLevel() {
        String expected = createExpectedBFSResult(parentNode, level1Child1, level1Child2);

        String traversal = graphOperations.doDFS(parentNode);

        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }

    @Test
    public void testDFSForMultipleLevel() {
        GraphNode<String> level2Child1 = new GraphNode<String>("level2child1");
        GraphNode<String> level2Child2 = new GraphNode<String>("level2child2");
        GraphNode<String> level3Child1 = new GraphNode<String>("level3child1");

        graphOperations.addAdjacentNode(level1Child1, level2Child1);
        graphOperations.addAdjacentNode(level1Child2, level2Child2);
        graphOperations.addAdjacentNode(level2Child1, level3Child1);

        String expected = createExpectedBFSResult(parentNode, level1Child1, level2Child1, level3Child1, level1Child2, level2Child2);

        String traversal = graphOperations.doDFS(parentNode);
        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }

    @Test
    public void testDFSForCircular() {
        GraphNode<String> level2Child1 = new GraphNode<String>("level2child1");

        graphOperations.addAdjacentNode(level1Child1, level2Child1);
        graphOperations.addAdjacentNode(level2Child1, level1Child1);

        String traversal = graphOperations.doDFS(parentNode);
        String expected = createExpectedBFSResult(parentNode, level1Child1, level2Child1, level1Child2);

        assertNotNull(traversal);
        assertEquals(expected, traversal);
    }


    private String createExpectedBFSResult(GraphNode<String>... values) {
        if (values == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (GraphNode<String> value : values) {
            stringBuilder.append(value.getValue() + ";");
        }

        return stringBuilder.toString();
    }
}
