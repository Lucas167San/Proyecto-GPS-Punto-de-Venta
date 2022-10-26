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
    private int CodBarras;
    private String Descripcion;
    private double precio;
    private int cantidad;
    private int importe;
    private int existencia;
    private String departamento;

    public Producto(int CodBarras, String Descripcion, double precio, int cantidad, int importe, int existencia, String departamento) {
        this.CodBarras = CodBarras;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
        this.existencia = existencia;
        this.departamento = departamento;
    }

    

    public int getCodBarras() {
        return CodBarras;
    }

    public void setCodBarras(int CodBarras) {
        this.CodBarras = CodBarras;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String toString()
    {
        return "Codigo de barras: " + CodBarras + "\n\n "
                + "Descripcion del producto: " + Descripcion + "\n\n "
                + "Precio venta: " + precio + "\n\n "
                + "Cantidad: " + cantidad + "\n\n "
                + "Importe: " + importe + "\n\n "
                + "Existencia: " + existencia + "\n\n " 
                + "Departamento: " + departamento + "";
    }
}
