package IfsInheritance;

public class IfsCreator {
	
	
	
	public static int[][] generateIfs(AffineTransform affineIfs){
		
		double A = 0,
			   B = 0, 
			   C = 0, 
			   D = 0, 
			   E = 0, 
			   F = 0, 
			   x = 0, 
			   y = 0;
		
		double scale = affineIfs.getScale();
		int width = affineIfs.getWidth(), 
			height = affineIfs.getHeight(), 
			xOffset = affineIfs.getxOffset(), 
			yOffset = affineIfs.getyOffset();
		
		double[][] matrixProb = affineIfs.getAffine();
		int[][] twoDArray = new int[width][height];
		
		for(int i = 0; i < width * height; i++) {
			double num = Math.random();
			double currentProb = 0, overallProb = 0;

			 for(int j = 0; j < matrixProb.length; j++) {
				 currentProb += matrixProb[j][matrixProb[j].length -1 ];
						 
				 if (num > overallProb && num < currentProb) {
					 A = matrixProb[j][0];
					 B = matrixProb[j][1];
					 C = matrixProb[j][2];
					 D = matrixProb[j][3];
					 E = matrixProb[j][4];
					 F = matrixProb[j][5];
				 }
				 overallProb = currentProb;
			 }

			 double u = A * x + B * y + E;
			 double v = C *x + D *y  + F;
			 x = u;
			 y = v;
			 int xDisplay = (int) (x *scale + xOffset);
			 int yDisplay = (int) (y *scale + yOffset);
			 twoDArray[yDisplay][xDisplay]++;
			
		}

	
		return twoDArray;

	}
}
