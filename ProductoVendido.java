public class ProductoVendido {
    private String nombreProducto;
    private int iDproductoVendido, cantProductoVendido;
    private float precioProductoVendido;

    ProductoVendido (String name, int id, int cantidad, float precio){
        this.nombreProducto=name;
        this.iDproductoVendido=id;
        this.cantProductoVendido=cantidad;
        this.precioProductoVendido=precio;
    }

    public void setCantProductoVendido(int cantProductoVendido) {
        this.cantProductoVendido = cantProductoVendido;
    }

    public int getiDproductoVendido() {
        return iDproductoVendido;
    }

    public int getCantProductoVendido() {
        return cantProductoVendido;
    }

    public void leerProductoRecibo (){
        System.out.println(nombreProducto + "x" + cantProductoVendido + "\t" + cantProductoVendido*precioProductoVendido);
    }

    public void leerProductoVendido (){
        System.out.println(nombreProducto + "\t " + iDproductoVendido + "\t " + precioProductoVendido + "\t " + cantProductoVendido + "\t" + cantProductoVendido*precioProductoVendido);
    }
}
