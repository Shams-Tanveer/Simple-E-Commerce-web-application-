<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 1/6/2022
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.modelPackage.LoginCredentials"%>
<%@ page import="com.modelPackage.ProductListModel"%>
<%! int i=0;%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class=container">
    <h1>Available Product</h1>
    <div class="mx-3 d-flex flex-row bd-highlight mb-3 position-absolute top-0 end-0">
        <a href="logoutServlet" class="mx-2 text-decoration-none">Log Out</a>
        <a  href="showCartServlet" class="mx-2 text-decoration-none" id="cart">Shopping Cart</a>
        <p id="shoppingcartValue" class="mx-2"><%=LoginCredentials.loginuserCart%></p>
    </div>

    <div class="d-flex flex-row bd-highlight mb-3">
        <% for(i=0;i<ProductListModel.productLists.size();i++){%>
        <div class="p-2 bd-highlight">
            <div class="product-top">
                <img src="<%=ProductListModel.productLists.get(i).imageSrc%>" width="225px" height="225px">
            </div>
            <div class="product-bottom text-center">
                <h3><%=ProductListModel.productLists.get(i).productName%></h3>
                <h5><%=ProductListModel.productLists.get(i).productPrice%> Taka</h5>
                <button id="<%=ProductListModel.productLists.get(i).productID%>" onclick='buyProduct(this.id)' type="button" class="btn btn-secondary">Buy Now</button>
            </div>
        </div>
        <%}%>
    </div>
</div>

<script>
    function buyProduct(clickedID) {
        var xhttp = new XMLHttpRequest();
        var parameter;
        var value = document.getElementById("shoppingcartValue").innerHTML;
        value++;
        document.getElementById("shoppingcartValue").innerHTML = value;
        parameter ="id=".concat(clickedID);
        xhttp.open("POST","shoppingCartServlet",true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send(parameter);
        window.location.reload();

    }


</script>
</body>
</html>
