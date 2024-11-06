package lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Folders {
	
	public boolean createDirectory( String path ) {
		try {
			Path foldersPath = Path.of(path);
			Files.createDirectories(foldersPath);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public boolean removeDirectory( String path ) {
		try {
			Path foldersPath = Path.of(path);
			Files.delete(foldersPath);
			return true;
		}
		catch(IOException e) {
			return false;
		}
	}
	
	public boolean copyDirectory( String from, String to ) {
		File folderOrigin = new File(from);
		if( !folderOrigin.exists() ) return false;
		createDirectory( to );
		for (File each : folderOrigin.listFiles() ) {
			if(each.isDirectory()) continue;
			try (FileOutputStream out = new FileOutputStream( to + "\\" + each.getName() )) {
				out.write( Files.readAllBytes(each.toPath()) );
			}
			catch (IOException e) {
				return false;
			}
		}
		folderOrigin = null;
		return true;
	}
	
	public boolean removeDirectoryWithFiles( String path ) throws IOException {
		File folder = new File(path);
		if( !folder.exists() ) {
			return false;
		}
		else {
			for (File each : folder.listFiles() ) {
				if(each.isDirectory())
					removeDirectoryWithFiles(each.toPath().toString());
				Files.delete(each.toPath());
			}
			Files.delete(folder.toPath());
		}
		return true;
	}
	
	
	
}
