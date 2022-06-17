package stl;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Solid {

	private String name;
	private ArrayList<Facet> facets = new ArrayList<Facet>();
	
	public Solid() {
		this.name = "";
	}
	public Solid(String name) {
		this.name = name;
	}
	

	public boolean addFacet(Facet facet) {
		facets.add(facet);
		boolean result;
		if(facets.contains(facet)) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	public String toString() {
        StringBuilder facetString = new StringBuilder("");
        for(int i = 0; i < facets.size(); i++) {
            facetString.append(facets.get(i).toString());
        }
        return "solid " + name +"\n" + facetString.toString() + "endsolid " + name;
    }
	/* Logical error, not enough time to fix before end of lab. */
	public boolean addFacet(Vertex...vertexes) {
		if(vertexes.length < 3) {
			return false;
		}
		else {
			for(int i = 2; i < vertexes.length; i += 3) {
				if(vertexes.length % 3 == 1) {
					addFacet(new Facet(vertexes[i-2], vertexes[i], vertexes[i+1]));
				}
				else if(vertexes.length % 3 == 2) {
					addFacet(new Facet(vertexes[i-2], vertexes[i+1], vertexes[i+1]));
				}
				else {
					addFacet(new Facet(vertexes[i-2], vertexes[i-1], vertexes[i]));
				}
			}
			return true;
		}
		
	}
	public void print(PrintWriter printMethod) {
		printMethod.println(toString());
	}
	

}
