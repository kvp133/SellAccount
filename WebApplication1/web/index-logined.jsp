<%-- 
    Document   : index-logined
    Created on : Jan 22, 2024, 1:08:44 PM
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
            load("#header", "./templates/header-logined.jsp");
        </script>

        <!-- MAIN -->
        <main class="container home">
            <!-- Slideshow -->
            <div class="home__container">
                <div class="slideshow">
                    <div class="slideshow__inner">
                        <div class="slideshow__item">
                            <a href="#!" class="slideshow__link">
                                <picture>
                                    <source
                                        media="(max-width: 767.98px)"
                                        srcset="./assets/img/slideshow/item-1-md.png"
                                    />
                                    <img src="./assets/img/slideshow/item-1.png" alt="" class="slideshow__img" />
                                </picture>
                            </a>
                        </div>
                    </div>

                    <div class="slideshow__page">
                        <span class="slideshow__num">1</span>
                        <span class="slideshow__slider"></span>
                        <span class="slideshow__num">5</span>
                    </div>
                </div>
            </div>

            <!-- Browse Categories -->
            <section class="home__container">
                <div class="home__row">
                    <h2 class="home__heading">Browse Categories</h2>
                </div>
                <div class="home__cate row row-cols-3 row-cols-md-1">
                    <!-- Category item 1 -->
                    <div class="col">
                        <a href="#!">
                            <article class="cate-item">
                                <img src="./assets/img/category-item/item-1.png" alt="" class="cate-item__thumb" />
                                <div class="cate-item__info">
                                    <h3 class="cate-item__title">Netflix</h3>
                                    <p class="cate-item__desc">Chất lượng 4K giá siêu ưu đãi</p>
                                </div>
                            </article>
                        </a>
                    </div>

                    <!-- Category item 2 -->
                    <div class="col">
                        <a href="#!">
                            <article class="cate-item">
                                <img src="./assets/img/category-item/item-2.png" alt="" class="cate-item__thumb" />
                                <div class="cate-item__info">
                                    <h3 class="cate-item__title">Youtube</h3>
                                    <p class="cate-item__desc">Gói Premium không quảng cáo</p>
                                </div>
                            </article>
                        </a>
                    </div>

                    <!-- Category item 3 -->
                    <div class="col">
                        <a href="#!">
                            <article class="cate-item">
                                <img src="./assets/img/category-item/item-3.png" alt="" class="cate-item__thumb" />
                                <div class="cate-item__info">
                                    <h3 class="cate-item__title">Quizlet Plus</h3>
                                    <p class="cate-item__desc">Học tập không giới hạn</p>
                                </div>
                            </article>
                        </a>
                    </div>
                </div>
            </section>

            <!-- Browse Products -->
            <section class="home__container">
                <div class="home__row">
                    <h2 class="home__heading">Products</h2>
                    <div class="filter-wrap">
                        <button class="filter-btn js-toggle" toggle-target="#home-filter">
                            Filter
                            <img src="./assets/icons/filter.svg" alt="" class="filter-btn__icon icon" />
                        </button>

                        <div id="home-filter" class="filter hide">
                            <img src="./assets/icons/arrow-up.png" alt="" class="filter__arrow" />
                            <h3 class="filter__heading">Filter</h3>
                            <form action="" class="filter__form form">
                                <div class="filter__row filter__content">
                                    <!-- Filter column 1 -->
                                    <div class="filter__col">
                                        <label for="" class="form__label">Price</label>
                                        <div class="filter__form-group">
                                            <div
                                                class="filter__form-slider"
                                                style="--min-value: 10%; --max-value: 60%"
                                            ></div>
                                        </div>
                                        <div class="filter__form-group filter__form-group--inline">
                                            <div>
                                                <label for="" class="form__label form__label--small"> Minimum </label>
                                                <div class="filter__form-text-input filter__form-text-input--small">
                                                    <input
                                                        type="text"
                                                        name=""
                                                        id=""
                                                        class="filter__form-input"
                                                        value="20000đ"
                                                    />
                                                </div>
                                            </div>
                                            <div>
                                                <label for="" class="form__label form__label--small"> Maximum </label>
                                                <div class="filter__form-text-input filter__form-text-input--small">
                                                    <input
                                                        type="text"
                                                        name=""
                                                        id=""
                                                        class="filter__form-input"
                                                        value="200000đ"
                                                    />
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="filter__separate"></div>


                                    <!-- Filter column 3 -->
                                    <div class="filter__col">
                                        <label for="" class="form__label">Brand</label>
                                        <div class="filter__form-group">
                                            <div class="filter__form-text-input">
                                                <input
                                                    type="text"
                                                    name=""
                                                    id=""
                                                    placeholder="Search brand name"
                                                    class="filter__form-input"
                                                />
                                                <img
                                                    src="./assets/icons/search.svg"
                                                    alt=""
                                                    class="filter__form-input-icon icon"
                                                />
                                            </div>
                                        </div>
                                        <div class="filter__form-group">
                                            <div class="form__tags">
                                                <button class="form__tag">Netflix</button>
                                                <button class="form__tag">Youtube</button>
                                                <button class="form__tag">Quizlet Plus</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="filter__row filter__footer">
                                    <button class="btn btn--text filter__cancel js-toggle" toggle-target="#home-filter">
                                        Cancel
                                    </button>
                                    <button
                                        class="btn btn--primary filter__submit js-toggle"
                                        toggle-target="#home-filter"
                                    >
                                        Show Result
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="row row-cols-5 row-cols-lg-2 row-cols-sm-1 g-3">
                    <!-- Product card 1 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-1.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Coffee Beans - Espresso Arabica and Robusta Beans</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$47.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">4.3</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 2 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-2.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Lavazza Coffee Blends - Try the Italian Espresso</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$53.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">3.4</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 3 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-3.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn like-btn--liked product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Lavazza - Caffè Espresso Black Tin - Ground coffee</a>
                            </h3>
                            <p class="product-card__brand">Welikecoffee</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$99.99</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">5.0</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 4 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-4.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Qualità Oro Mountain Grown - Espresso Coffee Beans</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$38.65</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">4.4</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 5 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-1.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Coffee Beans - Espresso Arabica and Robusta Beans</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$47.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">4.3</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 6 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-2.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Lavazza Coffee Blends - Try the Italian Espresso</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$53.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">3.4</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 7 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-3.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn like-btn--liked product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Lavazza - Caffè Espresso Black Tin - Ground coffee</a>
                            </h3>
                            <p class="product-card__brand">Welikecoffee</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$99.99</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">5.0</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 8 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-4.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Qualità Oro Mountain Grown - Espresso Coffee Beans</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$38.65</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">4.4</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 9 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-1.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Coffee Beans - Espresso Arabica and Robusta Beans</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$47.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">4.3</span>
                            </div>
                        </article>
                    </div>

                    <!-- Product card 10 -->
                    <div class="col">
                        <article class="product-card">
                            <div class="product-card__img-wrap">
                                <a href="./product-detail.html">
                                    <img src="./assets/img/product/item-2.png" alt="" class="product-card__thumb" />
                                </a>
                                <button class="like-btn product-card__like-btn">
                                    <img src="./assets/icons/heart.svg" alt="" class="like-btn__icon icon" />
                                    <img src="./assets/icons/heart-red.svg" alt="" class="like-btn__icon--liked" />
                                </button>
                            </div>
                            <h3 class="product-card__title">
                                <a href="./product-detail.html">Lavazza Coffee Blends - Try the Italian Espresso</a>
                            </h3>
                            <p class="product-card__brand">Lavazza</p>
                            <div class="product-card__row">
                                <span class="product-card__price">$53.00</span>
                                <img src="./assets/icons/star.svg" alt="" class="product-card__star" />
                                <span class="product-card__score">3.4</span>
                            </div>
                        </article>
                    </div>
                </div>
            </section>
        </main>

        <!-- Footer -->
        <footer id="footer" class="footer"></footer>
        <script>
            load("#footer", "./templates/footer.jsp");
        </script>
    </body>
</html>

