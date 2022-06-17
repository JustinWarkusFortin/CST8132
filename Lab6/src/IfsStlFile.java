import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import ifs.AffineTransform;
import ifs.IfsCreator;
import stl.Solid;
import stl.StlImage;

public class IfsStlFile {
		public static void main(String[] args) {

			Scanner input = new Scanner(System.in);
			AffineTransform[] affine = new IfsCreator().getTransforms();
			

			System.out.print("Available fractal images are:\n ");
			
			for(int i = 1; i < affine.length + 1; i++) {
				System.out.print("\n"+i+". "+affine[i-1].getName());
			}
			
			System.out.print("\n\nWhich image would you like to select: ");
			int choice = input.nextInt();
			
			while(choice < 1 || choice > affine.length ) {
				System.out.print("Number must be between " + 1 + " and "+ affine.length +
								 ". Please try again: ");
				choice = input.nextInt();			
			}
			AffineTransform affineFinal = affine[choice-1];
			StlImage stl = new StlImage(0.8, 4.0);
			int[][] solidImage = IfsCreator.generateIfs(affineFinal);
			
			Solid finalSolid = stl.createSolid(solidImage);
				
			String path = "C:\\temp\\" + affine[choice-1].getName() + ".stl";

			try(PrintWriter print = new PrintWriter(new FileWriter(path))) {
				finalSolid.print(print);
				System.out.println("\nDone.");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			input.close();
		}
	
}
