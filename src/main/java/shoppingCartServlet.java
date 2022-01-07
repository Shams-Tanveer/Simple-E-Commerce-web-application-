import com.modelPackage.LoginCredentials;
import com.modelPackage.ProductListModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//This servlet is used to update shopping cart. If one item is added the quantity is updated by 1 otherwise item is added to the cart

@WebServlet(name = "shoppingCartServlet", value = "/shoppingCartServlet")
public class shoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean alreadyAdded = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ShoppingCartModel shoppingCartModel = null;
        ProductListModel productListModel1 = new ProductListModel();

            for(ShoppingCartModel shoppingCartModel1: ShoppingCartModel.shoppingCartList)
            {
                if(shoppingCartModel1.productID==id && shoppingCartModel1.userID==LoginCredentials.loginuserId)
                {
                    shoppingCartModel1.productQuantity += 1;
                    alreadyAdded = true;
                    break;
                }
            }

        if(!alreadyAdded) {
            LoginCredentials.loginuserCart++;
            for(ProductListModel productListmodel: productListModel1.productLists )
            {

                if(productListmodel.productID == id)
                {
                    shoppingCartModel = new ShoppingCartModel(productListmodel.productID, LoginCredentials.loginuserId, productListmodel.productName,productListmodel.productPrice,1,productListmodel.imageSrc);
                    break;
                }
            }
            ShoppingCartModel.shoppingCartList.add(shoppingCartModel);
        }
    }
}
