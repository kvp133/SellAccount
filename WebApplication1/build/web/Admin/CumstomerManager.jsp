<%-- 
    Document   : ManagerCustomer
    Created on : Jan 29, 2024, 11:54:20 PM
    Author     : KieuVietPhuoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/favicon/apple-touch-icon.png" />
  <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png" />
  <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png" />
  <link rel="manifest" href="./assets/favicon/site.webmanifest" />
  <meta name="msapplication-TileColor" content="#da532c" />
  <meta name="theme-color" content="#ffffff" />
  <title>ChillStore - Dashboard</title>
  <link href="Admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="Admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="Admin/css/ruang-admin.min.css" rel="stylesheet">
  <script src="Admin/js/AdminLoading.js"></script>
  <style>
    .hide {
      display: none;
    }

  </style>
</head>

<body id="page-top">
<div id="wrapper">
  <!-- Sidebar -->
  <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
    <%@include file="Templates/navbar.jsp"%>
  </ul>
  <!-- Sidebar -->
  <div id="content-wrapper" class="d-flex flex-column">
    <div id="content">
      <!-- TopBar -->

      <!-- Topbar -->
      <!-- Container Fluid-->
      <div class="container-fluid" id="container-wrapper">
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800">List Product</h1>
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="./">Home</a></li>
            <li class="breadcrumb-item">Tables</li>
            <li class="breadcrumb-item active" aria-current="page">DataTables</li>
          </ol>
        </div>

        <!-- Row -->
        <div class="row">
          <!-- Datatables -->
          <div class="col-lg-12">
            <div class="card mb-4">
              <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Data Product</h6>
                <input class="m-0 border-0" type="text" oninput="searchAjaxLoading()" name="idSearch" id="idSearch" placeholder="Enter id customer search">
              </div>
              <h6 class="m-0 font-weight-bold text-primary">${requestScope.notify2}</h6>
              <div class="table-responsive p-3">
                <table class="table align-items-center " id="dataTable">
                  <thead class="thead-light">
                  <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Current Balance</th>
                    <th>Action</th>
                  </tr>
                  </thead>

                  <tbody id="searchResults" class="">

                  <c:forEach items="${requestScope.listCustomer}" var="product" varStatus="loop">
                    <tr>
                      <td class="active1">${product.getCustomerID()}</td>
                      <td class="active2 getValue hide"><input  type="text" value="${product.getCustomerID()}" name="idCustomer" readonly></td>
                      <td class="active1">${product.getFirstName()}</td>
                      <td class="active2 getValue hide"><input  value="${product.getFirstName()}" type="text"  name="firstName"></td>
                      <td class="active1">${product.getLastName()}</td>
                      <td class="active2 getValue hide"><input  value="${product.getLastName()}" type="text"  name="lastName"></td>
                      <td class="active1">${product.getEmail()}</td>
                      <td class="active2 getValue hide"><input  type="text" value="${product.getEmail()}" name="email"></td>
                      <td class="active1">${product.getCurrentBalance()}</td>
                      <td class="active2 getValue hide"><input  type="text" value="${product.getCurrentBalance()}" name="balance"></td>
                      <td ><button class="active1 btn btn--rounded" style="background-color:red;color: white" onclick="deleteProduct(${product.getCustomerID()})">Delete</button>
                        <button class="active1 btn " style="background-color:green;color: white" onclick="unhideUpdate()">Update</button>
                        <button class="active2 hide btn " style="background-color:green;color: white" onclick="updateProduct(${loop.index},${product.getCustomerID()})">Save</button>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>

                </table>
              </div>
            </div>
          </div>
          <!-- DataTable with Hover -->

        </div>
        <!--Row-->



        <!-- Modal Logout -->


      </div>
      <!---Container Fluid-->
    </div>

    <!-- Footer -->

    <!-- Footer -->
  </div>

</div>

<!-- Scroll to top -->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<script src="Admin/vendor/jquery/jquery.min.js"></script>
<script src="Admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="Admin/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="Admin/js/ruang-admin.min.js"></script>
<script>
  function searchAjaxLoading() {
    var searchTerm = document.getElementById("idSearch").value;

    $.ajax({
      type: "GET",
      url: "ajaxsearchCustomer", // replace with your servlet URL
      data: { idSearch: searchTerm },
      success: function(response) {
        $("#searchResults").html(response);
      },
      error: function(error) {
        console.log("Error: " + error);
      }
    });
  }
  function deleteProduct(id) {
    $.ajax({
      type: "GET",
      url: "admincustomer", // replace with your servlet URL
      data: { action: "delete", idCustomer: id },
      success: function() {
        searchAjaxLoading();
      },
      error: function(error) {
        console.log("Error: " + error);
      }
    });
  }
  //when click unhideUpdate() change class active to hide and hide to active
  function unhideUpdate() {
    var x = document.getElementsByClassName("active1");
    var y = document.getElementsByClassName("active2");
    var i;
    for (i = 0; i < x.length; i++) {
      x[i].classList.add("hide");
    }
    for (i = 0; i < y.length; i++) {
      y[i].classList.remove("hide");
    }

  }
  //when click updateProduct(index,idProduct) will get value using querry selector from row input and send to servlet
  function updateProduct(index, idProduct) {
    var x = document.querySelectorAll('[name="idCustomer"]');
    var idCustomer = x[index].value;

    var y = document.querySelectorAll('[name="firstName"]');
    var firstName = y[index].value;

    var z = document.querySelectorAll('[name="lastName"]');
    var lastName = z[index].value;

    var w = document.querySelectorAll('[name="email"]');
    var email = w[index].value;

    var v = document.querySelectorAll('[name="balance"]');
    var balance = v[index].value;

    $.ajax({
      type: "GET",
      url: "admincustomer", // replace with your servlet URL
      data: {
        action: "edit",
        idCustomer: idCustomer,
        firstName: firstName,
        lastName: lastName,
        email: email,
        balance: balance
      },
      success: function() {
        searchAjaxLoading();
      },
      error: function(error) {
        console.log("Error: " + error);
      }
    });
  }




</script>
<!-- Page level plugins -->
<%--  <script src="Admin/vendor/datatables/jquery.dataTables.min.js"></script>--%>
<%--  <script src="Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>--%>

<!-- Page level custom scripts -->
<script>
  $(document).ready(function () {
    $('#dataTable').DataTable(); // ID From dataTable
    $('#dataTableHover').DataTable(); // ID From dataTable with Hover
  });
</script>

</body>

</html>
