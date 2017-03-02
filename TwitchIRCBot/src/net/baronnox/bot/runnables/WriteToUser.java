package net.baronnox.bot.runnables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import net.baronnox.bot.util.References;
import net.baronnox.bot.util.Utilities;

public class WriteToUser implements Runnable
{
	private Path path;
	private String msg;
	
	public WriteToUser(String channel, String usr, String msg)
	{
		StringBuilder sb = new StringBuilder("[" + new Date().toString() + "] ");
		this.path = Paths.get(References.ROOT_DIR + "twitchers/" + usr + "/" + Utilities.getDate() + 
				"/" + channel);
		sb.append(msg);
		sb.append(System.lineSeparator());
		this.msg = sb.toString();
	}

	@Override
	public void run()
	{
		try
		{
			if(Files.notExists(path)) {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			}
			Utilities.writeToUsr(path, msg);
			
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
