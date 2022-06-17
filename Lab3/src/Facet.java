
public class Facet {
	
	public Vertex normal, v1, v2, v3;

	public Facet(Vertex v1, Vertex v2, Vertex v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;;
		this.normal = Vertex.calcNormal(v1, v2, v3);
		
	}
	public String toString() {
		return "facet normal "+normal.toString()+
			   "\n outer loop"+
			   "\n  vertex "+v1.toString()+
			   "\n  tvertex "+v2.toString()+
			   "\n  vertex "+v3.toString()+
			   "\n end loop"+
			   "\nend facet\n";
	}

	
}
