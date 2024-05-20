<%-- 
    Document   : checkout
    Created on : Jan 22, 2024, 1:05:49 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Checkout | Chill Store</title>

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/favicon/apple-touch-icon.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png" />
    <link rel="manifest" href="./assets/favicon/site.webmanifest" />
    <meta name="msapplication-TileColor" content="#da532c" />
    <meta name="theme-color" content="#ffffff" />

    <!-- Fonts -->
    <link rel="stylesheet" href="./assets/fonts/stylesheet.css" />

    <!-- Styles -->
    <link rel="stylesheet" href="./assets/css/main.css" />

    <!-- Scripts -->
    <script src="./assets/js/scripts.js"></script>
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
        <!-- Search bar -->
        <div class="checkout-container">
            <div class="search-bar d-none d-md-flex">
                <input type="text" name="" id="" placeholder="Search for item" class="search-bar__input" />
                <button class="search-bar__submit">
                    <img src="./assets/icons/search.svg" alt="" class="search-bar__icon icon" />
                </button>
            </div>
        </div>

        <!-- Breadcrumbs -->
        <div class="checkout-container">
            <ul class="breadcrumbs checkout-page__breadcrumbs">
                <li>
                    <a href="./" class="breadcrumbs__link">
                        Home
                        <img src="./assets/icons/arrow-right.svg" alt="" />
                    </a>
                </li>
                <li>
                    <a href="#!" class="breadcrumbs__link breadcrumbs__link--current">Checkout</a>
                </li>
            </ul>
        </div>

        <!-- Checkout content -->
        <div class="checkout-container">
            <div class="row gy-xl-3">
                <div class="col-8 col-xl-12">
                    <div class="cart-info">
                        <div class="cart-info__list">
                            <!-- Cart item 1 -->
                            <c:forEach var="item" items="${requestScope.cartInfo.getItems()}">
                                <article class="cart-item">
                                    <a href="product?action=view&id=${item.getProduct().getProductID()}">
                                        <img
                                                src="${item.getProduct().getThumbnailURL()}"
                                                alt=""
                                                class="cart-item__thumb"
                                        />
                                    </a>
                                    <div class="cart-item__content">
                                        <div class="cart-item__content-left">
                                            <h3 class="cart-item__title">
                                                <a href="product?action=view&id=${item.getProduct().getProductID()}">${item.getProduct().getProductName()}</a>
                                            </h3>
                                            <p class="cart-item__price-wrap"><fmt:formatNumber value=" ${item.getProduct().getPrice()}" pattern="#,##0" var="formattedNumber" />
                                                    ${formattedNumber}
                                                | <span class="cart-item__status">
                                                        ${item.checkAccountInStock(item.getQuantity(),item.getProduct().getProductID()) ? "In Stock" : "Out of Stock"}


                                                </span>
                                            </p>
                                            <div class="cart-item__ctrl cart-item__ctrl--md-block">

                                                <div class="cart-item__input">
                                                    <input type="hidden" value="${item.getProduct().getProductID()}" name="idProduct">
                                                    <button class="cart-item__input-btn cart-item__input-btnminus" >
                                                        <img class="icon" src="./assets/icons/minus.svg" alt=""  />
                                                    </button>
                                                    <span>${item.getQuantity()}</span>
                                                    <button class="cart-item__input-btn cart-item__input-btnplus">
                                                        <img class="icon" src="./assets/icons/plus.svg" alt="" />
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cart-item__content-right">
                                            <p class="cart-item__total-price"><fmt:formatNumber value=" ${item.getProduct().getPrice()*item.getQuantity()}" pattern="#,##0" var="formattedNumber" />
                                                    ${formattedNumber}</p>
                                            <div class="cart-item__ctrl">
                                                <input type="hidden" value="${item.getProduct().getProductID()}" name="idProduct">

                                                <button
                                                        class="cart-item__ctrl-btn"

                                                        id="deleteconfirm-btn"
                                                >
                                                    <img src="./assets/icons/trash.svg" alt="" />
                                                    Delete
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                            </c:forEach>



                        </div>
                        <div class="cart-info__bottom d-md-none">
                            <div class="row">
                                <div class="col-8 col-xxl-7">
                                    <div class="cart-info__continue">
                                        <a href="./" class="cart-info__continue-link">
                                            <img
                                                    class="cart-info__continue-icon icon"
                                                    src="./assets/icons/arrow-down-2.svg"
                                                    alt=""
                                            />
                                            Continue Shopping
                                        </a>
                                    </div>
                                </div>
                                <div class="col-4 col-xxl-5">

                                    <div class="cart-info__separate"></div>
                                    <div class="cart-info__row cart-info__row--bold">
                                        <span>Total:</span>
                                        <span>
                                                    <fmt:formatNumber value="  ${requestScope.cartInfo.getTotalPrice()}" pattern="#,##0" var="formattedNumber" />
                                                            ${formattedNumber}
                                                   </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4 col-xl-12">
                    <div class="cart-info">
                        <div class="cart-info__row">
                            <span>Subtotal <span class="cart-info__sub-label">(items)</span></span>
                            <span>${requestScope.cartInfo.getSize()}</span>
                        </div>
                        <div class="cart-info__row">
                            <span>Price <span class="cart-info__sub-label">(Total)</span></span>
                            <span>
                                        <fmt:formatNumber value="  ${requestScope.cartInfo.getTotalPrice()}" pattern="#,##0" var="formattedNumber" />
                                                            ${formattedNumber}
                                        </span>
                        </div>
                        <h3 style="color: red">${requestScope.error}</h3>
                        <form action="checkout" method="get">
                            <input type="hidden" value="checkout" name="action">
                            <input type="submit" value="Continue to checkout" class="cart-info__next-btn btn btn--primary btn--rounded">
                        </form>
                    </div>
                    <div class="cart-info">
                        <a href="#!">
                            <article class="gift-item">
                                <div class="gift-item__icon-wrap">
                                    <img src="./assets/icons/gift.svg" alt="" class="gift-item__icon" />
                                </div>
                                <div class="gift-item__content">
                                    <h3 class="gift-item__title">Send this order as a gift.</h3>
                                    <p class="gift-item__desc">
                                        Available items will be shipped to your gift recipient.
                                    </p>
                                </div>
                            </article>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<!-- Footer -->
