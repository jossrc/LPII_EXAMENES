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
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <title>Eliminar Libro</title>
  </head>
  <body>
    <div class="title-container col bg-secondary p-2">
      <h1 class="title text-center text-white">Mantenimiento de libros</h1>
    </div>

    <section id="registro" class="animate__animated animate__fadeIn">
      <div class="container mt-4">
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">
            <form
              class="form mb-3 needs-validation row"
              action="libros?opcion=eliminar"
              method="post"
              novalidate
            >
              <div class="mb-3">
                <label for="txtBookCode" class="form-label"
                  >Código del libro:</label
                >
                <input
                  type="text"
                  name="txtBookCode"
                  class="form-control"
                  id="txtBookCode"
                  placeholder="Ingrese Código"
                  readonly="readonly"
                  value="${foundBook.code}"
                />
              </div>
              <div class="mb-3">
                <label for="txtBookTitle" class="form-label">Título :</label>
                <input
                  type="text"
                  class="form-control"
                  name="txtBookTitle"
                  id="txtBookTitle"
                  placeholder="Ingrese título del libro"
                  value="${foundBook.title}"
                />
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="txtBookPages" class="form-label">Páginas :</label>
                <input
                  type="number"
                  name="txtBookPages"
                  class="form-control"
                  id="txtBookPages"
                  placeholder="0"
                  min="0"
                  value="${foundBook.pages}"
                />
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="txtBookPublicationDate" class="form-label"
                  >Fecha Publicación :</label
                >
                <input
                  type="date"
                  class="form-control"
                  name="txtBookPublicationDate"
                  id="txtBookPublicationDate"
                  placeholder="Año/Mes/Día"
                  value="${foundBook.publicationDate}"
                />
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="cboBookAuthor" class="form-label">Autor :</label>
                <select
                  id="cboBookAuthor"
                  name="cboBookAuthor"
                  class="form-select"
                  aria-label="Autor del libro"
                >
                  <tools:comboAuthor authorCode="${foundBook.authorCode}"/>
                </select>
                
              </div>
              <div class="mb-3 col-md-6 col-xs-12">
                <label for="cboBookGenre" class="form-label">Género :</label>
                <select
                  id="cboBookGenre"
                  name="cboBookGenre"
                  class="form-select"
                  aria-label="Genero del libro"
                >
                  <tools:comboGenre genreCode="${foundBook.genreCode}"/>
                </select>
              </div>

              <div
                class="
                  d-xxs-grid-config-buttons
                  gap-2
                  d-flex
                  justify-content-sm-start justify-content-evenly
                "
              >
                <button
                  class="btn btn-danger me-md-2"
                  type="submit"
                >
                  Eliminar
                </button>  
                
                 <a href="consulta-robles.jsp" class="btn btn-primary">
                   &#8630; Regresar
                 </a>

              </div>
            </form>
          </div>
        </div>
        
        <%
          try {
             String message = (String) request.getAttribute("message");
               if (!message.isEmpty()) {           		
        %>
        <div class="row justify-content-center">
          <div class="col-xs-12 col-md-8 col-lg-6">        
            <div class="alert alert-success alert-dismissible fade show mt-3" role="alert">
                ${ message }
               <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
          </div>          
        </div>
        <%
              }	
           }
          catch(Exception e) { }
        %>      
      </div>
    </section>
 
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
