import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ventas {
    ArrayList <ProductoVendido> conteoDeCaja = new ArrayList<>();
    public void vender (Scanner scanner, ArrayList<Producto> listaProductos){
        ArrayList<ProductoVendido> reciboDelCliente = new ArrayList<>();
        int continuar = 0;
    
        do {
            boolean banderaDeBusqueda = false;
            System.out.println("Ingrese la id del producto a vender");
            int ingresoId = validarEntero();
            for (Producto productoBuscado : listaProductos) {
                if (productoBuscado.getIdProducto() == ingresoId) {
                    System.out.println("Vendiendo " + productoBuscado.getNombreProducto());
                    System.out.println("Ingrese la cantidad de unidades a vender");
                    int cantAVender;
                    do {
                        cantAVender = validarEntero();
                        if (cantAVender > productoBuscado.getExistenciasProducto()) {
                            System.out.println("Cantidad solicitada superior a la cantidad disponible en existencia.");
                            System.out.println("Ingrese una cantidad válida: ");
                        }
                    } while (cantAVender > productoBuscado.getExistenciasProducto());
    
                    System.out.println("El precio total es " + productoBuscado.getPrecioProducto() * cantAVender);
                    System.out.println("Confirmar compra ingresando 1");
                    int confirmacion = validarEntero();
                    if (confirmacion == 1) {
                        productoBuscado.setExistenciasProducto(productoBuscado.getExistenciasProducto() - cantAVender);
                        ProductoVendido objRecibo = new ProductoVendido(productoBuscado.getNombreProducto(), ingresoId, cantAVender, productoBuscado.getPrecioProducto());
                        reciboDelCliente.add(objRecibo);
                        registrarVenta(productoBuscado, ingresoId, cantAVender, reciboDelCliente);
                    } else {
                        System.out.println("Cancelando venta");
                    }
                    banderaDeBusqueda = true;
                }
            }
            if (!banderaDeBusqueda) {
                System.out.println("No se encontró el producto");
            }
            System.out.println("¿Vender otro producto? (Ingrese 1 para continuar, cualquier otro número para salir)");
            continuar = validarEntero();
        } while (continuar == 1);
    
        if (reciboDelCliente.isEmpty()) {
            System.out.println("No se ha vendido nada");
        } else {
            System.out.println("Realizando venta");
            imprimirTicket(reciboDelCliente);
        }
    }

    public void registrarVenta (Producto objProducto, int id, int cantidadVendida, ArrayList<ProductoVendido> reciboDelCliente){
        boolean productoVendidoEncontrado = false;
        for(ProductoVendido buscaProductoVendido : conteoDeCaja){
            if(buscaProductoVendido.getiDproductoVendido() == id){
                buscaProductoVendido.setCantProductoVendido(buscaProductoVendido.getCantProductoVendido()+cantidadVendida);
                productoVendidoEncontrado = true;
            }
        }
        if(!productoVendidoEncontrado){
            ProductoVendido objProductoVendido = new ProductoVendido(objProducto.getNombreProducto(), objProducto.getIdProducto(), cantidadVendida, objProducto.getPrecioProducto());
            conteoDeCaja.add(objProductoVendido);
        }
    }

    public void imprimirTicket (ArrayList<ProductoVendido> reciboDelCliente){
        System.out.println("Imprimiendo recibo...");
        System.out.println("Nombre y cantidad de producto:\tTotal del producto:");
        for(ProductoVendido reciboImprimiendo : reciboDelCliente){
            reciboImprimiendo.leerProductoRecibo();;
        }
    }

    public void leerVentas (Scanner scanner){
        if(conteoDeCaja.isEmpty()){
            System.out.println("No se ha vendido ningun producto");
        }
        else{
            System.out.println("Nombre del producto:\tID del producto:\tPrecio por unidad:\tUnidades vendidas:\tTotal por el producto:");
            for(ProductoVendido conteoLeido : conteoDeCaja){
                conteoLeido.leerProductoVendido();
            }
        }
        System.out.println("Ingrese 'si' para realizar corte del dia");
        String realizarCorte = validarCadena();
        if(realizarCorte.equals("si")){
            System.out.println("Finalizando corte");
            conteoDeCaja.clear();
        }
    }

        public int validarEntero(){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo=true;
        int numero=0;
        do{
            try{
                numero = entrada.nextInt();
                continuarCiclo=false;
            }
            catch(InputMismatchException e){
                System.err.printf("\nExcepcion: %s\n", e);
                System.out.println("Ingrese un numero valido");
                entrada.nextLine();
            }
        }while(continuarCiclo);
        return numero;
    }

    public String validarCadena(){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo=true;
        String cadena=null;
        do{
            try{
                cadena = entrada.nextLine();
                continuarCiclo=false;
            }
            catch(InputMismatchException e){
                System.err.printf("\nExcepcion: %s\n", e);
                System.out.println("Ingrese una cadena valida");
                entrada.nextLine();
            }
        }while(continuarCiclo);
        return cadena;
    }

}