<footer id="footer" class="footer"></footer>
<script>
    load("#footer", "./templates/footer.jsp");
</script>
<script>
    //delete item from cart
    document.addEventListener("DOMContentLoaded", function() {
        var deleteButtons = document.querySelectorAll('.cart-item__ctrl-btn');

        deleteButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                var idProduct = button.parentElement.parentElement.querySelector('input[name="idProduct"]').value;
                var url = "checkout?action=remove&id=" + idProduct;
                var xhr = new XMLHttpRequest();
                xhr.open("GET", url, true);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        location.reload();
                    }
                };
                xhr.send();
            });
        })
    });
    //decrease quantity and increase quantity
    document.addEventListener("DOMContentLoaded", function() {
        var decreaseButtons = document.querySelectorAll('.cart-item__input-btnminus');
        var increaseButtons = document.querySelectorAll('.cart-item__input-btnplus');

        decreaseButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                var idProduct = button.parentElement.parentElement.parentElement.querySelector('input[name="idProduct"]').value;
                var quantity = button.parentElement.querySelector('span').textContent;
                var url = "checkout?action=plus&id=" + idProduct + "&quantity=" + quantity;
                var xhr = new XMLHttpRequest();
                xhr.open("GET", url, true);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        location.reload();
                    }
                };
                xhr.send();
            });
        });

        increaseButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                var idProduct = button.parentElement.parentElement.parentElement.querySelector('input[name="idProduct"]').value;
                var quantity = button.parentElement.querySelector('span').textContent;
                var url = "checkout?action=minus&id=" + idProduct + "&quantity=" + quantity;
                var xhr = new XMLHttpRequest();
                xhr.open("GET", url, true);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        location.reload();
                    }
                };
                xhr.send();
            });
        });
    });
</script>

<!-- Modal: confirm remove shopping cart item -->
<%--        <div id="delete-confirm" class="modal modal--small hide">--%>
<%--            <div class="modal__content">--%>
<%--                <p class="modal__text">Do you want to remove this item from shopping cart?</p>--%>
<%--                <div class="modal__bottom">--%>
<%--                    <button class="btn btn--small btn--outline modal__btn js-toggle" toggle-target="#delete-confirm">--%>
<%--                        Cancel--%>
<%--                    </button>--%>
<%--                    <button--%>
<%--                        class="btn btn--small btn--danger btn--primary modal__btn btn--no-margin js-toggle"--%>
<%--                        toggle-target="#delete-confirm"--%>
<%--                    >--%>
<%--                        Delete--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="modal__overlay js-toggle" toggle-target="#delete-confirm"></div>--%>
<%--        </div>--%>
</body>
</html>
