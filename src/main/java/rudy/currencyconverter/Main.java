package rudy.currencyconverter;

import rudy.currencyconverter.model.ExchangeResponse;
import rudy.currencyconverter.service.CurrencyConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        List<String> historial = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n🌍 ************* CONVERSOR DE MONEDAS *************");
            System.out.println("1. USD ➡ ARS (Peso Argentino)");
            System.out.println("2. ARS ➡ USD (Dólar)");
            System.out.println("3. USD ➡ BRL (Real Brasileño)");
            System.out.println("4. BRL ➡ USD (Dólar)");
            System.out.println("5. USD ➡ PEN (Sol Peruano)");
            System.out.println("6. PEN ➡ USD (Dólar)");
            System.out.println("7. SALIR");
            System.out.print("Selecciona una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("❌ Ingresa un número del 1 al 7.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingresa el monto a convertir: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("❌ Ingresa un número válido.");
                    scanner.next();
                }
                double monto = scanner.nextDouble();

                String base = "";
                String destino = "";

                switch (opcion) {
                    case 1 -> { base = "USD"; destino = "ARS"; }
                    case 2 -> { base = "ARS"; destino = "USD"; }
                    case 3 -> { base = "USD"; destino = "BRL"; }
                    case 4 -> { base = "BRL"; destino = "USD"; }
                    case 5 -> { base = "USD"; destino = "PEN"; }
                    case 6 -> { base = "PEN"; destino = "USD"; }
                }

                ExchangeResponse response = converter.obtenerTasas(base);

                if (response != null && "success".equals(response.result)) {
                    Double tasa = response.conversion_rates.get(destino);
                    if (tasa != null) {
                        double resultado = monto * tasa;

                        System.out.println("\n✅ " + monto + " " + base + " = " + resultado + " " + destino);

                        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        historial.add(timestamp + " | " + monto + " " + base + " ➡ " + resultado + " " + destino);

                        System.out.println("\n📜 ************* HISTORIAL DE CONVERSIONES **************");
                        for (String registro : historial) {
                            System.out.println(registro);
                        }

                    } else {
                        System.out.println("❌ No se encontró la tasa para " + destino);
                    }
                } else {
                    System.out.println("❌ Error al obtener datos de la API.");
                }
            } else if (opcion != 7) {
                System.out.println("❌ Opción inválida, elige entre 1 y 7.");
            }

        } while (opcion != 7);

        System.out.println("Gracias por usar el Conversor de Monedas.");
        scanner.close();
    }
}
