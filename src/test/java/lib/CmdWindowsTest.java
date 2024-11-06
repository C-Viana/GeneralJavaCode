package lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CmdWindowsTest {
	
	@Test
	void runCmdTest() throws Exception {
		Assertions.assertEquals( "C:\\Desenvolvimento\\Java11\\x64", new CmdWindows().runCmd("echo %JAVA_HOME%").trim() );
	}
	
}
