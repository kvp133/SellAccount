<%-- 
    Document   : payment
    Created on : Jan 22, 2024, 1:11:37 PM
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
    <title>Payment | Chill Store</title>

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
                    <a href="./checkout.html" class="breadcrumbs__link">
                        Checkout
                        <img src="./assets/icons/arrow-right.svg" alt="" />
                    </a>
                </li>

                <li>
                    <a href="#!" class="breadcrumbs__link breadcrumbs__link--current">Payment method</a>
                </li>
            </ul>
        </div>

        <!-- Checkout content -->
        <div class="checkout-container">
            <div class="row gy-xl-3">
                <div class="col-8 col-xl-8 col-lg-12">

                    <div class="cart-info">
                        <h2 class="cart-info__heading cart-info__heading--lv2">1. Payment method</h2>
                        <div class="cart-info__separate"></div>
                        <h3 class="cart-info__sub-heading">Availible Payment method</h3>

                        <!-- Payment item 3 -->
                        <label>
                            <article class="payment-item payment-item--pointer">
                                <img
                                        src="./assets/img/payment/delivery-1.png"
                                        alt=""
                                        class="payment-item__thumb"
                                />
                                <div class="payment-item__content">
                                    <div class="payment-item__info">
                                        <h3 class="payment-item__title">Payment By Coin</h3>
                                        <p class="payment-item__desc payment-item__desc--low">
                                            Will minus your account
                                        </p>
                                    </div>

                                    <span class="cart-info__checkbox payment-item__checkbox">
                                                <input
                                                        type="radio"
                                                        name="delivery-method"
                                                        checked
                                                        class="cart-info__checkbox-input payment-item__checkbox-input"
                                                />
                                                <span class="payment-item__cost">Free Fee</span>
                                            </span>
                                </div>
                            </article>
                        </label>

                        <!-- Payment item 4 -->

                    </div>
                </div>
                <div class="col-4 col-xl-4 col-lg-12">
                    <div class="cart-info">
                        <h2 class="cart-info__heading cart-info__heading--lv2">Payment Details</h2>
                        <p class="cart-info__desc">
                            Complete your purchase item by providing your payment details order.
                        </p>

                        <div class="cart-info__row">
                            <span>Subtotal <span class="cart-info__sub-label">(items)</span></span>
                            <span>${requestScope.subItem}</span>
                        </div>
                        <div class="cart-info__row">
                            <span>Price <span class="cart-info__sub-label">(Total)</span></span>
                            <span>
                                <fmt:formatNumber value="${requestScope.totalPrice}" pattern="#,##0" var="formattedNumber" />
                                                          ${formattedNumber}
                               đ</span>
                        </div>

                        <div class="cart-info__separate"></div>
                        <div class="cart-info__row">
                            <span>Estimated Total</span>
                            <span><fmt:formatNumber value="   ${requestScope.totalPrice}" pattern="#,##0" var="formattedNumber" />
                                                            ${formattedNumber}đ</span>
                        </div>
                        <p style="color: red">${requestScope.message}</p>
                        <a href="payment?action=pay&orderID=${requestScope.orderID}" class="cart-info__next-btn btn btn--primary btn--rounded">Pay <fmt:formatNumber value="   ${requestScope.totalPrice}" pattern="#,##0" var="formattedNumber" />
                            ${formattedNumber}</a>
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

<!-- Modal: confirm remove shopping cart item -->
<div id="delete-confirm" class="modal modal--small hide">
    <div class="modal__content">
        <p class="modal__text">Do you want to remove this item from shopping cart?</p>
        <div class="modal__bottom">
            <button class="btn btn--small btn--outline modal__btn js-toggle" toggle-target="#delete-confirm">
                Cancel
            </button>
            <button
                    class="btn btn--small btn--danger btn--primary modal__btn btn--no-margin js-toggle"
                    toggle-target="#delete-confirm"
            >
                Delete
            </button>
        </div>
    </div>
    <div class="modal__overlay js-toggle" toggle-target="#delete-confirm"></div>
</div>

<!-- Modal: address new shipping address -->

</body>
</html>

