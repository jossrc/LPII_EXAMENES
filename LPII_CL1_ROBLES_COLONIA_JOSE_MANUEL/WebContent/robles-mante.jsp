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
      href="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/css/datepicker.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <title>Registrar Nuevo Envío</title>
  </head>
  <body>
    <div class="container mt-4 animate__animated animate__fadeIn">
      <div class="title-container alert alert-primary">
        <h1 class="title text-center h3">Registrar Nuevo Envío</h1>
      </div>

      <div class="row justify-content-center">
        <div class="col-xs-12 col-lg-8">
          <div class="card">
            <form class="needs-validation" id="shipping-form" novalidate>
              <div class="card-header d-flex justify-content-between align-items-center">
                <a href="shipping?opcion=listar" class="btn btn-success">Ir al listado de envíos</a>
                <span>&copy; Courier HayTá</span>
              </div>
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
                        <label for="shipping-code" class="form-label"
                          >Código de envío :</label
                        >
                        <input
                          type="text"
                          class="form-control"
                          id="shipping-code"
                          name="shipping-code"
                          placeholder="Ejemplo ENV0007"
                          pattern="ENV[0-9]{4}"
                          required
                        />
                        <div class="invalid-feedback">
                          Ingrese un código válido (ENV000X)
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-clientName" class="form-label"
                          >Cliente :</label
                        >
                        <input
                          type="text"
                          name="shipping-clientName"
                          class="form-control"
                          id="shipping-clientName"
                          placeholder="Ingrese nombre completo"
                          required
                          minlength="4"
                          maxlength="100"
                        />
                        <div class="invalid-feedback">
                          Se requiere de un nombre válido
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-product" class="form-label"
                          >Producto :</label
                        >
                        <input
                          type="text"
                          name="shipping-product"
                          class="form-control"
                          id="shipping-product"
                          placeholder="Ingrese nombre del producto"
                          required
                          minlength="4"
                          maxlength="100"
                        />
                        <div class="invalid-feedback">
                          Se requiere de un producto válido
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-address" class="form-label"
                          >Dirección :</label
                        >
                        <input
                          type="text"
                          name="shipping-address"
                          class="form-control"
                          id="shipping-address"
                          placeholder="Ingrese dirección exacta"
                          required
                          minlength="4"
                          maxlength="80"
                        />
                        <div class="invalid-feedback">
                          Se requiere de una dirección válida
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-price">Precio :</label>
                        <input
                          type="number"
                          class="form-control"
                          name="shipping-price"
                          id="shipping-price"
                          placeholder="0.00"
                          min="0"
                          step="any"
                          required
                        />
                        <div class="invalid-feedback">
                          Se requiere un precio válido
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-date">Fecha de envío :</label>
                        <input
                          type="text"
                          class="form-control"
                          name="shipping-date"
                          id="shipping-date"
                          autocomplete="off"
                          placeholder="Año/Mes/Día"
                          required
                        />
                        <div class="invalid-feedback">
                          La fecha de envío es obligatoria
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="mb-3">
                        <label for="shipping-status">Estado :</label>
                        <select
                          id="shipping-status"
                          name="shipping-status"
                          class="form-select"
                          aria-label="Estado de Productos"
                          required
                        >
                          <option selected disabled hidden="hidden" value="">
                            Seleccione...
                          </option>
                          <option value="1">Pendiente</option>
                          <option value="2">En progreso</option>
                          <option value="3">Completado</option>
                          <option value="4">Cancelado</option>
                        </select>
                        <div class="invalid-feedback">Seleccione un estado</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card-footer text-end">
                <button
                  id="btn-shipping-register"
                  class="btn btn-primary"
                  type="submit"
                >
                  Registrar
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"
    ></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/datepicker-full.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vanillajs-datepicker@1.1.4/dist/js/locales/es.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
