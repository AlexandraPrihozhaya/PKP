<%@ page import="java.util.ArrayList" %>
<%@ page import="tourpackage.Tour" %>

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
   tr, td {
    border: grey solid 1px;
   }
   table {
     width: 100%;
   }
   td {
     padding-left: 10px;
     padding-top: 4px;
     padding-bottom: 4px;
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

    <%
        Integer avDays = (Integer) request.getAttribute("avDays");
        Integer avPeople = (Integer) request.getAttribute("avPeople");
        Integer avPrice = (Integer) request.getAttribute("avPrice");
        Integer maxDays = (Integer) request.getAttribute("maxDays");
        Integer maxPeople = (Integer) request.getAttribute("maxPeople");
        Integer maxPrice = (Integer) request.getAttribute("maxPrice");
        Integer minDays = (Integer) request.getAttribute("minDays");
        Integer minPeople = (Integer) request.getAttribute("minPeople");
        Integer minPrice = (Integer) request.getAttribute("minPrice");
    %>

    <table>
      <tr>
        <td><b>Среднее число дней: </b><%= avDays %></td>
        <td><b>Среднее число человек: </b><%= avPeople %></td>
        <td><b>Средняя цена: </b><%= avPrice %> руб.</td>
      </tr>
      <tr>
        <td><b>Максимальное число дней: </b><%= maxDays %></td>
        <td><b>Максимальное число человек: </b><%= maxPeople %></td>
        <td><b>Максимальная цена: </b><%= maxPrice %> руб.</td>
      </tr>
      <tr>
        <td><b>Минимальное число дней: </b><%= minDays %></td>
        <td><b>Минимальное число человек: </b><%= minPeople %></td>
        <td><b>Минимальная цена: </b><%= minPrice %> руб.</td>
      </tr>
    </table>

 </body>
</html>
