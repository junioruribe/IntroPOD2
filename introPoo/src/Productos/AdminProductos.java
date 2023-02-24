package Productos;

import javax.swing.JOptionPane;

public class AdminProductos {

    public static void main(String[] args) {
        int codigo, valor;
        double descuento;
        byte cantidad;
        String nombre, categoria, estado;
        Producto obj1;

        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo Producto1: "));
        nombre = JOptionPane.showInputDialog("Ingrese nombre Producto1: ");
        categoria = JOptionPane.showInputDialog("Ingrese categoria Producto1: ");

        obj1 = new Producto(codigo, nombre, categoria);

        valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor Producto1: "));
        cantidad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese cantidad Producto1: "));

        obj1.setValor(valor);
        obj1.setCantidad(cantidad);
        obj1.calcularDescuento();
        JOptionPane.showMessageDialog(null, obj1.listarinformacion());
        valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo valor de producto1: "));
        obj1.setValor(valor);

        Producto obj2;
        codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo: "));
        nombre = JOptionPane.showInputDialog("Ingrese nombre Producto2: ");
        categoria = JOptionPane.showInputDialog("Ingrese categoria Producto2: ");
        valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor Producto2: "));
        cantidad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese cantidad Producto2: "));
        obj2 = new Producto(codigo, nombre, categoria, valor, cantidad);
        obj2.calcularDescuento();
        JOptionPane.showMessageDialog(null, obj2.listarinformacion());

        descuento = Double.parseDouble(JOptionPane.showInputDialog("Porcentaje del descuento (0-50): "));
        if (obj1.getValor() > obj2.getValor()) {
            obj1.calcularDescuento((byte) descuento);
            JOptionPane.showMessageDialog(null, obj1.listarinformacion());
        } else {
            obj2.calcularDescuento((byte) descuento);
            JOptionPane.showMessageDialog(null, obj2.listarinformacion());
        }
        estado = JOptionPane.showInputDialog("Ingresar estado (True/False): ");
        Producto.estado = estado.equalsIgnoreCase("true") ? true : false;
        JOptionPane.showMessageDialog(null, obj1.listarinformacion()+"\n\n"
                                            +obj2.listarinformacion());
        categoria=JOptionPane.showInputDialog("Ingresar nueva categoria producto1");
        obj1.setCategoria(categoria);
        JOptionPane.showMessageDialog(null, obj1.listarinformacion());
        categoria=JOptionPane.showInputDialog("Ingresar nueva categoria producto");
        Producto.cambiarCategoria(categoria);
        JOptionPane.showMessageDialog(null, obj1.listarinformacion()+"\n\n"
                                            +obj2.listarinformacion());
    }

}
