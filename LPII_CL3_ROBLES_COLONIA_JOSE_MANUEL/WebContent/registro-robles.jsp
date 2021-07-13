<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools" %>

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
      href="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/css/datepicker.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <link
      href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
      rel="stylesheet"
    />
    <title>Registro de Solicitudes</title>
  </head>
  <body>
    <div class="container mt-4 animate__animated animate__fadeIn">
      <div class="title-container alert alert-primary">
        <h1 class="title text-center h3">Registrar Nueva Solicitud</h1>
      </div>

      <div class="row justify-content-center">
        <div class="col-xs-12 col-lg-8">
          <div class="card">
            <form
              action="solservlet?opcion=registrar"
              method="post"
              class="needs-validation"
              id="formSolicitud"
              novalidate
            >
              <div class="card-body">
                <div class="data-container">
                  <div class="row">
                    <div class="col">
                      <h4>Ingrese datos :</h4>
                      <hr class="divider" />
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="txtCodigo" class="form-label"
                          >Código:</label
                        >
                        <input
                          type="text"
                          class="form-control"
                          id="txtCodigo"
                          name="txtCodigo"
                          placeholder="SC0000"
                          pattern="SC[0-9]{4}"
                          required
                        />
                        <div class="invalid-feedback">
                          Ingrese un código válido (SC000X)
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label class="form-label" for="cboCliente"
                          >Cliente :</label
                        >
                        <select
                          id="cboCliente"
                          name="cboCliente"
                          class="form-select"
                          aria-label="Lista de Clientes"
                          required
                        >
                          <tools:comboCliente />
                        </select>
                        <div class="invalid-feedback">
                          Seleccione un cliente
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="txtFecha" class="form-label">Fecha :</label>
                        <div class="input-group">
                          <input
                            type="text"
                            class="form-control"
                            name="txtFecha"
                            id="txtFecha"
                            autocomplete="off"
                            placeholder="Año/Mes/Día"
                            aria-label="Fecha"
                            aria-describedby="calendar-icon"
                            required
                          />
                          <span class="input-group-text" id="calendar-icon">
                            <i class="bx bx-calendar"></i>
                          </span>
                        </div>
                        <div class="invalid-feedback">
                          La fecha es obligatoria
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="txtMonto" class="form-label">Monto :</label>
                        <input
                          type="number"
                          name="txtMonto"
                          class="form-control"
                          id="txtMonto"
                          placeholder="0.00"
                          step="any"
                          required
                          min="0"
                        />
                        <div class="invalid-feedback">
                          Se requiere de un monto válido mayor a cero
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label class="form-label" for="cboTipoCredito"
                          >Tipo :</label
                        >
                        <select
                          id="cboTipoCredito"
                          name="cboTipoCredito"
                          class="form-select"
                          aria-label="Tipo de Credito"
                          required
                        >
                          <tools:comboTipCredi />
                        </select>
                        <div class="invalid-feedback">
                          Seleccione un tipo válido
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="txtObservacion" class="form-label"
                          >Observación:</label
                        >
                        <input
                          type="text"
                          class="form-control"
                          id="txtObservacion"
                          name="txtObservacion"
                          placeholder="Ingrese Observación"
                          minlength="4"
                          required
                        />
                        <div class="invalid-feedback">
                          Ingrese una observación válida (+4)
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card-footer text-center">
                <button
                  id="btnRegistrarSolicitud"
                  class="btn btn-primary"
                  type="submit"
                >
                  Registrar
                </button>
                <a href="resultados-robles.jsp" class="btn btn-warning">
                  Consultar
                </a>
              </div>
            </form>
          </div>

          <c:if test="${ soliMensaje != null }">
            <div
              class="mt-3 alert alert-${ soliType } alert-dismissible fade show"
              role="alert"
            >
              ${ soliMensaje }
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
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/datepicker-full.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/locales/es.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
