package net.baronnox;

import net.baronnox.bot.AnnouncerBot;
import net.baronnox.bot.IrcBot;

public class Main
{
	public static void main(String[] args)
	{
		String target = null;
		
		if(args.length != 0) {
			target = "#" + args[0];
		} else {
			target = "#ej_sa";
		}
		
		AnnouncerBot aBot = new AnnouncerBot();
		IrcBot bot = new IrcBot();
		
		bot.setVerbose(true);
		bot.connectBot(target);
//		aBot.joinChannelSU(target);
	}

}
