<%-- 
    Document   : order-history
    Created on : Mar 2, 2024, 5:42:29 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Order History | Chill Store</title>

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/favicon/apple-touch-icon.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png" />
    <link rel="manifest" href="./assets/favicon/site.webmanifest" />
    <meta name="msapplication-TileColor" content="#da532c" />
    <meta name="theme-color" content="#ffffff" />

    <!-- Fonts -->


    <!-- Styles -->


    <link rel="stylesheet" href="./assets/css/main.css" />
    <link rel="stylesheet" href="./assets/fonts/stylesheet.css" />
    <!-- Scripts -->
    <script src="./assets/js/scripts.js"></script>
    <style>
        table{
            margin-top: 90px;
        }
        td{
            align-items: center;
            text-align: center;
            height: 100px;
            vertical-align:middle;
        }
        button{
            margin: 0 auto;
        }
    </style>
</head>
<body>
<!-- Header -->
<header id="header" class="header"></header>
<script>
    load("#header", "cart");
</script>

<!-- MAIN -->
<main class="checkout-page">
    <div class="container">
        <!-- breadcrumbs -->
        <div class="checkout-container">
            <ul class="breadcrumbs checkout-page__breadcrumbs">
                <li>
                    <a href="#" class="breadcrumbs__link">
                        Home
                        <img src="./assets/icons/arrow-right.svg" alt="" />
                    </a>
                </li>
                <li>
                    <a href="#!" class="breadcrumbs__link breadcrumbs__link--current">Order History</a>
                </li>
            </ul>

        </div>

        <!-- order details -->
        <div class="checkout-container">
            <div class="row gy-xl-3">
                <div class="col-12">
                    <div class="cart-info">
                        <h1 class="cart-info__heading">Order List</h1>
                        <p class="cart-info__desc">${requestScope.listOrderHistory.size()}</p>
                        <div class="cart-info__list">
                            <div class="col-12">
                                <div class="col-12">
                                    <div class="table-responsive p-3 col-12">
                                        <table class="col-12" id="dataTable">
                                            <thead class="thead-light">
                                            <tr>
                                                <th>ID Order</th>
                                                <th>Date</th>
                                                <th>Status</th>
                                                <th>Total Price</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>

                                            <tbody class="col-12" style="align-items: center;">
                                            <c:forEach items="${requestScope.listOrderHistory}" var="order">
                                                <tr>
                                                    <td>${order.getOrder().getOrderID()}</td>
                                                    <td>${order.getUpdateDate().toString()}</td>
                                                    <c:choose>
                                                        <c:when test="${order.getOrderStatus() == \"Paid\"}">
                                                            <td style="color: green;">${order.getOrderStatus()}</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td style="color: red;">${order.getOrderStatus()}</td>
                                                        </c:otherwise>
                                                    </c:choose>


                                                    <td>${order.getOrder().getTotal()}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${order.getOrderStatus() == \"Paid\"}">
                                                                <button class="active1 btn btn--rounded" style="background-color:green;color: white" onclick="ViewProduct(${order.getOrder().getOrderID()})">View</button>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <button class="active2 btn btn--rounded" style="background-color:red;color: white" onclick="PayOrder(${order.getOrder().getOrderID()})">Pay</button>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>

</main>
<footer id="footer" class="footer"></footer>
<script>
    load("#footer", "./templates/footer.jsp");
</script>
<script>
    function ViewProduct(id){
        window.location.href = "orderdetail?id="+id;
    }
    function PayOrder(id){
        window.location.href = "payment?action=pay&orderID="+id;
    }
</script>
</body>
