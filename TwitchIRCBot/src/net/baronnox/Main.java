package net.baronnox;

import net.baronnox.bot.IrcBot;

public class Main
{
	public static void main(String[] args)
	{
		String target = "#baronnox";
		
		IrcBot bot = new IrcBot();
		bot.setVerbose(true);
		bot.connectBot(target);
	}

}
