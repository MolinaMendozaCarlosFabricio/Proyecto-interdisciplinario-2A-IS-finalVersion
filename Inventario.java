import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventario {


    public void registroProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
        scanner.nextLine();

        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        
        int id;
        do {
            System.out.print("ID del producto: ");
            id = validarEntero();
            if (id < 0)
                System.out.println("El ID del producto no puede ser negativo. Por favor, ingrese un valor válido.");
        } while (id < 0);

        int exist;
        do {
            System.out.println("cantidad de producto que desea añadir a existencias: ");
            exist = validarEntero();
            if (exist < 0)
            System.out.println("La cantidad añadida es invalida. Por favor, ingrese un valor valido "); 
        } while (exist < 0);

        float precio;
        do {
            System.out.print("Precio del producto: ");
            precio = validarFlotante();
            if (precio < 0)
                System.out.println("El precio del producto no puede ser negativo. Por favor, ingrese un valor válido.");
        } while (precio < 0);

        scanner.nextLine(); 



        System.out.print("Tipo de producto: ");
        String tipo = validarCadena();

        System.out.print("Descripción: ");
        String espesificaciones = validarCadena();

        int departamento;
        Producto producto = null;
        do {
            System.out.println("Departamento de producto:");
            System.out.println("1. Papeleria");
            System.out.println("2. Limpieza");
            System.out.println("3. Higiene");
            System.out.println("4. Bebidas");
            System.out.println("5. Alimentos");
            System.out.print("Seleccione el departamento del producto: ");
            departamento = validarEntero();
            scanner.nextLine();

            switch (departamento) {
                case 1:
                    producto = new Papeleria();
                    break;
                case 2:
                    producto = new Limpieza();
                    break;
                case 3:
                    producto = new Higiene();
                    break;
                case 4:
                    producto = new Bebidas();
                    break;
                case 5:
                    producto = new Alimentos();
                    break;
                default:
                    System.out.println("Departamento no válido. Por favor, seleccione una opción válida.");
            }
        } while (producto == null);

        producto.setNombreProducto(nombre);
        producto.setIdProducto(id);
        producto.setPrecioProducto(precio);
        producto.setTipo(tipo);
        producto.setExistenciasProducto(exist);
        producto.setEspesificaciones(espesificaciones);

        
        if (producto instanceof Papeleria) {
            System.out.print("Descripción: ");
            String descripcion = validarCadena();
            ((Papeleria) producto).setDescripcion(descripcion);
        } else {
            float capacidad;
            do {
                System.out.print("Capacidad en gramos/litros: ");
                capacidad = validarFlotante();
                if (capacidad < 0)
                    System.out.println("La capacidad no puede ser negativa. Por favor, ingrese un valor válido.");
            } while (capacidad < 0);
        
            if (producto instanceof Bebidas) {
                ((Bebidas) producto).setCapacidadLitro(capacidad);
            } else if (producto instanceof Alimentos) {
                ((Alimentos) producto).setCapacidadGramo(capacidad);
            } else if (producto instanceof Higiene) {
                ((Higiene) producto).setCapacidadGramoLitro(capacidad);
            } else if (producto instanceof Limpieza) {
                ((Limpieza) producto).setCapacidadGramoLitro(capacidad);
            }
        }

        scanner.nextLine();

        System.out.print("Nombre del distribuidor: ");
        String distribuidor = validarCadena();

        producto.setDistribuidor(distribuidor);

        int confirmacion;
        do {
            System.out.println("¿Desea confirmar el registro del producto?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            confirmacion = validarEntero();
            if (confirmacion != 1 && confirmacion != 2)
                System.out.println("Opción no válida. Por favor, seleccione 1 para confirmar o 2 para cancelar.");
        } while (confirmacion != 1 && confirmacion != 2);

        if (confirmacion == 1) {
            listaProductos.add(producto);
            System.out.println("Producto registrado exitosamente.");
        } else {
            System.out.println("Registro del producto cancelado.");
        }
    }
    public void modificarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados para modificar.");
            scanner.nextLine();
        }

        System.out.println("Lista de productos registrados:");
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombreProducto());
        }

        System.out.print("Seleccione el número del producto que desea modificar: ");
        int seleccion = validarEntero();
        scanner.nextLine(); 

        if (seleccion < 1 || seleccion > listaProductos.size()) {
            System.out.println("Selección inválida. Por favor, seleccione un número de producto válido.");
            
        }

        Producto productoExistente = listaProductos.get(seleccion - 1);

        // registrar un nuevo producto (reutilizando el código existente)
        Producto nuevoProducto = registrarNuevoProducto(scanner);

        //  Aqui Reemplazamos el producto existente con el nuevo producto en la lista
        listaProductos.set(seleccion - 1, nuevoProducto);

        System.out.println("¿Desea confirmar la modificación del producto?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int confirmacion = validarEntero();
        scanner.nextLine();
    
        if (confirmacion == 1) {
            System.out.println("Producto modificado exitosamente.");
        } else {
           
            listaProductos.set(seleccion - 1, productoExistente);
            System.out.println("Modificación del producto cancelada. El producto sigue siendo el mismo.");
        }
    }

    public Producto registrarNuevoProducto(Scanner scanner) {
        scanner.nextLine();

        System.out.print("Nombre del producto: ");
        String nombre = validarCadena();

        int id;
        do {
            System.out.print("ID del producto: ");
            id = validarEntero();
            if (id < 0)
                System.out.println("El ID del producto no puede ser negativo. Por favor, ingrese un valor válido.");
        } while (id < 0);

        float precio;
        do {
            System.out.print("Precio del producto: ");
            precio = validarFlotante();
            if (precio < 0)
                System.out.println("El precio del producto no puede ser negativo. Por favor, ingrese un valor válido.");
        } while (precio < 0);

        scanner.nextLine();

        System.out.print("Tipo de producto: ");
        String tipo = validarCadena();

        System.out.print("Descripción: ");
        String Descripcion = validarCadena();

        

        
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombreProducto(nombre);
        nuevoProducto.setIdProducto(id);
        nuevoProducto.setPrecioProducto(precio);
        nuevoProducto.setTipo(tipo);
        nuevoProducto.setEspesificaciones(Descripcion);
       

        return nuevoProducto;
        
    }


    public void mostrarProductos(ArrayList<Producto> listaProductos) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados para mostrar.");
            return;
        }
    //aqui falta el llamado para lo que te decia 
        System.out.println("Lista de productos registrados:");
        for (Producto producto : listaProductos) {
            System.out.println("Nombre: " + producto.getNombreProducto());
            System.out.println("ID: " + producto.getIdProducto());
            System.out.println("Precio: " + producto.getPrecioProducto());
            System.out.println("Tipo: " + producto.getTipo());
            System.out.println("Distribuidor: " + producto.getDistribuidor());
            System.out.println("Descripcion: " + producto.getEspesificaciones());
            
            if (producto instanceof Papeleria) {
                Papeleria papeleria = (Papeleria) producto;
                System.out.println("Descripción: " + papeleria.getDescripcion());
            } else if (producto instanceof Bebidas) {
                Bebidas bebida = (Bebidas) producto;
                System.out.println("Capacidad en litros: " + bebida.getCapacidadLitro());
            } else if (producto instanceof Alimentos) {
                Alimentos alimento = (Alimentos) producto;
                System.out.println("Capacidad en gramos: " + alimento.getCapacidadGramo());
            } else if (producto instanceof Higiene) {
                Higiene higiene = (Higiene) producto;
                System.out.println("Capacidad en gramos/litros: " + higiene.getCapacidadGramoLitro());
            } else if (producto instanceof Limpieza) {
                Limpieza limpieza = (Limpieza) producto;
                System.out.println("Capacidad en gramos/litros: " + limpieza.getCapacidadGramoLitro());
            }
        }
    }

    public String obtenerNombreDepartamento(Producto producto) {
        if (producto instanceof Papeleria) {
            return "Papelería";
        } else if (producto instanceof Limpieza) {
            return "Limpieza";
        } else if (producto instanceof Higiene) {
            return "Higiene";
        } else if (producto instanceof Bebidas) {
            return "Bebidas";
        } else if (producto instanceof Alimentos) {
            return "Alimentos";
        } else {
            return "Desconocido";
        }
    }
    
    public void modificarExistencias(Scanner scanner, ArrayList<Producto> listaProductos) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados para modificar existencias.");
            return;
        }
    
        System.out.println("Lista de productos registrados:");
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            System.out.println((i + 1) + ". Nombre: " + producto.getNombreProducto() + ", ID: " + producto.getIdProducto() +
                    ", Departamento: " + obtenerNombreDepartamento(producto) + ", Existencias: " + producto.getExistenciasProducto());
        }
    
        System.out.print("Seleccione el número del producto al que desea modificar existencias: ");
        int seleccion = validarEntero();
        scanner.nextLine();
    
        if (seleccion < 1 || seleccion > listaProductos.size()) {
            System.out.println("Selección inválida. Por favor, seleccione un número de producto válido.");
            return;
        }
    
        Producto productoSeleccionado = listaProductos.get(seleccion - 1);
    
        System.out.println("Ha seleccionado modificar las existencias del producto: " + productoSeleccionado.getNombreProducto());
        System.out.println("Existencias actuales: " + productoSeleccionado.getExistenciasProducto());
    
        System.out.print("Ingrese la cantidad de existencias a agregar o quitar: ");
        int cantidad = validarEntero();
        scanner.nextLine();
    
        
        productoSeleccionado.modificarExistencias(cantidad);
    
        System.out.println("Existencias modificadas exitosamente.");
    }
    
    public void buscarInformacionDeProducto(ArrayList<Producto> listaProductos){
        if(listaProductos.isEmpty()){
            System.out.println("No hay productos");
        }
        else{
            System.out.println("Ingrese la id del producto que desea buscar");
            int idABuscar = validarEntero();
            boolean bandera = false;
            for(Producto productoBuscado : listaProductos){
                if(productoBuscado.getIdProducto()==idABuscar){
                    System.out.println("Nombre: " + productoBuscado.getNombreProducto());
                    System.out.println("ID: " + productoBuscado.getIdProducto());
                    System.out.println("Precio: " + productoBuscado.getPrecioProducto());
                    System.out.println("Departamebto: " + obtenerNombreDepartamento(productoBuscado));
                    System.out.println("Tipo: " + productoBuscado.getTipo());
                    System.out.println("Distribuidor: " + productoBuscado.getDistribuidor());
                    System.out.println("Existencias: " + productoBuscado.getExistenciasProducto());
                    if (productoBuscado instanceof Bebidas) {
                        Bebidas bebida = (Bebidas) productoBuscado;
                        System.out.println("Capacidad: " + bebida.getCapacidadLitro());
                    }
                    if (productoBuscado instanceof Alimentos) {
                        Alimentos alimento = (Alimentos) productoBuscado;
                        System.out.println("Capacidad: " + alimento.getCapacidadGramo());
                    }
                    if (productoBuscado instanceof Higiene) {
                        Higiene obHigiene = (Higiene) productoBuscado;
                        System.out.println("Capacidad: " + obHigiene.getCapacidadGramoLitro());
                    }
                    if (productoBuscado instanceof Limpieza) {
                        Limpieza objLimpieza = (Limpieza) productoBuscado;
                        System.out.println("Capacidad: " + objLimpieza.getCapacidadGramoLitro());
                    }
                    if (productoBuscado instanceof Papeleria) {
                        Papeleria utiles = (Papeleria) productoBuscado;
                        System.out.println("Descripcion: " + utiles.getDescripcion());
                    }
                    bandera = true;
                }
            }
            if(bandera==false){
                System.out.println("No se encontro el producto");
            }
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

    public float validarFlotante(){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo=true;
        float flotante=0;
        do{
            try{
                flotante = entrada.nextFloat();
                continuarCiclo=false;
            }
            catch(InputMismatchException e){
                System.err.printf("\nExcepcion: %s\n", e);
                System.out.println("Ingrese un decimal valido");
                entrada.nextLine();
            }
        }while(continuarCiclo);
        return flotante;
    }

    
}
