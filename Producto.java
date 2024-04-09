public class Producto {
    protected String nombreProducto, marca, distribuidor, tipo, espesificaciones;
    protected int idProducto, existenciasProducto;
    protected float precioProducto;
    

    public String getDistribuidor() {
        return distribuidor;
    }
    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }
    public int getExistenciasProducto() {
        return existenciasProducto;
    }
    public void setExistenciasProducto(int existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public float getPrecioProducto() {
        return precioProducto;
    }
    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getEspesificaciones() {
        return espesificaciones;
    }
    public void setEspesificaciones(String espesificaciones) {
        this.espesificaciones = espesificaciones;
    }

    public void modificarExistencias(int cantidad) {
        this.existenciasProducto += cantidad;
    }




}