<%-- 
    Document   : edit-personal-info
    Created on : Jan 22, 2024, 1:07:03 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit personal info | Grocery Mart</title>

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
                <div class="col-9 col-xl-8 col-lg-12">
                    <div class="cart-info">
                        <div class="row gy-3">
                            <div class="col-12">
                                <h2 class="cart-info__heading">
                                    <a href="./profile.html">
                                        <img
                                                src="./assets/icons/arrow-left.svg"
                                                alt=""
                                                class="icon cart-info__back-arrow"
                                        />
                                    </a>
                                    Change password
                                </h2>

                                <form action="changepassword" class="form form-card" method="post">
                                    <!-- Form row 1 -->
                                    <div class="form__row">
                                        <div class="form__group">
                                            <label for="oldpassword" class="form__label form-card__label">
                                                Old password
                                            </label>
                                            <div class="form__text-input">
                                                <input
                                                        type="password"
                                                        name="oldpassword"
                                                        id="oldpassword"
                                                        placeholder="Enter your old password"
                                                        class="form__input"
                                                        required
                                                        autofocus
                                                />
                                                <img
                                                        src="./assets/icons/form-error.svg"
                                                        alt=""
                                                        class="form__input-icon-error"
                                                />
                                            </div>
                                            <p class="form__error">Please enter your old password</p>
                                        </div>
                                    </div>
                                    <div class="form__row">
                                        <div class="form__group">
                                            <label for="newpassword" class="form__label form-card__label">
                                                New password
                                            </label>
                                            <div class="form__text-input">
                                                <input
                                                        type="password"
                                                        name="newpassword"
                                                        id="newpassword"
                                                        placeholder="Enter your new password"
                                                        class="form__input"
                                                        required
                                                        autofocus
                                                />
                                                <img
                                                        src="./assets/icons/form-error.svg"
                                                        alt=""
                                                        class="form__input-icon-error"
                                                />
                                            </div>
                                            <p class="form__error">Please enter your new password</p>
                                        </div>
                                                                            </div>
                                    <div class="form__row">
                                        <div class="form__group">
                                            <label for="confirmpassword" class="form__label form-card__label">
                                                New password
                                            </label>
                                            <div class="form__text-input">
                                                <input
                                                        type="password"
                                                        name="confirmpassword"
                                                        id="confirmpassword"
                                                        placeholder="Enter your new password again"
                                                        class="form__input"
                                                        required
                                                        autofocus
                                                />
                                                <img
                                                        src="./assets/icons/form-error.svg"
                                                        alt=""
                                                        class="form__input-icon-error"
                                                />
                                            </div>
                                            <p class="form__error">Please enter your new password</p>
                                        </div>

                                    </div>

                                    <!-- Form row 2 -->

                                    <p style="color: red">${requestScope.error}</p>
                                    <div class="form-card__bottom">
                                        <a class="btn btn--text" href="profile">Cancel</a>
                                        <input value="Submit" type="submit" class="btn btn--primary btn--rounded">
                                    </div>
                                </form>
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

