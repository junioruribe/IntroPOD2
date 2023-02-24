
package inicio;

import articulos.Articulo;
import articulos.Categoria;
import javax.swing.JOptionPane;


public class AdminArticulo {
    
    public static void main(String[] args) {
        
     int codigo,valor;
     String nombre,descripcion;
     byte cantidad;
     Articulo objArt;
     
     codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingre el codigo"));
     valor = Integer.parseInt(JOptionPane.showInputDialog("Ingre el valor"));
     nombre = JOptionPane.showInputDialog("Ingrese el nombre");
     cantidad = Byte.parseByte(JOptionPane.showInputDialog("Ingrese la cantidad"));
     objArt =  new Articulo(codigo, nombre, valor, cantidad);
     objArt.calcularDescuento();
     
     codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la categoria"));
     nombre = JOptionPane.showInputDialog("Ingrese el nombre de la categoria");
    descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la categoria");
    Categoria objCat = new Categoria();
    objCat.setCodigo(codigo);
    objCat.setNombre(nombre);
    objCat.setDescripcion(descripcion);
    objCat.setEstado(true);
    objArt.setTipo(objCat);
    
    JOptionPane.showMessageDialog(null, objArt.listarinformacion());
}
}