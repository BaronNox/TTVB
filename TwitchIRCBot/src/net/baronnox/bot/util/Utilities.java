package net.baronnox.bot.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class Utilities
{
	public static String getDate() {
		LocalDate date = LocalDate.now();
		return date.toString();
	}
	
	synchronized public static void writeToChannel(Path path, String msg) throws IOException {
		Files.write(path, msg.getBytes(), StandardOpenOption.APPEND);
	}
	
	synchronized public static void writeToUsr(Path path, String msg) throws IOException {
		Files.write(path, msg.getBytes(), StandardOpenOption.APPEND);
	}
}
