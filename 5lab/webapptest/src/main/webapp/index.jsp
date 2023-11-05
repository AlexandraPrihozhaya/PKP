<%@ page import="java.util.ArrayList" %>
<%@ page import="tourpackage.Tour" %>
<%@ page import="mainpackage.JspServlet" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
 <head>
  <%@ page contentType="text/html; charset=utf-8" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>tours</title>
  <style type="text/css">
   header {
    color: white;
    background: #000000;
    text-align: center;
    line-height: 60px;
    height: 60px;
    font-size: 20px;
    position: fixed;
    width: 100%;
    left: 0;
    top:0;
    border-bottom: #ABABAB solid 1px;
   }
   body {
    padding-top:62px;
    font-family: 'segoe print';
   }
   .div_tour {
    background: #dbdae4;
    border: #ABABAB solid 1px;
    padding: 0 10px;
    margin-bottom: 10px;
    box-shadow: 1px 1px 3px #ABABAB, -1px -1px 3px #ABABAB;
   }
  </style>
 </head>
 <body>
  <header>~~~Туры по Беларуси~~~</header>

    <%
       ArrayList<Tour> tours = new ArrayList<>();
       tours = (ArrayList<Tour>) request.getAttribute("tours");
    %>

    <% for (Tour tour : tours) {%>
        <div class='div_tour'>
          <p><b>Название: </b><%= tour.getTitle() %></p>
          <p><b>Цена: </b><%= tour.getPrice() %> руб.</p>
          <p><b>Дата: </b><%= tour.getDate() %></p>
          <p><b>Продолжительность: </b><%= tour.getNumberOfDays() %> дн.</p>
          <p><b>Количество человек: </b><%= tour.getNumberOfPeople() %></p>
        </div>
    <% } %>

 </body>
</html>
