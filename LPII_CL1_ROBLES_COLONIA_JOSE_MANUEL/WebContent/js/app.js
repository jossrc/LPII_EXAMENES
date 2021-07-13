const shippingDate = document.getElementById('shipping-date');
const shippingCode = document.getElementById('shipping-code');

const shippingForm = document.getElementById('shipping-form');

const datepicker = new Datepicker(shippingDate, {
  buttonClass: 'btn',
  language: 'es',
  format: 'yyyy/mm/dd',
  autohide: true,
});

(function () {
  'use strict';
  let forms = document.querySelectorAll('.needs-validation');

  Array.prototype.slice.call(forms).forEach(function (form) {
    form.addEventListener(
      'submit',
      function (event) {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        } else {
          event.preventDefault();
          const formData = new FormData(shippingForm);
          formData.append('opcion', 'registrar');

          Swal.fire({
            title: '\u00A1Registrar Env\u00EDo!',
            text: `\u00bfDesea registrar el env\u00EDo ${shippingCode.value} a la BD?`,
            icon: 'question',
            showCancelButton: true,
            confirmButtonText: 'Aceptar',
            cancelButtonText: 'Cancelar',
          }).then((confirmShipment) => {
            if (confirmShipment.value) {
              fetch('shipping', {
                method: 'POST',
                body: formData,
              })
                .then((resp) => {
                  if (resp.ok) {
                    Swal.fire(
                      'Registrado',
                      `Se ha registrado el env\u00EDo ${shippingCode.value} correctamente`,
                      'success'
                    );
                    form.reset();
                  } else {	
	                resp.text().then((errorMessage) => {
		              Swal.fire(
                        'Error',
                        `Error - ${errorMessage}`,
                        'error'
                      );
	                })
                  }

                  if (form.classList.contains('was-validated')) {
                    form.classList.remove('was-validated');
                    return;
                  }
                })
                .catch((err) => {
	              console.log(err);
                  Swal.fire(
                    'Error',
                    `Oops, sucedi\u00F3 un error inesperado`,
                    'error'
                  );
                });
            }
          });
        }

        form.classList.add('was-validated');
      },
      false
    );
  });
})();
