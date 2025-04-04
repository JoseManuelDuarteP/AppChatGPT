package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.CocheService;
import org.ieselcaminas.jpa.services.Color;
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
            System.out.println(Color.AMARILLO.getColor());
            System.out.println("-- MENÚ DE PROPIETARIOS --");
            System.out.print(Color.RESET.getColor());
            System.out.println("1. Agregar propietario");
            System.out.println("2. Listar propietarios");
            System.out.println("3. Eliminar propietario");
            System.out.println("4. Asignar coche");
            System.out.println("5. Ver mis coches");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

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
            } else if (opcion == 4) {
                listar().forEach(System.out::println);
                System.out.println("Seleccione ID de usuario:");
                Long idUsuario = scanner.nextLong();

                CocheController.listar().forEach(System.out::println);
                System.out.println("Seleccione ID de coche:");
                Long idCoche = scanner.nextLong();

                Coche coche = CocheController.buscarPorId(idCoche);
                Propietario propietario = propietarioService.encontrarPropietario(idUsuario);

                coche.setPropietario(propietario);
                CocheController.agregar(coche);
            } else if (opcion == 5) {
                System.out.println("Seleccione su ID:");
                Propietario pro = propietarioService.encontrarPropietario(scanner.nextLong());

                for (Coche c : pro.getCoches()) {
                    System.out.println(c);
                }
            }
        }
    }
}