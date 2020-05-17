package lab8.classes;

import java.util.Date;
import java.text.*;

public class ChatMessage
{
	private String Author;
	private String Message;
	private long time;
	private String Where;
	private Date c;




	public ChatMessage(String Author, String Message, long time, String Where, Date c)
	{
		this.Author = Author;
		this.Message = Message;
		this.time = time;
		this.Where = Where;
		this.c = c;
	}

	public String getAuthor()
	{
		return Author;
	}
	public String getMessage()
	{
		return Message;
	}
	public long getTime()
	{
		return time;
	}
	public String getWhere()
	{
		return Where;
	}
	public String getc()
	{
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("|dd.MM.yy hh:mm| ");
		String date = formatForDateNow.format(c);
		return date;
	}



	public void setAuthor(String author) { Author = author; }
	public void setMessage(String message) { Message = message; }
	public void setTime(long time) { this.time = time; }
	public void setWhere(String where) { Where = where; }
	public void setc(Date c) { c = c; }

	@Override
	public String toString()
	{
		return getAuthor() + " (" + getTime() + ") -> " + getMessage();
	}
}
