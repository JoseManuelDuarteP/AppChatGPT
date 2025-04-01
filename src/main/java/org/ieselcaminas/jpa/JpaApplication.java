package org.ieselcaminas.jpa;


import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.services.CocheService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {



    public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//En este método definimos nuestro propio código
	@Override
	public void run(String... args) {
			final CocheService cocheService;
			final Scanner scanner = new Scanner(System.in);


				while (true) {
					System.out.println("1. Mostrar coches\n2. Agregar coche\n3. Eliminar coche\n4. Salir");
					int option = scanner.nextInt();
					scanner.nextLine();

					switch (option) {
						case 1 -> cocheService.getAllCoches().forEach(System.out::println);
						case 2 -> {
							System.out.print("Ingrese la marca: ");
							String marca = scanner.nextLine();
							Coche coche = new Coche();
							coche.setMarca(marca);
							cocheService.saveCoche(coche);
						}
						case 3 -> {
							System.out.print("Ingrese el ID del coche a eliminar: ");
							Long id = scanner.nextLong();
							cocheService.deleteCoche(id);
						}
						case 4 -> {
							System.out.println("Saliendo...");
							return;
						}
						default -> System.out.println("Opción no válida");
					}
				}


	}
}