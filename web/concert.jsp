<%@ page import="DAO.DAOConcert" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="items.Concert" %>
<%--
  Created by IntelliJ IDEA.
  User: clementmondion
  Date: 19/05/15
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header><jsp:include page="header.html"/></header>

<html>
<head>
    <title></title>
</head>
<body>

<div class="jumbotron">
  <div class="container">
    <center>
    <h1>Programme</h1>
    </center>
    <br>
    <div class="row">
      <div class="col-md-1">
        <div class="top-bg"></div>
      </div>

      <div class="col-md-5 iPhone-features" style="margin-left:-25px;">
        <%--<ul class="top-features">--%>
          <div align="left">
           <p><u><H2>Scène 1</H2></u></p><br>

            <li>
              <span><i class="fa fa-random simple_bg top-features-bg"></i></span>
              <p><strong>Jour 1</strong><br>Spectacle 1</p>
            </li>
            <li>
              <span><i class="fa fa-cogs simple_bg top-features-bg"></i></span>
              <p><strong>Jour 2</strong><br>Spectacle 2</p>
            </li>
            <li>
              <span><i class="fa fa-check simple_bg top-features-bg"></i></span>
              <p><strong>Jour 3</strong><br>Spectacle 3</p>
            </li>
          </div>
        <%--</ul>--%>
      </div>


      <div class="col-md-3">
        <div class="top-bg"></div>
      </div>
      <div class="col-md-5 iPhone-features" style="margin-right:-25px;">
        <%--<ul class="top-features">--%>
          <div align="right">
            <p><u><H2>Scène 2</H2></u></p><br>

            <li>
              <span><i class="fa fa-random simple_bg top-features-bg"></i></span>
              <p><strong>Jour 1</strong><br>Spectacle 1</p>
            </li>
            <li>
              <span><i class="fa fa-cogs simple_bg top-features-bg"></i></span>
              <p><strong>Jour 2</strong><br>Spectacle 2</p>
            </li>
            <li>
              <span><i class="fa fa-check simple_bg top-features-bg"></i></span>
              <p><strong>Jour 3</strong><br>Spectacle 3</p>
            </li>
          </div>
        <%--</ul>--%>
      </div>

    </div>
  </div>
</div>


<%


  try {
    DAOConcert lives = new DAOConcert();
    ArrayList<Concert> live_list = new ArrayList<Concert>();
    try {
      live_list = lives.findAll();
    } catch (Exception e) {
      e.printStackTrace();
    }

    for (Concert value : live_list) {
      out.println(value.getTitre());
      out.println(value.getInterprete());
      out.println(value.getDescriptif());
    }
  } catch (SQLException e) {
    e.printStackTrace();
    out.print("Aie aie aie");
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
    out.print("Aie aie aie2");
  }

%>
</body>
</html>
