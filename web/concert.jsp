<%@ page import="DAO.DAOConcert" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="items.Concert" %>
<%@ page import="DAO.DAOSpectacle" %>
<%@ page import="items.Spectacle" %>
<%@ page import="items.Salle" %>
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
           <p><u><H2>Salle 1</H2></u></p><br>

            <li>
              <span><i class="fa fa-random simple_bg top-features-bg"></i></span>
              <p><strong>Jour 1 - <i>01/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 0) {
                            if(value2.getDate().equals("2015-06-01"))
                            {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }


                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
            </li>
            <li>
              <span><i class="fa fa-cogs simple_bg top-features-bg"></i></span>
              <p><strong>Jour 2 - <i>02/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 0) {
                            if(value2.getDate().equals("2015-06-02")) {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }

                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
            </li>
            <li>
              <span><i class="fa fa-check simple_bg top-features-bg"></i></span>
              <p><strong>Jour 3 - <i>03/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 0) {
                            if(value2.getDate().equals("2015-06-03")) {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }

                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
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
            <p><u><H2>Salle 2</H2></u></p><br>

            <li>
              <span><i class="fa fa-random simple_bg top-features-bg"></i></span>
              <p><strong>Jour 1 - <i>01/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 1) {
                            if(value2.getDate().equals("2015-06-01")) {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }

                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
            </li>
            <li>
              <span><i class="fa fa-cogs simple_bg top-features-bg"></i></span>
              <p><strong>Jour 2 - <i>02/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 1) {
                            if(value2.getDate().equals("2015-06-02")) {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }

                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
            </li>
            <li>
              <span><i class="fa fa-check simple_bg top-features-bg"></i></span>
              <p><strong>Jour 3 - <i>03/06/2015</i></strong><br><br>
                <%
                  try {
                    DAOConcert lives = new DAOConcert();
                    ArrayList<Concert> live_list = new ArrayList<Concert>();


                    DAOSpectacle Spec = new DAOSpectacle();
                    ArrayList<Spectacle> spectacle = new ArrayList<Spectacle>();

                    try {
                      live_list = lives.findAll();
                      spectacle = Spec.findAll();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }

                    for (Concert value : live_list) {
                      for(Spectacle value2 : spectacle)
                      {
                        if(value2.getConcert().getTitre().equals(value.getTitre())) {
                          if (value2.getSalle().getNumero() == 1) {
                            if(value2.getDate().equals("2015-06-03")) {
                              out.println(value.getTitre());
                              out.println(value.getInterprete());
                              out.println("-");
                              out.println(value.getDescriptif());
                              out.println("<br>");
                            }
                          }
                        }
                      }
                    }


                  } catch (SQLException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie");
                  } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.print("Aie aie aie2");
                  }

                %>
                <br>
              </p>
            </li>
          </div>
        <%--</ul>--%>
      </div>

    </div>
  </div>

</body>
</html>
