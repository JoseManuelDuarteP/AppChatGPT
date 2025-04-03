package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.PropietarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    private static PropietarioService propietarioService;
    PropietarioController(PropietarioService propietarioService) {
        PropietarioController.propietarioService = propietarioService;
    }

    @GetMapping
    public static List<Propietario> listar() {
        return propietarioService.listarPropietarios();
    }

    @PostMapping
    public static void agregar(@RequestBody Propietario propietario) {
        propietarioService.agregarPropietario(propietario);
    }

    @DeleteMapping("/{id}")
    public static void eliminar(@PathVariable Long id) {
        propietarioService.eliminarPropietario(id);
    }

    public static void menuPropietario() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != -1) {
            System.out.println("1. Agregar propietario");
            System.out.println("2. Listar propietarios");
            System.out.println("3. Eliminar propietario");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                agregar(new Propietario(nombre));
            } else if (opcion == 2) {
                listar().forEach(System.out::println);
            } else if (opcion == 3) {
                System.out.println("ID de usuario a eliminar: ");
                Long idUsuario = scanner.nextLong();
                eliminar(idUsuario);
            }
        }
    }
}