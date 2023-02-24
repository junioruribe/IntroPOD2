package cuentas;

public class Cuenta {

    private int codigo;
    private int titular;
    private int[] retiros;
    private String consignaciones = "";
    private double saldo;

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Cuenta() {
        this.retiros = new int[4];
    }

    public Cuenta(int codigo, int titular, int cantidadRetiros, double saldo) {
        this.codigo = codigo;
        this.titular = titular;
        this.retiros = new int[cantidadRetiros];
        this.saldo = saldo;
    }

    public Cuenta(int codigo, int titular, int[] retiros, double saldo) {
        this.codigo = codigo;
        this.titular = titular;
        this.retiros = retiros;
        this.saldo = saldo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int[] getRetiros() {
        return retiros;
    }

    public String getConsignaciones() {
        return consignaciones;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public boolean consignar(int valor) {
        if (valor >= 0) {
            saldo = saldo + valor;
            consignaciones += valor + " , ";
            return true;
        }
        return false;
    }

    private int retirosDisponibles() {
        int conteo = 0;
        for (int i = 0; i < retiros.length; i++) {
            if (retiros[i] == 0) {
                conteo++;
            }
        }
        return conteo;
    }

    public String retirar(int valor) {
        String out;
        if (retirosDisponibles() > 0) {
            if (valor > 0) {
                if (saldo >= valor) {
                    saldo = saldo - valor;
                    for (int i = 0; i < retiros.length; i++) {
                        if (retiros[i] == 0) {
                            retiros[i] = valor;
                            break;
                        }
                    }
                    out = "Retiro exitoso, saldo disponible: " + saldo;
                } else {
                    out = "Su saldo es:" + saldo;
                }
            } else {
                out = "Error. Valor incorrecto";
            }
        } else {
            out = "No tiene retiros disponibles";
        }
        return out;
    }

    public String listarInformacion() {
        String out = "Información de la cuenta:\n";
        out += "Codigo: " + codigo + "\n";
        out += "Titular: " + titular + "\n";
        out += "Saldo: " + saldo + "\n";
        out += "Retiros: \n"+ getRetiro() + "\n";
        out += "Retiros disponibles: " + retirosDisponibles() + "\n";
        out += "Consignaciones: " + consignaciones;

        return out;
    }

    private String getRetiro() {
        String out = "";
        for (int i = 0; i < retiros.length; i++) {
            if (retiros[i] > 0) {
                out += "Retiro " + (i + 1) + ":" + retiros[i] + "\n";
            }
        }
        return out;
    }
    //</editor-fold>
}
