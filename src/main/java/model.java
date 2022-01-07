import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//These two class define the User model and Shopping cart Model and some hardcoded value

class UserModel{
    int userID;
    String userName;
    String password;
    public static List<UserModel> userList = Arrays.asList(
            new UserModel(1,"Jim","1234"),
            new UserModel(2,"Shams","12345"),
            new UserModel(3,"Tanveer","124"),
            new UserModel(4,"Jonathon","12340")
    );

    public UserModel(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    public UserModel(){}
}



class ShoppingCartModel {
    int productID;
    int userID;
    String productName;
    double productPrice;
    int productQuantity;
    String imageSrc;
    public static List<ShoppingCartModel> shoppingCartList = new ArrayList<ShoppingCartModel>();

    public ShoppingCartModel() {
    }
    public ShoppingCartModel(int productID, int userID, String productName, double productPrice, int productQuantity,String imageSrc) {
        this.productID = productID;
        this.userID = userID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.imageSrc = imageSrc;
    }
}




