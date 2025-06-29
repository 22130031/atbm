<%--
  Created by IntelliJ IDEA.
  User: BAO ANH
  Date: 4/11/2025
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="sidebar-collapse">
  <ul class="nav" id="main-menu">
    <!--LINK-->

    <li>
      <a href="admin_Disboard.html"><i class="fa fa-desktop "></i>Dashboard</a>
    </li>


    <li>
      <a href="admin_Disboard.html"><i class="fa fa-desktop "></i>Dashboard</a>
    </li>


    <li>
      <a href=<%=request.getContextPath()%>/admin_Users><i class="fa fa-table "></i>USER<span
              class="badge"></span></a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Products"><i
              class="fa fa-edit "></i>PRODUCT<span></span></a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Orders"><i class="fa fa-qrcode "></i>ORDERS</a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Categories"><i
              class="fa fa-bar-chart-o"></i>Category</a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Brands"><i class="fa fa-edit "></i>Brands</a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Materials"><i class="fa fa-edit "></i>Materials</a>
    </li>
    <li>
      <a href="<%=request.getContextPath()%>/admin_Keys"><i class="fa fa-edit "></i>Keys</a>
    </li>

  </ul>
</div>
</body>
</html>
