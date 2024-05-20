<%-- 
    Document   : product-detail
    Created on : Jan 22, 2024, 1:12:46 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Chill Store</title>

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
<main class="product-page">
    <div class="container">
        <!-- Search bar -->
        <div class="product-container">
            <div class="search-bar d-none d-md-flex">
                <input type="text" name="" id="" placeholder="Search for item" class="search-bar__input" />
                <button class="search-bar__submit">
                    <img src="./assets/icons/search.svg" alt="" class="search-bar__icon icon" />
                </button>
            </div>
        </div>


        <!-- Product info -->
        <div class="product-container prod-info-content">
            <div class="row">
                <div class="col-5 col-xl-6 col-lg-12">
                    <div class="prod-preview">
                        <div class="prod-preview__list">
                            <div class="prod-preview__item">
                                <img src="${requestScope.p.getThumbnailURL()}" alt="" class="prod-preview__img" />
                            </div>
                            <div class="prod-preview__item">
                                <img src="./assets/img/product/item-2.png" alt="" class="prod-preview__img" />
                            </div>
                            <div class="prod-preview__item">
                                <img src="./assets/img/product/item-3.png" alt="" class="prod-preview__img" />
                            </div>
                            <div class="prod-preview__item">
                                <img src="./assets/img/product/item-4.png" alt="" class="prod-preview__img" />
                            </div>
                        </div>
                        <div class="prod-preview__thumbs">
                            <img
                                    src="${requestScope.p.getThumbnailURL()}"
                                    alt=""
                                    class="prod-preview__thumb-img prod-preview__thumb-img--current"
                            />
                            <img src="./assets/img/product/item-2.png" alt="" class="prod-preview__thumb-img" />
                            <img src="./assets/img/product/item-3.png" alt="" class="prod-preview__thumb-img" />
                            <img src="./assets/img/product/item-4.png" alt="" class="prod-preview__thumb-img" />
                        </div>
                    </div>
                </div>

                <div class="col-7 col-xl-6 col-lg-12">
                    <form action="product" class="form" method="get">
                        <section class="prod-info">
                            <h1 class="prod-info__heading">
                                ${p.getProductName()}
                            </h1>
                            <div class="row">
                                <div class="col-5 col-xxl-6 col-xl-12">
                                    <div class="prod-prop">
                                        <img src="./assets/icons/star.svg" alt="" class="prod-prop__icon" />
                                        <h4 class="prod-prop__title">(3.5) 1100 reviews</h4>
                                    </div>
                                    <label for="quantity_number" class="form__label prod-info__label">Số lượng</label>
                                    <div class="filter__form-group">
                                        <div class="form__select-wrap">
                                            <input id="quantity_number" type="text" class="form__select" style="--width: 146px" name="quantity">
                                            <input type="hidden" name="idCustomer" value="${p.getProductID()}">
                                            <input type="hidden" name="action" value="add">

                                        </div>
                                    </div>



                                </div>
                                <div class="col-7 col-xxl-6 col-xl-12">
                                    <div class="prod-props">
                                        <div class="prod-info__card">
                                            <p class="prod-info__total-price">${p.getPrice()}đ</p>
                                            <div class="prod-info__row">
                                                <button class="btn btn--primary prod-info__add-to-cart">
                                                    Add to cart
                                                </button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </form>
                </div>
            </div>
        </div>

        <!-- Product content -->
        <div class="product-container">
            <div class="prod-tab js-tabs">
                <ul class="prod-tab__list">
                    <li class="prod-tab__item prod-tab__item--current">Description</li>
                    <li class="prod-tab__item">Review (1100)</li>
                    <li class="prod-tab__item">Similar</li>
                </ul>
                <div class="prod-tab__contents">
                    <div class="prod-tab__content prod-tab__content--current">
                        <div class="row">
                            <div class="col-8 col-xl-10 col-lg-12">
                                <div class="text-content prod-tab__text-content">
                                    <h2>Lưu ý sử dụng</h2>
                                    <p>${p.getDescription()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="prod-tab__content">
                        <div class="prod-content">
                            <h2 class="prod-content__heading">What our customers are saying</h2>
                            <div class="row row-cols-3 gx-lg-2 row-cols-md-1 gy-md-3">
                                <!-- Review card 1 -->
                                <div class="col">
                                    <div class="review-card">
                                        <div class="review-card__content">
                                            <img
                                                    src="./assets/img/avatar/avatar-1.png"
                                                    alt=""
                                                    class="review-card__avatar"
                                            />
                                            <div class="review-card__info">
                                                <h4 class="review-card__title">Jakir Hussen</h4>
                                                <p class="review-card__desc">
                                                    Great product, I love this Coffee Beans
                                                </p>
                                            </div>
                                        </div>
                                        <div class="review-card__rating">
                                            <div class="review-card__star-list">
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-half.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-blank.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                            </div>
                                            <span class="review-card__rating-title">(3.5) Review</span>
                                        </div>
                                    </div>
                                </div>

                                <!-- Review card 2 -->
                                <div class="col">
                                    <div class="review-card">
                                        <div class="review-card__content">
                                            <img
                                                    src="./assets/img/avatar/avatar-2.png"
                                                    alt=""
                                                    class="review-card__avatar"
                                            />
                                            <div class="review-card__info">
                                                <h4 class="review-card__title">Jubed Ahmed</h4>
                                                <p class="review-card__desc">
                                                    Awesome Coffee, I love this Coffee Beans
                                                </p>
                                            </div>
                                        </div>
                                        <div class="review-card__rating">
                                            <div class="review-card__star-list">
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-half.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-blank.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                            </div>
                                            <span class="review-card__rating-title">(3.5) Review</span>
                                        </div>
                                    </div>
                                </div>

                                <!-- Review card 3 -->
                                <div class="col">
                                    <div class="review-card">
                                        <div class="review-card__content">
                                            <img
                                                    src="./assets/img/avatar/avatar-3.png"
                                                    alt=""
                                                    class="review-card__avatar"
                                            />
                                            <div class="review-card__info">
                                                <h4 class="review-card__title">Delwar Hussain</h4>
                                                <p class="review-card__desc">
                                                    Great product, I like this Coffee Beans
                                                </p>
                                            </div>
                                        </div>
                                        <div class="review-card__rating">
                                            <div class="review-card__star-list">
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-half.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                                <img
                                                        src="./assets/icons/star-blank.svg"
                                                        alt=""
                                                        class="review-card__star"
                                                />
                                            </div>
                                            <span class="review-card__rating-title">(3.5) Review</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="prod-tab__content">
                        <div class="prod-content">
                            <h2 class="prod-content__heading">Similar items you might like</h2>
                            <div
                                    class="row row-cols-6 row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-1 g-2"
                            >
                                <!-- Product card 1 -->
                                <c:forEach var="p" items="${requestScope.listProduct}">
                                <div class="col">
                                    <article class="product-card">
                                        <div class="product-card__img-wrap">
                                            <a href="product?id=${sessionScope.customer != null ? p.getProductID() : 'home'}">
                                                <img
                                                        src="${p.getThumbnailURL()}"
                                                        alt=""
                                                        class="product-card__thumb"
                                                />
                                            </a>
                                            <button class="like-btn product-card__like-btn">
                                                <img
                                                        src="./assets/icons/heart.svg"
                                                        alt=""
                                                        class="like-btn__icon icon"
                                                />
                                                <img
                                                        src="./assets/icons/heart-red.svg"
                                                        alt=""
                                                        class="like-btn__icon--liked"
                                                />
                                            </button>
                                        </div>
                                        <h3 class="product-card__title">
                                            <a href="product?id=${sessionScope.customer != null ? p.getProductID() : 'home'}"
                                            >${p.getProductName()}</a
                                            >
                                        </h3>
                                        <p class="product-card__brand">${p.getProductType().getTypeName()}</p>
                                        <div class="product-card__row">
                                            <span class="product-card__price">${p.getPrice()}</span>đ
                                            <img
                                                    src="./assets/icons/star.svg"
                                                    alt=""
                                                    class="product-card__star"
                                            />
                                            <span class="product-card__score">4.9</span>
                                        </div>
                                        </c:forEach>
                                    </article>
                                </div>


                                </article>
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
</body>
</html>

