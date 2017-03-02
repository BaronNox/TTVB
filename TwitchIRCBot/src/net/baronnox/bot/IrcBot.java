package net.baronnox.bot;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

import net.baronnox.bot.runnables.WriteToChannel;
import net.baronnox.bot.runnables.WriteToUser;
import net.baronnox.bot.util.References;

public class IrcBot extends PircBot
{
	private final String usrName = "Keepsake_Muna";
	private final String pwd = "oauth:vw6ohh14c38o2vjh4zw1wknuofhooa";
	private final String node = "irc.twitch.tv";
	
	private ExecutorService pool = Executors.newCachedThreadPool();
	
	public IrcBot()
	{
		this.setName(usrName);
		this.setMessageDelay(1600);
		
		try
		{
			Files.createDirectories(Paths.get(References.ROOT_DIR));
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		pool.execute(new WriteToChannel(channel, sender, message));
		pool.execute(new WriteToUser(channel, sender, message));
//		Path usrPath = Paths.get(References.ROOT_DIR + sender + "/" + channel);
//		Path chnPath = Paths.get(References.ROOT_DIR + "/" + channel);
//		String msg = "[" + new Date().toString() + "] " + message + System.getProperty("line.separator");
//		
//		
//		
//		if(Files.exists(Paths.get(References.ROOT_DIR + sender + "/" + channel))) {
//			try
//			{
//				Files.write(usrPath, msg.getBytes(), StandardOpenOption.APPEND);
//			} catch(IOException e)
//			{
//				e.printStackTrace();
//			}
//		} else {
//			try
//			{
//				Files.createDirectories(usrPath.getParent());
//				Files.createFile(usrPath);
//				Files.write(usrPath, msg.getBytes(), StandardOpenOption.APPEND);
//			} catch(IOException e)
//			{
//				e.printStackTrace();
//			}
//		}
		
		
		
		if(message.equalsIgnoreCase("b!time")) {
			String time = new Date().toString();
			sendMessage(channel, "Time is: " + time + ".");
		} 
	}
	
	public void connectBot(String channel) {
		try
		{
			this.connect(node, 6667, pwd);
		} catch(IOException | IrcException e)
		{
			e.printStackTrace();
		}
		this.joinChannel(channel);
	}
}
