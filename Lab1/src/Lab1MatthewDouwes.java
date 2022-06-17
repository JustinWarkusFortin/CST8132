

public class Lab1MatthewDouwes {
	public static double[][] valueHolder;
	private static int scale , height , width , xOffset , yOffset;
	private static double x = 0 , y = 0;

	public static void pyramid() {
		scale = -500;
		height = 449;
		width = 519;
		xOffset = 439;
		yOffset = 509;
		valueHolder = new double[][]
		{  
			{0.50, 0.00, 0.00, 0.50, 0.00, 0.00, 0.33},
			{0.50, 0.00, 0.00, 0.50, 0.00, 0.50, 0.33},
			{0.50, 0.00, 0.00, 0.50, 0.43, 0.25, 0.34} 
		};	
	}
	public static void leaf() {
		scale = 100;
		height = 503;
		width = 1019;
		xOffset = 228;
		yOffset = 10;
		valueHolder = new double[][]
		{
			{ 0, 0, 0, 0.16, 0, 0, 0.01 }, 
			{ 0.85, 0.04, -0.04, 0.85, 0, 1.6, 0.85 },
			{ 0.2, -0.26, 0.23, 0.22, 0, 1.6, 0.07 }, 
			{ -0.15, 0.28, 0.26, 0.24, 0, 0.44, 0.07 } 
		};
	}
	public static int[][] IteratedFunction(double[][] array) {
		int[][] genMatrix = new int[width][height];
		int xValues = -1;
		for(int i = 0; i < width * height ; i++){
			double n = Math.random();
			if (n<0.33){
				xValues = 0;
			} else if (n<0.66){
				xValues = 1;
			} else {
				xValues = 2;
			}
			
		double u = valueHolder[xValues][0] * x + valueHolder[xValues][1] * y + valueHolder[xValues][4];
		double v = valueHolder[xValues][2] * x + valueHolder[xValues][3] * y + valueHolder[xValues][5];
		x = u;
		y = v;
		int xDisplay = (int) (x * scale + xOffset);
		int yDisplay = (int) (y * scale + yOffset);
		genMatrix[yDisplay][xDisplay]++;
		}
		return genMatrix;
	}
public static void main(String[]args) {
	pyramid();
	IfsViewer.view(IteratedFunction(valueHolder));
	leaf();
	IfsViewer.view(IteratedFunction(valueHolder));
}
}	

