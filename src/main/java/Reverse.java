import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reverse")
public class Reverse extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
    private String text = "abcd";
    
    public static void main(String[] args) {
    	Reverse reverseClass = new Reverse();
    	System.out.println(reverseClass.process(reverseClass.text));
    }
    
	 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		 String input = request.getParameter("text");
		 String output = process(input);
    	
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(output);
		
		out.close();
    }
	 
	private String process(String text) {
		return new StringBuilder(text).reverse().toString();
	}
}
