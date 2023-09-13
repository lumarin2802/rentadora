package rentadora;

import java.util.ArrayList;
import java.util.List;

public class RentadoraImpl implements Rentadora{

    private List<Vehiculo> vehiculos;

    public RentadoraImpl() {
        this.vehiculos = new ArrayList<>();
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado al catálogo. ID: "+vehiculo.getId() + vehiculo.getMarca() + vehiculo.getModelo());

    }

    @Override
    public void mostrarCatalogo() {
        System.out.println("Catálogo de vehículos disponible: ");
        for (Vehiculo vehiculo: this.vehiculos){
            System.out.println("ID: "+ vehiculo.getId()+ vehiculo.getMarca()+vehiculo.getModelo());
        }

    }

    @Override
    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> vehiculoPorMarca = new ArrayList<>();
        for (Vehiculo vehiculo: this.vehiculos){
            if (vehiculo.getMarca().equals(marca)){
                vehiculoPorMarca.add(vehiculo);
            }
        }
        return vehiculoPorMarca;
    }

    @Override
    public List<Vehiculo> buscarPorModelo(String modelo) {
        List<Vehiculo> vehiculoPorModelo = new ArrayList<>();
        for (Vehiculo vehiculo: this.vehiculos){
            if (vehiculo.getModelo().equals(modelo)){
                vehiculoPorModelo.add(vehiculo);
            }
        }
        return vehiculoPorModelo;
    }

    @Override
    public Vehiculo buscarPorId(String id) {
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo: this.vehiculos){
            if (vehiculo.getId()==id){
                vehiculoEncontrado=vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }

    @Override
    public void alquilar(String id) {
        Vehiculo vehiculo = buscarPorId(id);
        if (vehiculo != null && vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            System.out.println("Se ha alquilado el vehiculo con ID: " + vehiculo.getId() + ", Marca: " + vehiculo.getMarca());
        }else {
            System.out.println("El vehiculo no esta disponible para alquilar.");
        }
    }


    @Override
    public void devolver(String id) {
        Vehiculo vehiculo = buscarPorId(id);
        if (vehiculo != null && !vehiculo.isDisponible()) {
            vehiculo.setDisponible(true);
            System.out.println("Se ha devuelto el vehiculo con ID: " + vehiculo.getId() + ", Marca: " + vehiculo.getMarca());
        }else {
            System.out.println("El vehiculo no se puede devolver");
        }
    }


    @Override
    public void eliminarVehiculo(String id) {

        Vehiculo vehiculo = buscarPorId(id);
        this.vehiculos.remove(vehiculo);
        System.out.println("Vehículo eliminado del catálogo. ID: " + vehiculo.getId()+vehiculo.getModelo()+vehiculo.getMarca());
    }
}
