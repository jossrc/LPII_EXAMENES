<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="/WEB-INF/library.tld" prefix="tools" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
      crossorigin="anonymous"
    />
    <link
      href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css"
      rel="stylesheet"
    />
    <title>Consultar Libro</title>
  </head>
  <body>
    <div class="title-container col bg-secondary p-2">
      <h1 class="title text-center text-white">Consultar libros por autor</h1>
    </div>

    <div class="container mt-4">
      <form
        id="myForm"
        class="needs-validation"
        action="publicacion?opcion=filtrar"
        method="POST"
        novalidate
      >
        <div class="mb-3 row">
          <label for="cboAuthors" class="col-sm-2 col-form-label mt-2"
            >Búsqueda:
          </label>
          <div class="col-sm-8 mt-2">
            <select
              id="cboAuthors"
              name="cboAuthors"
              class="form-select"
              aria-label="Lista de autores"
              required
            >
              <tools:comboAuthor authorCode="${rqAuthorCode}"/>
            </select>
            <div class="invalid-feedback">Seleccione un autor para buscar</div>
          </div>
          <div class="col-sm-2 mt-2">
            <button class="btn btn-primary" type="submit">Consultar</button>
          </div>
        </div>
      </form>

      <div class="mt-2 table-responsive text-nowrap">
        <table id="myTable" class="table table-hover">
          <thead>
            <tr class="table-dark">
              <th scope="col">Cód. Libro</th>
              <th scope="col">Nombre Autor</th>
              <th scope="col">Fecha Publicación</th>
              <th scope="col">Título Libro</th>
              <th scope="col">Género</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ lstPublicationBooks }" var="p">
              <tr>
                <td scope="row">${p.bookCode}</td>
                <td>${p.authorName}</td>
                <td>${p.publicationDate}</td>
                <td>${p.bookTitle}</td>
                <td>${p.genreBook}</td>
                <td><a href="libros?opcion=buscar&idbook=${p.bookCode}">Seleccione</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      
       <%
         try {
           String message = (String) request.getAttribute("message");
              if (!message.isEmpty()) {           		
       %>
          <div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
              ${ message }
             <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>  
       <%
             }	
          }
        catch(Exception e) { }
       %>     
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"></script>
    <script>
      $(document).ready(function () {
        $('#myTable').DataTable({
          lengthChange: false,
          searching: false,
          language: {
        	  emptyTable: 'Seleccione un autor para consultar'
          }
        });
      });

      (function () {
        'use strict';
        var forms = document.querySelectorAll('.needs-validation');
        Array.prototype.slice.call(forms).forEach(function (form) {
          form.addEventListener(
            'submit',
            function (event) {
              if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
              }

              form.classList.add('was-validated');
            },
            false
          );
        });
      })();
    </script>
  </body>
</html>
