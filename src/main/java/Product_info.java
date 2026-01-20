import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/product")
public class Product_info extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Product Details</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<center>");
        out.print("<h1>Enter Product Details</h1>");
        out.print("<form action='data'>");
        out.print("Enter Product-ID:<input type='number' name='id'>");
        out.print("<br/><br/>");
        out.print("Enter Product-Name:<input type='text' name='name'>");
        out.print("<br/><br/>");
        out.print("Enter Product-Price:<input type='number' name='price'>");
        out.print("<br/><br/>");
        out.print("Enter Product-Quantity:<input type='number' name='quantity'>");
        out.print("<br/><br/>");
        out.print("<button type='submit'>Submit</button>");
        out.print("</form>");
        out.print("</center>");
        out.print("</body>");
        out.print("</html>");

    }
}
