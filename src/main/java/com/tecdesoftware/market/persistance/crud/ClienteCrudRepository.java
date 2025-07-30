package com.tecdesoftware.market.persistance.crud;

import com.tecdesoftware.market.persistance.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

    /**
     * Busca un cliente por su correo electrónico
     * @param correoElectronico el correo electrónico del cliente
     * @return Optional conteniendo el cliente si existe
     */
    Optional<Cliente> findByCorreoElectronico(String correoElectronico);

    /**
     * Busca clientes cuyo correo electrónico contenga el texto especificado
     * @param correoElectronico parte del correo electrónico a buscar
     * @return Lista de clientes encontrados
     */
    List<Cliente> findByCorreoElectronicoContaining(String correoElectronico);

    /**
     * Busca clientes por nombre (ignora mayúsculas/minúsculas)
     * @param nombre el nombre a buscar
     * @return Lista de clientes encontrados
     */
    List<Cliente> findByNombreIgnoreCase(String nombre);

    /**
     * Busca clientes por nombre y apellidos
     * @param nombre el nombre del cliente
     * @param apellidos los apellidos del cliente
     * @return Lista de clientes encontrados
     */
    List<Cliente> findByNombreAndApellidosIgnoreCase(String nombre, String apellidos);

    /**
     * Busca clientes cuyo nombre contenga el texto especificado
     * @param nombre parte del nombre a buscar
     * @return Stream de clientes encontrados
     */
    Stream<Cliente> findByNombreContainingIgnoreCase(String nombre);

    /**
     * Verifica si existe un cliente con el correo electrónico especificado
     * @param correoElectronico el correo electrónico a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByCorreoElectronico(String correoElectronico);

    /**
     * Cuenta el número de clientes que tienen compras
     * @return número de clientes con compras
     */
    long countByComprasIsNotEmpty();
}