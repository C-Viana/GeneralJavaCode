package lib;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
class FoldersTest {
	
	private Folders folders;
	private static String folderName = "";
	private static StringBuilder builder;
	private static final String lastFolder = "/TestFolder";
	
	@BeforeAll
	static void setup() {
		folderName = String.valueOf(new Random().nextInt(99));
		builder = new StringBuilder();
		builder.append(System.getProperty("user.dir"));
		builder.append("/src/test/resources/");
		builder.append(folderName);
		builder.append(lastFolder);
	}
	
	@Test
	void createFolderTest() throws IOException, InterruptedException {
		folders = new Folders();
		String testFolderPath = builder.toString();
		
		File file = new File(testFolderPath);
		Assertions.assertTrue( folders.createDirectory(testFolderPath) );
		Assertions.assertTrue( file.exists(), "Folder not found!" );
	}
	
	@Test
	void createFolderFailTest() {
		folders = new Folders();
		Assertions.assertFalse( folders.createDirectory("M:\\FFOutput\\TestFolder") );
	}
	
	@Test
	void removeFolderTest() throws InterruptedException, IOException {
		folders = new Folders();
		String testFolderPath = builder.toString();
		folders.createDirectory(testFolderPath);
		Assertions.assertTrue( folders.removeDirectoryWithFiles(testFolderPath) );
	}
	
	@Test
	void removeFolderFailTest() {
		folders = new Folders();
		Assertions.assertFalse( folders.createDirectory("N:\\FFOutput\\TestFolder") );
	}
	
	@Test
	void copyDirectoryTest() throws IOException, InterruptedException {
		String folderToCopy = System.getProperty("user.dir") + "\\src\\test\\resources\\ComparableImages";
		folders = new Folders();
		String testFolderPath = builder.toString();
		Assertions.assertTrue( folders.copyDirectory(folderToCopy, testFolderPath) );
	}
	
	@Test
	void copyDirectoryWrongOriginTest() {
		String folderToCopy = System.getProperty("user.dir") + "\\WrongFoldername";
		folders = new Folders();
		String testFolderPath = builder.toString();
		Assertions.assertFalse( folders.copyDirectory(folderToCopy, testFolderPath) );
	}
	
	@Test
	void removeDirectoryTest() throws Exception {
		String folderToCopy = System.getProperty("user.dir") + "\\src\\test\\resources\\ComparableImages";
		folders = new Folders();
		String testFolderPath = builder.toString();
		folders.copyDirectory(folderToCopy, testFolderPath);
		Assertions.assertTrue( folders.removeDirectoryWithFiles(testFolderPath) );
	}
	
	@Test
	void removeDirectoryWrongOriginTest() throws Exception {
		String folderToRemove = System.getProperty("user.dir") + "\\WrongFoldername";
		folders = new Folders();
		Assertions.assertFalse( folders.removeDirectoryWithFiles(folderToRemove) );
	}
	
}
