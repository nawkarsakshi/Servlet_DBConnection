import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

@WebServlet("/viewdata")
public class Product_view extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshidb1", "root", "1004");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from products");

            out.println("<center><table border=1>");
            out.println("<thead>");
            out.println("<th>Product_ID</th>");
            out.println("<th>Product_Name</th>");
            out.println("<th>Product_Price</th>");
            out.println("<th>Product_Quantity</th>");
            out.println("</thead>");

            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");


                out.println("<td>" + rs.getString(2)+ "</td>");


                out.println("<td>" + rs.getInt(3) + "</td>");


                out.println("<td>" + rs.getInt(4) + "</td>");
                out.println("</tr>");
            }

            out.println("</table></center>");
            rs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
