import com.modelPackage.LoginCredentials;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//This filter allows when only user is logged in

@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    public static int userID = 0;
    public static boolean loginFlag = false;
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(LoginCredentials.loginuserName == null && LoginCredentials.loginPassword == null)
        {
            LoginCredentials.loginuserName = request.getParameter("username");
            LoginCredentials.loginPassword = request.getParameter("password");
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if(LoginCredentials.loginuserName != null && LoginCredentials.loginPassword !=null)
        {

            if(LoginCredentials.loginuserId==0)
            {
                for(UserModel userModel1:UserModel.userList)
                {
                    if(LoginCredentials.loginuserName.equals(userModel1.userName)
                            && LoginCredentials.loginPassword.equals(userModel1.password)
                    )
                    {
                        LoginCredentials.loginuserId = userModel1.userID;
                        for(ShoppingCartModel shoppingCartModel: ShoppingCartModel.shoppingCartList)
                        {
                            if(shoppingCartModel.userID == LoginCredentials.loginuserId)
                            {
                                LoginCredentials.loginuserCart++;
                            }
                        }

                        loginFlag = true;
                        break;
                    }
                }
            }

            if(loginFlag == true)
            {
                chain.doFilter(request, response);
            }
            else
            {
                LoginCredentials.loginuserId = 0;
                LoginCredentials.loginuserName = null;
                LoginCredentials.loginPassword = null;
                out.println("<html><body><script>alert('Login Credential Does not match');" +
                        "window.location.replace('login.html');" +
                        "</script></body></html>");
            }

        }
        else
        {
            out.println("<html><body><script>alert('Please Login First');" +
                    "window.location.replace('login.html');" +
                    "</script></body></html>");
        }
    }
}
