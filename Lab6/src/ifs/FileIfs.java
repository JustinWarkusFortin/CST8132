package ifs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**The purpose of this class is to extract all the required values for an Affine Transform from a file.
 * @author Justin Warkus-Fortin
 * @version 1.0
 * @since 1.8
 */


public class FileIfs implements AffineTransform  {	
		
	private String name;
	private double scale;
	private int height,width,xOffset,yOffset;
	private double[][] affine;
	
	/**
	 * The constructor uses the parameter of file name to determine which file to take the Ifs info from,
	 * Creates a Scanner to read the lines,
	 * Then reads all the lines through a while loop to initialize each variable to the proper values
	 * @param fileName The name of the file to extract from.
	 */
	public FileIfs(String fileName) {
		
		try {
			Path filePath = Paths.get(fileName);
			Scanner lineReader = new Scanner(filePath);
		
			while(lineReader.hasNextLine()) {
				String fileLine = lineReader.nextLine();
				
				if(fileLine.contains("name")){
					this.name = fileLine.substring(5, fileLine.length());
				}
				if(fileLine.contains("scale")) {
					this.scale = Double.parseDouble(fileLine.substring(6, fileLine.length()));
				}
				if(fileLine.contains("height")) {
					this.height = Integer.parseInt(fileLine.substring(7, fileLine.length()));
				}
				if(fileLine.contains("width")) {
					this.width = Integer.parseInt(fileLine.substring(6, fileLine.length()));
				}
				if(fileLine.contains("xOffset")) {
					this.xOffset = Integer.parseInt(fileLine.substring(8, fileLine.length()));
				}
				if(fileLine.contains("yOffset")) {
					this.yOffset = Integer.parseInt(fileLine.substring(8, fileLine.length()));
				}
				if(fileLine.contains("affine")) {
					int rows = Integer.parseInt(fileLine.substring(7, fileLine.length()));
					this.affine = new double[rows][7];
				
					for(int i = 0; i < rows; i++) {
						for(int j = 0; j < 7; j++) {
							fileLine = lineReader.next();
							this.affine[i][j] = Double.parseDouble(fileLine);
						}
					}
				}
			}
			lineReader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method gets the name of the resulting image initialized through the Scanner
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * This method gets the affine after it was read from the Scanner after it has been parsed.
	 * @return affine
	 */
	public double[][] getAffine() {
		return this.affine;
	}
	/**
	 * This method gets the value for the scale from the Scanner after it has been parsed.
	 * @return scale
	 */
	public double getScale() {
		return this.scale;
	}
	/**
	 * This method gets the value for the height from the Scanner after it has been parsed.
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * This method gets the value for the width from the Scanner after it has been parsed.
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * This method gets the value for the xOffset from the Scanner after it has been parsed.
	 * @return xOffset
	 */
	public int getxOffset() {
		return this.xOffset;
	}
	/**
	 * This method gets the value for the yOffset from the Scanner after it has been parsed.
	 * @return yOffset
	 */
	public int getyOffset() {
		return this.yOffset;
	}
	
}
