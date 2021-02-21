/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesProveedor;

/**
 *
 * @author stali
 */
public class Proveedor {
    private String RUC;
    private String razon_Social;
    private String direccion;
    private String correo;
    private String telefono;
    private String contacto;

    public Proveedor(String RUC, String razon_Social, String direccion, String correo, String telefono, String contacto) {
        this.RUC = RUC;
        this.razon_Social = razon_Social;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.contacto = contacto;
    }

   
    
    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazon_Social() {
        return razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    
}
