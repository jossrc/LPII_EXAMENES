<%@page import="model.Shipping"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <title>Listado de envíos</title>
  </head>
  <body>
    <div class="container mt-4 animate__animated animate__fadeIn">
      <div class="title-container alert alert-primary">
        <h1 class="title text-center h3">Listado de envíos</h1>
      </div>

      <div class="row justify-content-center">
        <div class="col">
          <div class="btn-container mb-3">
            <a href="robles-mante.jsp" class="btn btn-warning">Registrar Nuevo Envío</a>
          </div>
          <div class="table-responsive text-nowrap">
            <table class="table">
              <thead>
                <tr class="table-info">
                  <th scope="col">Código</th>
                  <th scope="col">Cliente</th>
                  <th scope="col">Producto</th>
                  <th scope="col">Dirección</th>
                  <th scope="col">Precio</th>
                  <th scope="col">Fecha</th>
                  <th scope="col">Estado</th>
                </tr>
              </thead>
              <tbody>
              
              <%
                @SuppressWarnings("unchecked")
                ArrayList<Shipping> shippingList = (ArrayList<Shipping>) request.getAttribute("shippingList");
                if (shippingList != null) {
                   for (Shipping shipping : shippingList) {          
              %>
                <tr>
                  <th scope="row"><%=shipping.getCode() %></th>
                  <td><%=shipping.getClientName() %></td>
                  <td><%=shipping.getProductName() %></td>
                  <td><%=shipping.getAddress() %></td>
                  <td>S/ <%=shipping.getPrice() %></td>
                  <td><%=shipping.getDate() %></td>
                  
                  <%
                  
                    String statusText = "";
                    String background = "";
                  
                    switch(shipping.getStatus()){
                    case 1:
                        statusText = "Pendiente";
                        background = "bg-primary";
                        break;
                    case 2:
                        statusText = "En progreso";
                        background = "bg-info text-dark";
                        break;
                    case 3:
                        statusText = "Completado";
                        background = "bg-success";
                        break;
                    case 4:
                        statusText = "Cancelado";
                        background = "bg-danger";
                        break;
                    }
                  %>
                  
                  <td><span class="badge rounded-pill <%=background%>"><%=statusText %></span></td>
                </tr>
                <%
                    }
                  }
                %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
