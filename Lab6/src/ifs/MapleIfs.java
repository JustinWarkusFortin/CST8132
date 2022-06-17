package ifs;

public class MapleIfs implements AffineTransform {

	private double scale = 100;
	private int height = 702, width = 885, xOffset= 340, yOffset = 445;
	private double [][] affine = new double[][] { { 0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10 }, 
												  { 0.50, -0.45, 0.52, 0.43, 0.75, -1.49, 0.35 },
												  { 0.47, 0.47, -0.49, 0.45, 0.74, 1.62, 0.35}, 
												  { 0.51, 0.00, 0.00, 0.49, -1.62, -0.02, 0.20} };
			
	
	public String getName() {
		return "Maple";
	}
	public double[][] getAffine() {
		return this.affine;
	}
													
	public double getScale() {
		return this.scale;
	}
													
	public int getHeight() {
		return this.height;
	}
													
	public int getWidth() {
		return this.width;
	}
	
	@Override
	public int getxOffset() {
		// TODO Auto-generated method stub
		return this.xOffset;
	}
	@Override
	public int getyOffset() {
		// TODO Auto-generated method stub
		return this.yOffset;
	}
}
