package net.baronnox.bot;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

public class AnnouncerBot extends PircBot
{
	private final String USR_NAME = "BNoxBot";
	private final String OATH_TKN = "oauth:88q3ofzcqazfrqslp5ai4xkltrogxh";
	private final String NODE = "irc.twitch.tv";
	
	public AnnouncerBot()
	{
		this.setName(USR_NAME);
		this.setMessageDelay(2000);
		
		connectToNode();
	}
	
	public void joinChannelSU(String channel) {
		this.joinChannel(channel);
		sendMessage(channel, "> Module 'Bright Horiz0n' has been activated...");
		sendMessage(channel, "> 'Bright Horiz0n' is now operating on this node.");
		this.partChannel(channel);
	}
	
	public void partFromChannel(String channel) {
		this.joinChannel(channel);
		sendMessage(channel, "> Module 'Keepsake_Muna' has been deactivated.");
		this.partChannel(channel);
	}
	
	private void connectToNode() {
		try
		{
			this.connect(NODE, 6667, OATH_TKN);
		} catch(IOException | IrcException e)
		{
			e.printStackTrace();
		}
	}
}
