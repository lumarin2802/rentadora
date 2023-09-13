import rentadora.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("001", "Toyota", "Corolla");
        Auto auto2 = new Auto("002", "Honda", "Civic");
        Camion camion1 = new Camion("003", "Ford", "F-150");
        Moto moto1 = new Moto("004", "Yamaha", "YZF-R6");
        Omnibus omnibus1 = new Omnibus("005", "Mercedes-Benz", "Tourismo");

        Rentadora rentadora = new RentadoraImpl();
        rentadora.agregarVehiculo(auto1);
// Salida esperada: Vehículo agregado al catálogo. ID: 001,

//        Marca:
//        Toyota, Modelo:Corolla

        rentadora.agregarVehiculo(auto2);
// Salida esperada: Vehículo agregado al catálogo. ID: 002,

//        Marca:
//        Honda, Modelo:Civic
        rentadora.agregarVehiculo(camion1);
// Salida esperada: Vehículo agregado al catálogo. ID: 003,

//        Marca:
//        Ford, Modelo:F - 150

        rentadora.agregarVehiculo(moto1);
// Salida esperada: Vehículo agregado al catálogo. ID: 004,

//        Marca:
//        Yamaha, Modelo:YZF - R6

        rentadora.agregarVehiculo(omnibus1);
// Salida esperada: Vehículo agregado al catálogo. ID: 005,

        //Marca: Mercedes-Benz, Modelo: Tourismo

        rentadora.mostrarCatalogo();
// Salida esperada: Catálogo de vehículos disponibles:
// ID: 001, Marca: Toyota, Modelo: Corolla
// ID: 002, Marca: Honda, Modelo: Civic
// ID: 003, Marca: Ford, Modelo: F-150
// ID: 004, Marca: Yamaha, Modelo: YZF-R6
// ID: 005, Marca: Mercedes-Benz, Modelo: Tourismo

        List<Vehiculo> autos = rentadora.buscarPorMarca("Toyota");
        System.out.println("Autos de marca Toyota encontrados: " +

                autos.size());

// Salida esperada: Autos de marca Toyota encontrados: 1

        List<Vehiculo> motos = rentadora.buscarPorMarca("Yamaha");
        System.out.println("Motos de marca Yamaha encontradas: " +

                motos.size());

// Salida esperada: Motos de marca Yamaha encontradas: 1

        Vehiculo vehiculo = rentadora.buscarPorId("003");
        if (vehiculo != null) {
            System.out.println("Vehículo encontrado: " +
                    vehiculo.getMarca() + " " + vehiculo.getModelo());

        } else {
            System.out.println("Vehículo no encontrado.");
        }
// Salida esperada: Vehículo encontrado: Ford F-150

        rentadora.alquilar("001");
// Salida esperada: Se ha alquilado el vehículo con ID: 001,

        //Marca: Toyota

        rentadora.devolver("001");
// Salida esperada: Se ha devuelto el vehículo con ID: 001,

        //Marca: Toyota

        rentadora.eliminarVehiculo("005");
// Salida esperada: Vehículo eliminado del catálogo. ID: 005,

        //Marca: Mercedes-Benz, Modelo: Tourismo
    }
}