# 💱 Currency Converter

<p align="center">
  <img src="https://img.shields.io/badge/STATUS-FINALIZADO-brightgreen" alt="Estado del proyecto">
  <img src="https://img.shields.io/badge/LICENSE-MIT-blue" alt="Licencia">
  <img src="https://img.shields.io/github/languages/top/rudygomez404/currency-converter" alt="Lenguaje Principal">
</p>

---

## Descripción del Proyecto

**Currency Converter** es una aplicación de consola desarrollada en **Java**, que permite convertir montos entre diferentes monedas usando tasas de cambio en tiempo real, gracias a la API [ExchangeRate-API](https://www.exchangerate-api.com/).

Presenta un menú interactivo, permite ingresar montos, visualizar resultados y guarda un historial de conversiones con fecha y hora.

---

## Demostración

```plaintext
🌍 ************* CONVERSOR DE MONEDAS *************
1. USD ➡ ARS (Peso Argentino)
2. ARS ➡ USD (Dólar)
3. USD ➡ BRL (Real Brasileño)
4. BRL ➡ USD (Dólar)
5. USD ➡ PEN (Sol Peruano)
6. PEN ➡ USD (Dólar)
7. SALIR
Selecciona una opción: 1
Ingresa el monto a convertir: 100

✅ 100.0 USD = 18750.0 ARS

📜 ************* HISTORIAL DE CONVERSIONES *************
2025-08-04 02:30:00 | 100.0 USD ➡ 18750.0 ARS
```

## 📁 Acceso al Proyecto

Clona este repositorio:

```bash
https://github.com/rudy-gomez/Currency-Converter.git
```
### Ejecución

1. Abre el proyecto en tu IDE IntelliJ IDEA.
2. Asegúrate de tener Java 17 o superior.
3. Añade la librería Gson al classpath de tu proyecto.
4. Ejecuta la clase Main.java.

## 🛠️ Tecnologías Utilizadas

* **Java 17+**
  * Incluye la API HTTP Client nativa
* **Gson** para deserialización de JSON
* **ExchangeRate-API** ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)) para tasas de cambio

## 👨‍💼 Autor

| [@RudyGomez](https://github.com/rudygomez404)|
| :---------------------------------------------------------------------------------------------------------------------------------: |

## ✉️ Licencia

Este proyecto puede emplearse sin restricciones con objetivos educativos.

