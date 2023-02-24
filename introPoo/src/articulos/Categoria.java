
package articulos;

public class Categoria {
    private int codigo;
    private String nombre;
    private String descripcion;
    private boolean estado;
//<editor-fold defaultstate="collapsed" desc="Constructores">
    

    public Categoria() {
    }

    public Categoria(int codigo, String nombre, String descripcion, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Categoria(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    
    
    //</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //</editor-fold>
}
