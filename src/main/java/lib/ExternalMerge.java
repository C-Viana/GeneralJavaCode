package lib;

public class ExternalMerge {
	
	private static int[] fileA = new int[]{11, 6, 9, 8, 2, 8, 10, 3, 7, 5, 1, 16, 19, 4, 12, 0, 15, 4, 11, 18, 19, 6, 5, 17, 0};
	
	public void printArray(int[] array) {
		System.out.println();
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public int[] sort(int size, int start, int[] original) {
		int[] array = new int[size];
		int limit = start+size-1;
		
		for(int i = start; i < limit; i++) {
			if(i>=original.length) break;
			if(original[i] > original[i+1]) {
				int temp = original[i+1];
				original[i+1] = original[i];
				original[i] = temp;
				i=start;
			}
		}
		
		for (int i = start; i <= limit; i++) {
			if(i>=original.length) break;
			array[i-start] = original[i];
			System.out.print(array[i-start]+"\t");
		}
		
		System.out.println("\n------------------------");
		return array;
	}
	
	public void intercalacao(int[]...arrays) {
		int ways = arrays.length;
		int blockSize = arrays[0].length;
		int finalSize = arrays[0].length * ways;
		int tempValue = 0;
		int[] newFile = new int[finalSize];
		int[] indexes = new int[ways];
		boolean[] controller = new boolean[ways];
		
		
		for (int i = 0; i < finalSize; i++) {
			for (int j = 0; j < ways-1; j++) {
				if(!controller[j]) {
					tempValue = arrays[j][indexes[j]];
					for (int k = j+1; k < ways-1; k++) {
						if(!controller[k])
							tempValue = (tempValue < arrays[k][indexes[k]]) ? tempValue : arrays[k][indexes[k]];
					}
				}
			}
			System.out.print(tempValue + " ");
			for (int j = 0; j < ways; j++) {
				if(!controller[j] && tempValue == arrays[j][indexes[j]]) {
					indexes[j]++;
					if(indexes[j] > blockSize-1) {
						controller[j] = true;
					}
					break;
				}
			}
			
//			System.out.print( tempValue+"\t" );
		}
	}
	
	public static void main(String[] args) {
		int memSize = 3;
		int[] tempFileA = new int[memSize];
		int[] tempFileB = new int[memSize];
		int[] tempFileC = new int[memSize];
		int[] tempFileD = new int[memSize];
		
		ExternalMerge m = new ExternalMerge();
		tempFileA = m.sort(memSize, 0, fileA);
		tempFileB = m.sort(memSize, memSize, fileA);
		tempFileC = m.sort(memSize, memSize*2, fileA);
		tempFileD = m.sort(memSize, memSize*3, fileA);
		
		m.intercalacao(tempFileA,tempFileB, tempFileC, tempFileD);
		
//		m.printArray(fileA);
	}
	
}
