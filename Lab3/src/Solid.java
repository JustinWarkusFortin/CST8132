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
	

	public boolean addFacet(Facet n) {
		facets.add(n);
		//improved with Matthew Leblanc
		return facets.contains(facets);
	}
	//done alongside Matthew Leblanc
	public String toString() {
		String facetString = "";
		for(int i = 0; i < facets.size(); i++) {
			facetString += facets.get(i).toString();
		}
		return "solid " + name +"\n" + facetString + "end solid " + name;
		
	
	}

}
