# ECOMMERCE PRICES

Aplicación para consultar precios de productos de empresa de comercio electrónico.  

# Resumen 
La solución consta de:
* Aplicación [Spring Boot](https://spring.io/projects/spring-boot) (Directorio [prices](https://github.com/verodnier/EcommercePrices/tree/main/prices)).
* Colección de pruebas funcionales en [Postman](https://www.postman.com/) ([API ECOMMERCE PRICES TESTS](https://github.com/verodnier/EcommercePrices/blob/main/tests-ext/API%20ECOMMERCE%20PRICES%20TESTS.postman_collection.json)).

# Aplicación
## Estructura 
La estructura base del proyecto se creó utilizando [Spring Initializr](https://start.spring.io/) y el resto se organizó en las siguientes capas compatibles con la [arquitectura hexagonal](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)), también conocida como arquitectura de puertos y adaptadores: 

* <span style="color: royalblue;">Input</span>  
* <span style="color: royalblue;">Application</span>  
* <span style="color: royalblue;">Domain</span>  
* <span style="color: royalblue;">Output</span>  
* <span style="color: royalblue;">Infrastructure</span>  


## Implementación
Como parte de la solución propuesta, se incluyó el tratamiento de excepciones con una personalización de la respuesta del sistema al consumir el servicio.

## Requisitos de instalación     
* <span style="color: royalblue;">Java 17</span>    
* <span style="color: royalblue;">Maven 3.9.5</span>    

## Ejecución    
1. Descargar el repositorio.
2. Abrir consola del sistema y situarse en el directorio [prices](https://github.com/verodnier/EcommercePrices/tree/main/prices). 
3. Ejecutar los siguientes comandos en el orden en el que aparecen:  
	a) <span style="color: royalblue;">mvn clean install</span>    
	b) <span style="color: royalblue;">mvn spring-boot:run</span>  

# Pruebas
Se diseñaron pruebas unitarias y funcionales a partir de los 5 casos de pruebas propuestos y otros que se consideraron pertinentes. (Ver más información sobre los casos de prueba en: [Casos de prueba](https://github.com/verodnier/EcommercePrices/blob/main/resources/ECOMMERCE_PRICES_CASOS_DE_PRUEBA.png))


## Pruebas unitarias
Se implementaron pruebas unitarias con [JUnit](https://junit.org/junit5/) y [Mockito](https://site.mockito.org/) para el caso de uso [findPriceByBrandIdProductIdAndApplicationDate](https://github.com/verodnier/EcommercePrices/blob/main/prices/src/test/java/com/ecommerce/prices/application/usecases/PricesUseCasesTests.java)</span>. 

Para correr las pruebas: 

1. Abrir consola del sistema y situarse en el directorio [prices](https://github.com/verodnier/EcommercePrices/tree/main/prices). 
2. Ejecutar el comando <span style="color: royalblue;">mvn test</span>  

__Nota:__  Para identificar en el código cada caso de prueba, se siguió la convención de nombres descrita en: [Casos de prueba](https://github.com/verodnier/EcommercePrices/blob/main/resources/ECOMMERCE_PRICES_CASOS_DE_PRUEBA.png) 

## Pruebas funcionales
Se implementaron pruebas e2e en [Postman](https://www.postman.com/).  

Para correr las pruebas: 
* Importar el fichero [API ECOMMERCE PRICES TESTS](https://github.com/verodnier/EcommercePrices/blob/main/tests-ext/API%20ECOMMERCE%20PRICES%20TESTS.postman_collection.json) en [Postman](https://www.postman.com/).
* Correr todos los test. Para esto:   
	a) Acceder al archivo <span style="color: royalblue;">findPriceByBrandIdProductIdAndApplicationDate</span> dentro de la colección importada.    
	b) Hacer clic en el botón <span style="color: royalblue;">Run</span>  
	c) Hacer clic en el botón <span style="color: royalblue;">Run API ECOMMERCE PRICES TESTS</span>  

__Nota:__  Para identificar en la colección cada caso de prueba, se siguió la convención de nombres descrita en: [Casos de prueba](https://github.com/verodnier/EcommercePrices/blob/main/resources/ECOMMERCE_PRICES_CASOS_DE_PRUEBA.png)