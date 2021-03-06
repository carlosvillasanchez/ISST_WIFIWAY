<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
  <title>WifiWay</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="icon" href="images/WifiWay.png">
</head>

<body>
  <!-- BARRA DE NAVEGACION -->
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
        </button>
        <a class="navbar-brand" href="#" id="back">WifiWay</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Projects</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        	<c:if test="${name == null}">
          <li><a href="FormLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </c:if>
          <c:if test="${name != null}">
          <p>${name}, bienvenid@ </p>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>

  <!-- INPUT PARA LATITUD/LONGITUD Y BOTON PARA IR A SELECCIONAR TRAYECTORIA-->
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 latlng"><input type="text" class="form-control" id="usr" placeholder="Selecciona un punto en el mapa"></div>
     <!--   <div class="col-sm-6 latlng"><a href="route.html" class="btn btn-primary btn-tray">Selecciona una trayectoria</a></div>-->
    </div>
  </div>

  <!-- DIV QUE CONTIENE EL MAPA Y EL SIDENAV DE LA INFO DE LAS REDES WIFI -->
  <div class="container-fluid text-center">    
    <div class="row content">
    
    
      <div class="col-sm-12 text-left maps" id="mapDiv"> 
        <div id="map"></div>
        <script src="js/index.js">
        </script>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDlUUPKEKse9Bj_Mtq2sPoLC6BFePtl2U&callback=initMap">
        </script>
      </div>
      
      
      <div class="col-sm-3 sidenav" id="panelOculto" style="display: none;">
      	<div id="loader">
     	 </div>
        <form>
          <label class="radio-inline">
            <input type="radio" name="optradio" class="allNetworks" checked>Todas
          </label>
          <label class="radio-inline">
            <input type="radio" name="optradio" class="openNetworks">Abiertas
          </label>
          <label class="radio-inline">
            <input type="radio" name="optradio" class="closedNetworks">Cerradas
          </label>
        </form>
        <div class="panel-group" id="accordion">
      </div>
    </div>
  </div>

  <!-- FOOTER -->
  <footer class="text-center">
    <p>Copyright ©. WifiWay. All Rights Reserved.</p>
  </footer>
</body>
</html>