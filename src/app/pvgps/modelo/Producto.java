/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.pvgps.modelo;

/**
 *
 * @author luxxo
 */
public class Producto {
    private String CodBarras;
    private String Descripcion;
    private double Precio;
    private double Importe;
    private int prod_existencia;

    public Producto(String CodBarras, String Descripcion, double Precio, double Importe, int prod_existencia) {
        this.CodBarras = CodBarras;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Importe = Importe;
        this.prod_existencia = prod_existencia;
    }

    

    public String getCodBarras() {
        return CodBarras;
    }

    public void setCodBarras(String CodBarras) {
        this.CodBarras = CodBarras;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }

    

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double importe) {
        this.Importe = importe;
    }

    public int getExistencia() {
        return prod_existencia;
    }

    public void setExistencia(int existencia) {
        this.prod_existencia = existencia;
    }

    
    public String toString()
    {
        return "Codigo de barras: " + CodBarras + "\n\n "
                + "Descripcion del producto: " + Descripcion + "\n\n "
                + "Precio venta: " + Precio + "\n\n "
                + "Importe: " + Importe + "\n\n "
                + "Existencia: " + prod_existencia;
    }
}
