const txtFecha = document.getElementById('txtFecha');

const datepicker = new Datepicker(txtFecha, {
  buttonClass: 'btn',
  language: 'es',
  format: 'yyyy/mm/dd',
  autohide: true,
});

(function () {
  'use strict'

  let forms = document.querySelectorAll('.needs-validation')

  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()