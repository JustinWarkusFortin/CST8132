package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import stl.Solid;
import stl.StlImage;
import stl.Vertex;

class SolidTest {
	Solid s = new Solid();
	@Test
	void testInvalid() {
		Vertex v1, v2, v3;
		s.addFacet(createIfsVertex(0, 1, 2));
	}

}
