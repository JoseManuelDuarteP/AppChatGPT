package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.CocheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/coches")
public class CocheController {

    private static CocheService cocheService;
    CocheController(CocheService cocheService) {
        CocheController.cocheService = cocheService;
    }

    @GetMapping
    public static List<Coche> listar() {
        return cocheService.listarCoches();
    }

    @PostMapping
    public static void agregar(@RequestBody Coche coche) {
        cocheService.agregarCoche(coche);
    }

    @DeleteMapping("/{id}")
    public static void eliminar(@PathVariable Long id) {
        cocheService.eliminarCoche(id);
    }

    public static void menuCoche() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != -1) {
            System.out.println("1. Agregar coche");
            System.out.println("2. Listar coches");
            System.out.println("3. Eliminar coche");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                agregar(new Coche(nombre));
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