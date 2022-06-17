package stl;

public class StlImage {
	private final double minThick;
	private final double thickScale;
	private static final double scale = 0.1;
	private double maxValue;
	
	
	public StlImage(double min, double max) {
		minThick = min;
		thickScale = max-min;
	}
	
	public Solid createSolid(int[][] matrix) {
		Solid solid = new Solid();
		int max = matrix[0][0];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(max < matrix[i][j]) {
					max = matrix[i][j];
					maxValue = max;
				}
			}
			
		}
		for(int x = 0; x < matrix.length-1; x++) {
			for(int y = 0; y < matrix[x].length-1; y++) {
				solid.addFacet(createIfsVertex(x, y, matrix[x][y]), 
							   createIfsVertex(x+1, y, matrix[x+1][y]), 
							   createIfsVertex(x+1,y+1,matrix[x+1][y+1]),
							   createIfsVertex(x, y+1, matrix[x][y+1]));
			}
		}
		
		solid.addFacet(createIfsVertex(0, 0, 0),
					   createIfsVertex(matrix[0].length*scale, 0, 0),
					   createIfsVertex(matrix[0].length*scale, 0, minThick),
					   createIfsVertex(0, 0, minThick));
        solid.addFacet(createIfsVertex(0, matrix.length*scale, 0),
        			   createIfsVertex(0, 0, 0),
        			   createIfsVertex(0,0,minThick),
        			   createIfsVertex(0, matrix.length*scale,minThick));
        solid.addFacet(createIfsVertex(matrix[0].length*scale, 0, 0),
        			   createIfsVertex(matrix[0].length*scale, matrix.length*scale, 0),
        			   createIfsVertex(matrix[0].length*scale, matrix.length*scale,minThick),
        			   createIfsVertex(matrix[0].length*scale, 0, minThick));
        solid.addFacet(createIfsVertex(matrix[0].length*scale, matrix.length*scale, 0),
        		 	   createIfsVertex(0, matrix.length*scale, 0),
        		 	   createIfsVertex(0, matrix.length*scale, minThick),
        		 	   createIfsVertex(matrix[0].length*scale, matrix.length*scale, minThick));
        solid.addFacet(createIfsVertex(0, 0, 0),
        			   createIfsVertex(0, matrix.length*scale, 0),
        			   createIfsVertex(matrix[0].length*scale, matrix.length*scale, 0),
        			   createIfsVertex(matrix[0].length*scale, 0, 0));
        return solid;
	}
	private Vertex createIfsVertex(double x, double y, double z) {	
		double thickness = minThick + thickScale * Math.sqrt((z/maxValue));
		Vertex createdVertex = new Vertex(x*scale, y*scale, thickness);
		return createdVertex;
		
	}
}
