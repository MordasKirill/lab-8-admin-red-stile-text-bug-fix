package lab8.servlets;

import lab8.classes.ChatMessage;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chat/messages")
public class MessageListServlet extends ChatServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{






		PrintWriter printWriter = resp.getWriter();

		printWriter.println("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='5'></head>");
		printWriter.println("<body>");

		for (int i = Messages.size() - 1; i >= 0; i--)
		{

			ChatMessage message = Messages.get(i);

			if (message.getWhere().equalsIgnoreCase("All") && (message.getAuthor().equals("Admin")))
			{
				printWriter.println("<div><strong>"  + message.getc() +"<ins>" +"<font color ='red'>" + message.getAuthor()+"</font>" +"</ins>"  +"</strong>: " + message.getMessage() + "</div>");
			}

			else if (message.getWhere().equalsIgnoreCase("All"))
			{
				printWriter.println("<div><strong>"  + message.getc() +"<ins>" + message.getAuthor() +"</ins>" + "</strong>: " + message.getMessage() + "</div>");
			}

			else if (ActiveUsers.get(message.getWhere()).getSessionId().equals(req.getSession().getId()))
			{
				printWriter.println("<div><strong>"+ message.getc() +"<ins>" + message.getAuthor() +"</ins>" + " to you</strong>: " + message.getMessage() + "</div>");
			}

			else if(ActiveUsers.get(message.getAuthor()).getSessionId().equals(req.getSession().getId()))
			{
				printWriter.println("<div><strong>"+ message.getc() +"you typed to " + "<ins>" + message.getWhere() +"</ins>" + "</strong>: " + message.getMessage() + "</div>");
			}


			else if (ActiveUsers.get(message.getWhere()).getSessionId().equals(req.getSession().getId()) && (message.getAuthor().equals("Admin")))
			{
				printWriter.println("<div><strong>"+ message.getc() +"<ins>" +"<font color ='red'>" + message.getAuthor()+"</font>" +"</ins>" + " to you</strong>: " + message.getMessage() + "</div>");
			}

			else if(ActiveUsers.get(message.getAuthor()).getSessionId().equals(req.getSession().getId()) && (message.getAuthor().equals("Admin")))
			{
				printWriter.println("<div><strong>"+ message.getc() +"you typed to " + "<ins>" +"<font color ='red'>" + message.getAuthor()+"</font>" +"</ins>" + "</strong>: " + message.getMessage() + "</div>");
			}


		}
		printWriter.println("</body></html>");

	}

}
