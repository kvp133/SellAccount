<%-- 
    Document   : ManagerProduct
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
            <h1 class="h3 mb-0 text-gray-800">History Order</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="./">Home</a></li>
              <li class="breadcrumb-item">Tables</li>
              <li class="breadcrumb-item active" aria-current="page">History Order</li>
            </ol>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Data Product</h6>
                  <input class="m-0 border-0" type="text" oninput="searchAjaxLoading()" name="searchInput" id="searchInput" placeholder="Enter product search">
                </div>
                <h6 class="m-0 font-weight-bold text-primary">${requestScope.notify2}</h6>
                <div class="table-responsive p-3">
                  <table class="table align-items-center " id="dataTable">
                    <thead class="thead-light">
                      <tr>
                        <th>ID</th>
                        <th>Info Account</th>
                        <th>Product Name</th>
                        <th>Status</th>
                        <th>Order ID</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>ID</th>
                        <th>Info Account</th>
                        <th>Product Name</th>
                        <th>Status</th>
                        <th>Order ID</th>
                        <th>Action</th>
                      </tr>
                    </tfoot>
                    <tbody id="searchResults">

                        <c:forEach items="${requestScope.list}" var="list" varStatus="loop">
                            <tr>
                            <td class="active1">${list.getAccountProductID()}</td>
                              <td class="active2 getValue hide"><input  type="text" value="${list.getAccountProductID()}" name="idaccproduct"></td>
                            <td class="active1">${list.getInfoAccount()}</td>
                              <td class="active2 getValue hide"><input  value="${list.getInfoAccount()}" type="text"  name="infoacc"></td>
                            <td class="active1">${list.getProduct().getProductName()}</td>
                              <td class="active2 getValue hide"><input  type="text" value="${list.getProduct().getProductName()}" name="nameproduct"></td>
                              <c:choose>
                                <c:when test="${list.isStatusSell()}">
                                  <td class="active1">Sell</td>
                                 <td class="active2 getValue hide"><input  type="text" value="true" name="statussell"></td>
                                </c:when>
                                <c:otherwise>
                                  <td class="active1">Not Sell</td>
                                  <td class="active2 getValue hide"><input  type="text" value="false" name="statussell"></td>
                                </c:otherwise>
                              </c:choose>
                                   <td class="active1">${list.getOrderDetail().getOrder().getOrderID()}</td>
                              <td class="active2 getValue hide"><input  type="text" value="${list.getOrderDetail().getOrder().getOrderID()}" name="orderID"></td>
                           
                              <td ><button class="active1 btn btn--rounded" style="background-color:red;color: white" onclick="deleteProduct(${list.getAccountProductID()})">Delete</button>
                                <button class="active1 btn " style="background-color:green;color: white" onclick="unhideUpdate()">Update</button>
                                <button class="active2 hide btn " style="background-color:green;color: white" onclick="updateProduct(${loop.index},${list.getAccountProductID()})">Save</button>
                              </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                  </table>
                </div>
              </div>
            </div>
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 align-items-center">
                  <h6 class="m-0 font-weight-bold text-primary mb-3">Add more account product</h6>
                  <form action="adminaccountproduct" method="post">
                    
                    <div class="form-group">
                      <label for="exampleFormControlSelect1">Type Product</label>
                      <select class="form-control" id="exampleFormControlSelect1" name="productNameadd">
                        <c:forEach items="${requestScope.listProduct}" var="listType">
                          <option>${listType.getProductName()}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlTextarea1">Info Account</label>
                      <textarea placeholder="Enter each line just one account" class="form-control" id="exampleFormControlTextarea1" rows="3" name="listaccount"></textarea>
                    </div>
                          <input type="hidden" name="action" value="addAccountProduct">
                    <div class="form-group">
                      <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                    
                  </form>

                </div>
                <div class="table-responsive p-3">

                </div>
              </div>
            </div>
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
      var searchTerm = document.getElementById("searchInput").value;

      $.ajax({
        type: "GET",
        url: "ajaxsearchaccountproduct",
        data: { nameProductsearch: searchTerm }, // Fix missing colon
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
        url: "adminaccountproduct",
        data: { action: "delete", idProduct: id },
        success: function() {
          searchAjaxLoading();
        },
        error: function(error) {
          console.log("Error: " + error);
        }
      });
    }

    function unhideUpdate() {
      var x = document.getElementsByClassName("active1");
      var y = document.getElementsByClassName("active2");
      var i;
      for (i = 0; i < x.length; i++) {
        x[i].classList.toggle("hide"); // Use toggle to switch classes
      }
      for (i = 0; i < y.length; i++) {
        y[i].classList.toggle("hide"); // Use toggle to switch classes
      }
    }

    function updateProduct(index, idProduct) {
      var x = document.querySelectorAll('[name="idaccproduct"]');
      var idaccproduct = x[index].value;

      var y = document.querySelectorAll('[name="infoacc"]');
      var infoacc = y[index].value;

      var z = document.querySelectorAll('[name="nameproduct"]');
      var nameproduct = z[index].value;

      var w = document.querySelectorAll('[name="statussell"]');
      var statussell = w[index].value;

      var v = document.querySelectorAll('[name="orderID"]');
      var orderID = v[index].value;

      $.ajax({
        type: "GET",
        url: "adminaccountproduct",
        data: {
          action: "update",
          idaccproduct: idaccproduct,
          infoacc: infoacc,
          nameproduct: nameproduct,
          statussell: statussell,
          orderID: orderID // Include orderID in the data
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

