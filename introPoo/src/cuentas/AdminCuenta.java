package cuentas;

import javax.swing.JOptionPane;

public class AdminCuenta {

    static Cuenta objCuenta;

    public static void main(String[] args) {
        int op;
        do {
            op = opcion();
            switch (op) {
                case 1:
                    registrarCuenta();
                    break;
                case 2:
                    consignar();
                    break;
                case 3:
                    retirar();
                    break;
                case 4:
                    mostrar();
                    break;
            }
        } while (op != 5);
    }

    public static int opcion() {
        int opcion;
        String menu = "Seleccione una opción:\n";
        menu += "1.: Registrar cuenta\n";
        menu += "2: Consignar en la cuenta\n";
        menu += "3: Retirar de la cuenta\n";
        menu += "4: Mostrar cuenta\n";
        menu += "5: Salir";
        opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return opcion;
    }

    public static void registrarCuenta() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo"));
        int titular = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del titular"));
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo de la cuenta"));
        int retiros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de retiros"));
        if (retiros == 0) {
            objCuenta = new Cuenta();
            objCuenta.setCodigo(codigo);
            objCuenta.setTitular(titular);
            objCuenta.setSaldo(saldo);
        } else {
            if (retiros >= 1 && retiros <= 4) {
                objCuenta = new Cuenta(codigo, titular, retiros, saldo);
            } else {
                int vector[] = new int[retiros];
                objCuenta = new Cuenta(codigo, titular, vector, saldo);
            }
        }
        JOptionPane.showMessageDialog(null, "Cuenta registrada exitosamente");
    }

    public static void consignar() {
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la consignacion"));
        if (objCuenta.consignar(valor)) {
            JOptionPane.showMessageDialog(null, "Consignación registrada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al consignar");
        }
    }

    public static void retirar() {
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a retirar"));
        String out = objCuenta.retirar(valor);
        JOptionPane.showMessageDialog(null, out);
    }

    public static void mostrar() {
        if (objCuenta == null) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar informacion de la cuenta");
        } else {
            String out = objCuenta.listarInformacion();
            JOptionPane.showMessageDialog(null, out);
        }
    }
}
