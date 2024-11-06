package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CmdWindows {
	
	public String runCmd( String command ) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder();
		StringBuilder line = new StringBuilder();
		int exitCode = -1;
		pb.command( Arrays.asList("cmd.exe", "/c", command) );
		try {
			Process process = pb.start();
			BufferedReader br = new BufferedReader( new InputStreamReader(process.getInputStream()) );
			String s = "";
			while( (s = br.readLine()) != null ) {
				line.append(s);
				line.append("\n");
			}
			exitCode = process.waitFor();
			process.destroy();
		}
		catch (IOException e) {
			throw new IOException("Error when trying execution of command!\n"+command);
		}
		return (exitCode == 0) ? line.toString() : "Error: exit code "+exitCode;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(new CmdWindows().runCmd("dir"));
	}
	
}
