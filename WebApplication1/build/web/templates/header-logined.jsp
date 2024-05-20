<%-- 
    Document   : header-logined.jsp
    Created on : Jan 22, 2024, 1:22:40 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="top-bar">
        <!-- More -->
        <button class="top-bar__more d-none d-lg-block js-toggle" toggle-target="#navbar">
            <img src="./assets/icons/more.svg" alt="" class="icon top-bar__more-icon" />
        </button>

        <!-- Logo -->
        <a href="home" class="logo top-bar__logo">
            <img src="./assets/icons/logo.svg" alt="grocerymart" class="logo__img top-bar__logo-img" />
            <h1 class="logo__title top-bar__logo-title">Chill Store</h1>
        </a>

        <!-- Navbar -->
        <nav id="navbar" class="navbar hide">
            <button class="navbar__close-btn js-toggle" toggle-target="#navbar">
                <img class="icon" src="./assets/icons/arrow-left.svg" alt="" />
            </button>

            <a href="./checkout.html" class="nav-btn d-none d-md-flex">
                <img src="./assets/icons/buy.svg" alt="" class="nav-btn__icon icon" />
                <span class="nav-btn__title">Cart</span>
                <span class="nav-btn__qnt">${cart.getSize()}</span>
            </a>

            <a href="#!" class="nav-btn d-none d-md-flex">
                <img src="./assets/icons/heart.svg" alt="" class="nav-btn__icon icon" />
                <span class="nav-btn__title">Favorite</span>
                <span class="nav-btn__qnt">3</span>
            </a>
        </nav>
        <div class="navbar__overlay js-toggle" toggle-target="#navbar"></div>

        <!-- Actions -->
        <div class="top-act">
            <div class="top-act__group d-md-none top-act__group--single">
                <button class="top-act__btn">
                    <img src="./assets/icons/search.svg" alt="" class="icon top-act__icon" />
                </button>
            </div>

            <div class="top-act__group d-md-none">
                <div class="top-act__btn-wrap">
                    <button class="top-act__btn">
                        <img src="./assets/icons/heart.svg" alt="" class="icon top-act__icon" />
                        <span class="top-act__title">00</span>
                    </button>

                    <!-- Dropdown -->
                    <div class="act-dropdown">
                        <div class="act-dropdown__inner">
                            <img src="./assets/icons/arrow-up.png" alt="" class="act-dropdown__arrow" />
                            <div class="act-dropdown__top">
                                <h2 class="act-dropdown__title">You have ${cart.getSize()} item(s)</h2>
                                <a href="#" class="act-dropdown__view-all">See All</a>
                            </div>
                            <div class="row row-cols-12 gx-2 act-dropdown__list">
                                <!-- Cart preview item 1 -->
                                <div class="col">
                                    <article class="cart-preview-item">
                                        <h3 class="cart-preview-item__title">Feature is being update</h3>

                                    </article>
                                </div>


                            </div>
                            <div class="act-dropdown__separate"></div>
                            <div class="act-dropdown__checkout">
                                <a
                                    href="#"
                                    class="btn btn--primary btn--rounded act-dropdown__checkout-btn"
                                >
                                    Check Out All
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="top-act__separate"></div>

                <div class="top-act__btn-wrap">
                    <button class="top-act__btn">
                        <img src="./assets/icons/buy.svg" alt="" class="icon top-act__icon" />
                        <span class="top-act__title">${customer.getCurrentBalance()}</span>
                    </button>

                    <!-- Dropdown -->
                    <div class="act-dropdown">
                        <div class="act-dropdown__inner">
                            <img src="./assets/icons/arrow-up.png" alt="" class="act-dropdown__arrow" />
                            <div class="act-dropdown__top">
                                <h2 class="act-dropdown__title">You have ${cartInfo.getSize()} item(s)</h2>
                                <a href="./checkout.html" class="act-dropdown__view-all">See All</a>
                            </div>
                            <div class="row row-cols-3 gx-2 act-dropdown__list">
                                <!-- Cart preview item 1 -->
                                <c:forEach var="item" items="${requestScope.cartInfo.getItems()}" end="2">
                                    <div class="col">
                                        <article class="cart-preview-item">
                                            <div class="cart-preview-item__img-wrap">
                                                <img
                                                    src="${item.getProduct().getThumbnailURL()}"
                                                    alt=""
                                                    class="cart-preview-item__thumb"
                                                />
                                            </div>
                                            <h3 class="cart-preview-item__title">${item.getProduct().getProductName()}</h3>
                                            <p class="cart-preview-item__price">${item.getProduct().getPrice()*item.getQuantity()}</p>
                                        </article>
                                    </div>
                                </c:forEach>



                            </div>
                            <div class="act-dropdown__bottom">
                                <div class="act-dropdown__row act-dropdown__row--bold">
                                    <span class="act-dropdown__label">Total Price</span>
                                    <span class="act-dropdown__value">
                                        <fmt:formatNumber value="${requestScope.cartInfo.getTotalPrice()}" pattern="#,##0" var="formattedNumber" />
                                        ${formattedNumber}</span>
                                </div>
                            </div>
                            <div class="act-dropdown__checkout">
                                <a
                                    href="checkout"
                                    class="btn btn--primary btn--rounded act-dropdown__checkout-btn"
                                >
                                    Check Out All
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="top-act__user">
                <img src="${customer.getAvturl()}" alt="" class="top-act__avatar" />

                <!-- Dropdown -->
                <div class="act-dropdown top-act__dropdown">
                    <div class="act-dropdown__inner user-menu">
                        <img
                            src="./assets/icons/arrow-up.png"
                            alt=""
                            class="act-dropdown__arrow top-act__dropdown-arrow"
                        />

                        <div class="user-menu__top">
                            <img src="${customer.getAvturl()}" alt="" class="user-menu__avatar" />
                            <div>
                                <p class="user-menu__name">${customer.getFirstName()} ${customer.getLastName()}</p>
                                <p>@${customer.getUsername()}</p>
                            </div>
                        </div>

                        <ul class="user-menu__list">
                            <li>
                                <a href="profile" class="user-menu__link">Profile</a>
                            </li>
                            <li>
                                <a href="orderhistory" class="user-menu__link">Order History</a>
                            </li>
                            <li class="user-menu__separate">
                                <a href="#!" class="user-menu__link" id="switch-theme-btn">
                                    <span>Dark mode</span>
                                    <img src="./assets/icons/sun.svg" alt="" class="icon user-menu__icon" />
                                </a>
                            </li>
                            <li>
                                <a href="#" class="user-menu__link">Settings</a>
                            </li>
                            <li class="user-menu__separate">
                                <a href="./logout" class="user-menu__link">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

