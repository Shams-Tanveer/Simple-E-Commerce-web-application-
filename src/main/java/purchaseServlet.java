import com.modelPackage.LoginCredentials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//This servlet is used for check out button

@WebServlet(name = "purchaseServlet", value = "/purchaseServlet")
public class purchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginCredentials.loginuserCart = 0;
        ShoppingCartModel.shoppingCartList.removeIf(item->item.userID==LoginCredentials.loginuserId);
    }
}
