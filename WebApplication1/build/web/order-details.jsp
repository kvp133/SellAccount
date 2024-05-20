<%-- 
    Document   : order-details
    Created on : Mar 2, 2024, 5:43:31 PM
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

    <title>Order Details | Chill Store</title>

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
        textarea{
            overflow: hidden;
            resize: none;
            border-radius: 16px;
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
                    <a href="#!" class="breadcrumbs__link">Order History
                        <img src="./assets/icons/arrow-right.svg" alt="" />
                    </a>
                </li>
                <li>
                    <a href="#!" class="breadcrumbs__link breadcrumbs__link--current">Order Details</a>
                </li>
            </ul>

        </div>

        <!-- order details -->
        <div class="checkout-container">
            <div class="row gy-xl-3">
                <div class="col-12">
                    <div class="cart-info">
                        <h1 class="cart-info__heading">Order Details List</h1>
                        <div class="cart-info__list">
                            <div class="col-12">
                                <div class="col-12">
                                    <div class="table-responsive p-3 col-12">
                                        <table class="col-12" id="dataTable">
                                            <thead class="thead-light">
                                            <tr>

                                                <th>Name Product</th>
                                                <th colspan="4">Info Account</th>
                                            </tr>
                                            </thead>

                                            <tbody class="col-12" style="align-items: center;">


                                            <c:forEach items="${requestScope.listNameProduct}" var="item">
                                                <tr>
                                                    <td>${item}</td>
                                                    <td colspan="4">
                                                    <textarea class="myTextarea" style="width: 100%; border: 2px solid gray;" >
                                                        <c:forEach items="${requestScope.listAccountProduct}" var="acc">
                                                            <c:if test="${acc.getProduct().getProductName().equals(item)}">
                                                                ${acc.getInfoAccount()}
                                                            </c:if>

                                                        </c:forEach>
                                                    </textarea>
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
    window.onload = function() {
        autoResize();
        removeEmptyLines();
    };

    function autoResize() {
        const textareas = document.getElementsByClassName('myTextarea');
        for (let i = 0; i < textareas.length; i++) {
            const textarea = textareas[i];
            textarea.style.height = 'auto';
            textarea.style.height = textarea.scrollHeight + 'px';
        }
    }
    function removeEmptyLines() {
        // Lấy tất cả các textarea có class là 'myTextarea'
        var textareas = document.getElementsByClassName("myTextarea");

        // Lặp qua từng textarea
        for (var i = 0; i < textareas.length; i++) {
            var textarea = textareas[i];
            // Lấy nội dung của textarea và chia thành các dòng
            var lines = textarea.value.split('\n');

            // Loại bỏ các dòng trống và dòng chỉ chứa khoảng trắng
            var filteredLines = lines.filter(function(line) {
                return line.trim() !== '';
            });

            // Cập nhật lại nội dung của textarea
            textarea.value = filteredLines.join('\n');
        }
        autoResize();
    }

</script>


</body>
