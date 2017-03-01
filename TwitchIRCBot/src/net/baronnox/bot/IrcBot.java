package net.baronnox.bot;

import java.io.IOException;
import java.util.Date;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;

public class IrcBot extends PircBot
{
	private final String usrName = "BNoxBot";
	private final String pwd = "oauth:88q3ofzcqazfrqslp5ai4xkltrogxh";
	private final String node = "irc.twitch.tv";
	
	public IrcBot()
	{
		this.setName("usrName");
		this.getPassword();
	}
	
	@Override
	protected void onMessage(String channel, String sender, String login, String hostname, String message)
	{
		if(message.equalsIgnoreCase("b!time")) {
			String time = new Date().toString();
			sendMessage(channel, "Time is: " + time + ".");
		} else if(message.equalsIgnoreCase("b!KappaTest")) {
			sendMessage(channel, "This is an automated message from Twitch TV. "
					+ "We have been experiencing technical difficulties "
					+ "related to the Kappa face. "
					+ "Please confirm that your  Kappa face is working properly.");
		} else if(message.equalsIgnoreCase("b!cmds")) {
			sendMessage(channel, "b!time: Displays current time at NoxBot's locatoin. -- b!kappatest: KappaTest");
		} else if(message.equalsIgnoreCase("b!disconnect")) {
			User[] users = getUsers(channel);
			for(int i = 0; i < users.length; i++) {
				if(users[i].getNick().equals(sender))
				{
					System.out.println(users[i].getPrefix());
				}
			}
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
