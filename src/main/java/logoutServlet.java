import com.modelPackage.LoginCredentials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//This servlet is used for log out

@WebServlet(name = "logoutServlet", value = "/logoutServlet")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginCredentials.loginuserCart = 0;
        LoginCredentials.loginuserId = 0;
        LoginCredentials.loginuserName = null;
        LoginCredentials.loginPassword = null;
        response.sendRedirect("login.html");
        loginFilter.loginFlag = false;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
