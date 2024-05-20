<%-- 
    Document   : profile
    Created on : Jan 22, 2024, 1:13:04 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Profile | Chill Store</title>

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
    load("#header", "./templates/header-logined.jsp");
</script>

<!-- MAIN -->
<main class="profile">
    <div class="container">
        <!-- Search bar -->
        <div class="profile-container">
            <div class="search-bar d-none d-md-flex">
                <input type="text" name="" id="" placeholder="Search for item" class="search-bar__input" />
                <button class="search-bar__submit">
                    <img src="./assets/icons/search.svg" alt="" class="search-bar__icon icon" />
                </button>
            </div>
        </div>

        <!-- Profile content -->
        <div class="profile-container">
            <div class="row gy-md-3">
                <div class="col-3 col-xl-4 col-lg-5 col-md-12">
                    <aside class="profile__sidebar">
                        <!-- User -->
                        <div class="profile-user">
                            <img src="${customer.getAvturl()}" alt="" class="profile-user__avatar" />
                            <h1 class="profile-user__name">${customer.getFirstName()} ${customer.getLastName()}</h1>
                            <p class="profile-user__desc">Member</p>
                        </div>

                        <!-- Menu 1 -->
                        <div class="profile-menu">
                            <h3 class="profile-menu__title">Manage Account</h3>
                            <ul class="profile-menu__list">
                                <li>
                                    <a href="editpersonalinfo" class="profile-menu__link">
                                                <span class="profile-menu__icon">
                                                    <img src="./assets/icons/profile.svg" alt="" class="icon" />
                                                </span>
                                        Personal info
                                    </a>
                                </li>
                                <li>
                                    <a href="changepassword" class="profile-menu__link">
                                                <span class="profile-menu__icon">
                                                    <img src="./assets/icons/location.svg" alt="" class="icon" />
                                                </span>
                                        Change Password
                                    </a>
                                </li>

                            </ul>
                        </div>


                        <!-- Menu 3 -->
                        <div class="profile-menu">
                            <h3 class="profile-menu__title">Subscriptions & plans</h3>
                            <ul class="profile-menu__list">
                                <li>
                                    <a href="#!" class="profile-menu__link">
                                                <span class="profile-menu__icon">
                                                    <img src="./assets/icons/shield.svg" alt="" class="icon" />
                                                </span>
                                        Protection plans
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <!-- Menu 4 -->
                        <div class="profile-menu">
                            <h3 class="profile-menu__title">Customer Service</h3>
                            <ul class="profile-menu__list">
                                <li>
                                    <a href="#!" class="profile-menu__link">
                                                <span class="profile-menu__icon">
                                                    <img src="./assets/icons/info.svg" alt="" class="icon" />
                                                </span>
                                        Help
                                    </a>
                                </li>
                                <li>
                                    <a href="#!" class="profile-menu__link">
                                                <span class="profile-menu__icon">
                                                    <img src="./assets/icons/danger.svg" alt="" class="icon" />
                                                </span>
                                        Terms of Use
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </aside>
                </div>
                <div class="col-9 col-xl-8 col-lg-7 col-md-12">
                    <div class="cart-info">
                        <div class="row gy-3">
                            <!-- My Wallet -->
                            <div class="col-12">
                                <h2 class="cart-info__heading">My Wallet</h2>
                                <p class="cart-info__desc profile__desc">Payment methods</p>

                                <div class="row gy-md-2 row-cols-3 row-cols-xl-2 row-cols-lg-1">
                                    <!-- Payment card 1 -->
                                    <div class="col">
                                        <article class="payment-card" style="--bg-color: #1e2e69">
                                            <img
                                                    src="./assets/img/card/plane-bg.svg"
                                                    alt=""
                                                    class="payment-card__img"
                                            />
                                            <div class="payment-card__top">
                                                <img src="./assets/img/card/plane.svg" alt="" />
                                                <span class="payment-card__type">FeatherCard</span>
                                            </div>
                                            <div class="payment-card__number">1234 4567 8901 2221</div>
                                            <div class="payment-card__bottom">
                                                <div>
                                                    <p class="payment-card__label">Card Holder</p>
                                                    <p class="payment-card__value">Imran Khan</p>
                                                </div>
                                                <div class="payment-card__expired">
                                                    <p class="payment-card__label">Expired</p>
                                                    <p class="payment-card__value">10/22</p>
                                                </div>
                                                <div class="payment-card__circle"></div>
                                            </div>
                                        </article>
                                    </div>

                                    <!-- Payment card 2 -->
                                    <div class="col">
                                        <article class="payment-card" style="--bg-color: #354151">
                                            <img
                                                    src="./assets/img/card/leaf-bg.svg"
                                                    alt=""
                                                    class="payment-card__img"
                                            />
                                            <div class="payment-card__top">
                                                <img src="./assets/img/card/leaf.svg" alt="" />
                                                <span class="payment-card__type">FeatherCard</span>
                                            </div>
                                            <div class="payment-card__number">1234 4567 2221 8901</div>
                                            <div class="payment-card__bottom">
                                                <div>
                                                    <p class="payment-card__label">Card Holder</p>
                                                    <p class="payment-card__value">Imran Khan</p>
                                                </div>
                                                <div class="payment-card__expired">
                                                    <p class="payment-card__label">Expired</p>
                                                    <p class="payment-card__value">11/22</p>
                                                </div>
                                                <div class="payment-card__circle"></div>
                                            </div>
                                        </article>
                                    </div>

                                    <!-- Add new payment card -->
                                    <div class="col">
                                        <a class="new-card" href="#">
                                            <img
                                                    src="./assets/icons/plus.svg"
                                                    alt=""
                                                    class="new-card__icon icon"
                                            />
                                            <p class="new-card__text">Feature is updating</p>
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <!-- Account info -->
                            <div class="col-12">
                                <h2 class="cart-info__heading">Account info</h2>
                                <p class="cart-info__desc profile__desc">
                                    Addresses, contact information and password
                                </p>
                                <div class="row gy-md-2 row-cols-2 row-cols-lg-1">
                                    <!-- Account info 1 -->
                                    <div class="col">
                                        <a href="./edit-personal-info.html">
                                            <article class="account-info">
                                                <div class="account-info__icon">
                                                    <img src="./assets/icons/message.svg" alt="" class="icon" />
                                                </div>
                                                <div>
                                                    <h3 class="account-info__title">Email Address</h3>
                                                    <p class="account-info__desc">${customer.getEmail()}</p>
                                                </div>
                                            </article>
                                        </a>
                                    </div>

                                    <!-- Account info 2 -->
                                    <div class="col">
                                        <a href="./edit-personal-info.html">
                                            <article class="account-info">
                                                <div class="account-info__icon">
                                                    <img src="./assets/icons/calling.svg" alt="" class="icon" />
                                                </div>
                                                <div>
                                                    <h3 class="account-info__title">Balance</h3>
                                                    <p class="account-info__desc">${customer.getCurrentBalance()}</p>
                                                </div>
                                            </article>
                                        </a>
                                    </div>

                                    <!-- Account info 3 -->

                                </div>
                            </div>


                        </div>
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
</body>
</html>
