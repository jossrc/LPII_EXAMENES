package beans;

public class SolicitudDTO {

    private String codigo;
    private String fecha;
    private double monto;
    private String observacion;
    private int codigoCliente;
    private int codigoTipoCredito;

    public SolicitudDTO(String codigo, String fecha, double monto, String observacion, int codigoCliente,
            int codigoTipoCredito) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
        this.observacion = observacion;
        this.codigoCliente = codigoCliente;
        this.codigoTipoCredito = codigoTipoCredito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoTipoCredito() {
        return codigoTipoCredito;
    }

    public void setCodigoTipoCredito(int codigoTipoCredito) {
        this.codigoTipoCredito = codigoTipoCredito;
    }

}
