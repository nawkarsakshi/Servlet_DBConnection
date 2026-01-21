import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.lang.String;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/data")
public class Product_savings extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String i = req.getParameter("id");
        String n = req.getParameter("name");
        String p = req.getParameter("price");
        String q = req.getParameter("quantity");
        int count=0;
        
        String query = "INSERT into products Values(?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakshidb1", "root", "1004");
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,i);
            stmt.setString(2,n);
            stmt.setString(3, p);
            stmt.setString(4,q);
            count = stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(count>0)
        {
            out.print("<h1>Data Inserted Successfully</h1>");
        }else{
            out.print("<h1>Oop's something went wrong try again later</h1>");
        }
    }
}
