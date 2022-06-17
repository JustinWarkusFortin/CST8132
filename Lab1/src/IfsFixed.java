
public class IfsFixed {
	
	public static double[][]  matrixProb;
	private static int scale;
	private static int height;
	private static int width;
	private static int xOffset;
	private static int yOffset;
	private static double x = 0;
	private static double y = 0;
		

	public static void pyramid() {
		scale = -500 ;
		height = 449;
		width = 519;
		xOffset= 439;
		yOffset = 509;
		matrixProb = new double[][]
				{ {0.50, 0.00, 0.00, 0.50, 0.00, 0.00, 0.33},
				  {0.50, 0.00, 0.00, 0.50, 0.00, 0.50, 0.33},
				  {0.50, 0.00, 0.00, 0.50, 0.43, 0.25, 0.34} };

	}
	public static void leaf() {
		scale = 100 ;
		height = 503;
		width = 1019;
		xOffset= 228;
		yOffset = 10;
		matrixProb = new double[][]
				{ { 0, 0, 0, 0.16, 0, 0, 0.01 }, 
				  { 0.85, 0.04, -0.04, 0.85, 0, 1.6, 0.85 },
				  { 0.2, -0.26, 0.23, 0.22, 0, 1.6, 0.07 }, 
				  { -0.15, 0.28, 0.26, 0.24, 0, 0.44, 0.07 } };
	}
	public static int[][] calculate(double[][] array) {
		
				int[][] twoDArray = new int[width][height];
				
				for(int i = 0; i <width * height; i++) {
					
					double num = Math.random();
					
					// use if comap --- with if for < .33 else if < .66 else
					
					
					double currentProb = 0;
					double overallProb = 0;
					int row = -1;

					for(int j = 0; j < matrixProb.length; j++) {
						currentProb += matrixProb[j][matrixProb[j].length -1 ];

						if (num > overallProb && num <currentProb) {
							row = j;
						}
						overallProb = currentProb;
					}

					double u = matrixProb[row][0] * x + matrixProb[row][1]* y + matrixProb[row][4];
					double v = matrixProb[row][2] *x + matrixProb[row][3] *y  + matrixProb[row][5];
					x = u;
					y = v;
					int xDisplay = (int) (x *scale + xOffset);
					int yDisplay = (int) (y *scale + yOffset);
					twoDArray[yDisplay][xDisplay]++;
					
			}

			
			return twoDArray;
		}
		
		

		public static void main(String[]args) {
			
			pyramid();
			IfsViewer.view(calculate(matrixProb));
			leaf();
			IfsViewer.view(calculate(matrixProb));
		}

}
