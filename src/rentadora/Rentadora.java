package rentadora;

import java.util.List;

public interface Rentadora {
    void agregarVehiculo(Vehiculo vehiculo);

    void mostrarCatalogo();

    List<Vehiculo> buscarPorMarca(String marca);

    List<Vehiculo> buscarPorModelo(String modelo);

    Vehiculo buscarPorId(String id);



    void alquilar(String id);

    void devolver(String id);

    void eliminarVehiculo(String id);





}
