package beans;

public class TipoCreditoDTO {

    private int codigo;
    private String descripcion;
    private String terminos;

    public TipoCreditoDTO(int codigo, String descripcion, String terminos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.terminos = terminos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }

}
