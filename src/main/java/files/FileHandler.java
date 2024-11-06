package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FileHandler {
	
	public void writeFile() throws IOException {
		File myObj = new File("src/main/resources/files/filename.txt");
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
		
		FileWriter myWriter = new FileWriter(myObj);
		
		for (int i = 0; i < 1000; i++) {
			myWriter.write(i + "\n");
		}
		myWriter.close();
	}
	
	public void readFile() throws IOException {
		Random random = new Random();
		int num = 0;
		List<Integer> read = new ArrayList<Integer>();
		
		while (read.size() < 1000) {
			num = random.nextInt(999);
			if(read.contains(num)) {
				continue;
			}
			try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/files/filename.txt"))) {
				System.out.println(lines.skip(num).findFirst().get());
			}
			read.add(num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new FileHandler().readFile();
	}
	
}
