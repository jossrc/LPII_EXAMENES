<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <title>Resultados</title>
  </head>
  <body>
    <div class="container mt-4 animate__animated animate__fadeIn">
      <div class="title-container alert alert-primary">
        <h1 class="title text-center h3">
          Resultado de contadores y acumuladores
        </h1>
      </div>

      <div class="row justify-content-center">
        <div class="col-xs-12 col-lg-8">
          <div class="card">
            <div class="card-body">
              <div class="data-container">
                <ul class="list-group">
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Cantidad por Tipo <b>1</b> :</span>
                    <span class="badge bg-primary rounded-pill">${ cantidadTipo1 }</span>
                  </li>
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Acumulado por Tipo <b>1</b> :</span>
                    <span class="badge bg-success rounded-pill">
                      <fmt:setLocale value="es_PE"/>
                      <fmt:formatNumber type="currency" value="${ acumuladoTipo1 }" /> 
                    </span>
                  </li>
                </ul>

                <ul class="list-group mt-3">
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Cantidad por Tipo <b>2</b> : </span>
                    <span class="badge bg-primary rounded-pill">${ cantidadTipo2 }</span>
                  </li>
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Acumulado por Tipo <b>2</b> : </span>
                    <span class="badge bg-success rounded-pill">
                      <fmt:setLocale value="es_PE"/>
                      <fmt:formatNumber type="currency" value="${ acumuladoTipo2 }" /> 
                    </span>
                  </li>
                </ul>

                <ul class="list-group mt-3">
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Cantidad por Tipo <b>3</b> :</span>
                    <span class="badge bg-primary rounded-pill">${ cantidadTipo3 }</span>
                  </li>
                  <li
                    class="
                      list-group-item
                      d-flex
                      justify-content-between
                      align-items-center
                    "
                  >
                    <span>Acumulado por Tipo <b>3</b> :</span>
                    <span class="badge bg-success rounded-pill">
                      <fmt:setLocale value="es_PE"/>
                      <fmt:formatNumber type="currency" value="${ acumuladoTipo3 }" />
                    </span>
                  </li>
                </ul>
              </div>
            </div>
            <div class="card-footer text-center">
              <a href="registro-robles.jsp" class="btn btn-primary">
                Regresar
              </a>
              <a href="solservlet?opcion=limpiar" class="btn btn-info"> Limpiar Contadores </a>
            </div>
          </div>

          <c:if test="${ soliResultados != null }">
            <div
              class="mt-3 alert alert-${ soliType } alert-dismissible fade show"
              role="alert"
            >
              ${ soliResultados }
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="alert"
                aria-label="Close"
              ></button>
            </div>
          </c:if>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
