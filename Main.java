import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Inventario iniciarInventario = new Inventario();
        Ventas iniciarVentas = new Ventas();
        int opcion;

        do {
            
            System.out.println("Menú:");
            System.out.println("1. Registrar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Modificar existencias");
            System.out.println("5. Buscar información de producto");
            System.out.println("6. Vender");
            System.out.println("7. Ver registro de ventas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = validarEntero();

            
            switch (opcion) {
                case 1:
                System.out.println("Ha seleccionado la opción 1");
                    iniciarInventario.registroProducto(scanner, listaProductos);
                    break;
                case 2:
                    System.out.println("Ha seleccionado la opción 2");
                    iniciarInventario.modificarProducto(scanner, listaProductos);
                    break;
                case 3:
                    System.out.println("Ha seleccionado la opción 3");
                    iniciarInventario.mostrarProductos(listaProductos);
                    break;
                case 4:
                    System.out.println("Ha seleccionado la opción 4");
                    iniciarInventario.modificarExistencias(scanner, listaProductos);
                    break;
                case 5:
                    System.out.println("Ha seleccionado la opción 5");
                    iniciarInventario.buscarInformacionDeProducto(listaProductos);
                    break;
                case 6:
                    System.out.println("Ha seleccionado la opción 6");
                    iniciarVentas.vender(scanner, listaProductos);
                    break;
                case 7:
                    System.out.println();
                    iniciarVentas.leerVentas(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 8);

        scanner.close();
        
    }

        public static int validarEntero(){
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

}
