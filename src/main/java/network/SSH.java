package network;

import java.io.ByteArrayOutputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSH {
	
	public static void main(String[] args) throws Exception {
		SSH ssh = new SSH();
		ssh.listFolderStructure("root", "", "172.17.0.2", 22, "pwd");
	}
	
	public void listFolderStructure(String username, String password, String host, int port, String command) throws Exception {
			    Session session = null;
			    ChannelExec channel = null;
			    
			    try {
			        session = new JSch().getSession(username, host, port);
			        session.setPassword(password);
			        session.setConfig("StrictHostKeyChecking", "no");
			        session.connect();
			        
			        channel = (ChannelExec) session.openChannel("exec");
			        channel.setCommand(command);
			        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			        channel.setOutputStream(responseStream);
			        channel.connect();
			        
			        while (channel.isConnected()) {
			            Thread.sleep(100);
			        }
			        
			        String responseString = new String(responseStream.toByteArray());
			        System.out.println(responseString);
			    }
			    finally {
			        if (session != null) {
			            session.disconnect();
			        }
			        if (channel != null) {
			            channel.disconnect();
			        }
			    }
			}
	
}
