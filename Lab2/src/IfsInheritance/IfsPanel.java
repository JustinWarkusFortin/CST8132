package IfsInheritance;

import java.util.Scanner;

public class IfsPanel {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		AffineTransform[] fractals = new AffineTransform[3];
		
		
		fractals[0] = new BarnsleyFernIfs();
		fractals[1] = new SierpinskilIfs();
		fractals[2] = new MapleIfs();
		
		System.out.print("Available fractal images are:\n ");
		
		for(int i = 1; i < fractals.length + 1; i++) {
			
			System.out.printf("\n"+i+". "+fractals[i-1].getName());
		}
		
		System.out.print("\n\nWhich image would you like to select: ");
		int choice = 0;
		int minNumber = 1;
		int maxNumber = fractals.length;
		
		while(choice < minNumber || choice > maxNumber) {
			choice = input.nextInt();
			
			if(choice < minNumber || choice > maxNumber ) {
				System.out.print("Number must be between " + minNumber + " and "+ maxNumber + ". Please try again: ");
			}
			
			
		}
		
		input.close();
		
		IfsViewer.view(IfsCreator.generateIfs(fractals[choice-1]));
	}

	
}
