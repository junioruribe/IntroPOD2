package articulos;

import Productos.*;

public class Articulo {

    private int codigo;
    private String nombre;
    private static Categoria tipo;
    private int valor;
    private double descuento;
    private byte cantidad;
    public static boolean estado=true;
    //<editor-fold defaultstate="collapsed" desc="constructores de la clase">
    
    public Articulo() {
        this.codigo = 0;
        this.nombre = "";
        this.tipo = null;
        this.valor = 0;
        this.descuento = 0.0;
        this.cantidad = 0;
        estado = true;
    }

    public Articulo(int codigo, String nombre, Categoria tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Articulo(int codigo, String nombre, Categoria tipo, int valor, byte cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public Articulo(int codigo, String nombre, int valor, byte cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
    }
    
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter and setter">
    
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

    public Categoria getTipo() {
        return tipo;
    }

    public void setTipo(Categoria tipo) {
        this.tipo = tipo;
    }

    public byte getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getDescuento() {
        return descuento;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    private int calcularVenta() {
        return cantidad * valor;
    }

    public void calcularDescuento() {
        if (cantidad < 10) {
            descuento = calcularVenta() * 0.05;
        } else if (cantidad >= 10 && cantidad <= 30) {
            descuento = calcularVenta() * 0.10;
        } else {
            descuento = calcularVenta() * 0.15;
        }
    }

    public void calcularDescuento(byte valorDescuento) {
        descuento = ((double)valorDescuento / 100) * calcularVenta();
    }

    public int calcularTotal() {
        int resta;
        resta = (int) (calcularVenta() - descuento);
        return resta;
    }

    public static void cambiarCategoria(Categoria  cat) {
        tipo = cat;
    }

    public String listarinformacion() {
        String out = "Informacion del producto. \n";
        out += "Codigo: " + codigo + "\n";
        out += "Nombre: " + nombre + "\n";
        out += "Tipo: " + tipo.getNombre() + "\n";
        out += "Estado: " + estado + "\n";
        out += "Valor: " + valor + "\n";
        out += "Cantidad: " + cantidad + "\n";
        out += "Valor del descuento: " + descuento + "\n";
        out += "Valor total: " + calcularTotal();
        return out;
    }
    //</editor-fold>
}
