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
