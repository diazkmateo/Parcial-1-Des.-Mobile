# Desarrollo de Aplicaciones Móviles.

## Grupo: 
### Díaz Mateo
### Martín Diego
### Nieves Abrahams
### Spindler Daniel
### Vera José 


## TPNro.1 Parcial Nro. 1 Documentación APP “Financiera”:

Este proyecto es una aplicación móvil para Android en la cual los usuarios pueden simular dos inversiones en plazo fijo y comparar cual es la más conveniente. Además, consta de un historial de hasta cinco cálculos pasados y un Test del Inversor para determinar el estilo de inversión del usuario (Conservador, Moderado, Arriesgado).

La aplicación consta de una pantalla principal, en donde se puede acceder a distintas funciones de la app a través de cuatro botones: "Test del inversor", "Calcular inversión", "Historial" y "Aclaración legal". 
La pantalla también muestra un bloque de texto de bienvenida y un bloque de texto que indica que el usuario debe realizar el test del inversor para empezar a calcular su inversión.
A través de SharedPreferences, se verifica que el usuario haya completado el test del inversor antes de acceder a las funciones de calcular inversión e historial. En caso de que no haya completado el test, se muestra un mensaje de alerta.
En cuanto a la estructura del código, se define una clase MainActivity, la cual hereda de la clase AppCompatActivity. En el método onCreate se asigna el layout de la pantalla principal y se acceden y definen los distintos elementos de la misma (botones, textviews).
Luego, se define una función mostrarToast, la cual se encarga de mostrar un mensaje en forma de toast en la pantalla.

Cada botón tiene asignado un evento onClickListener, que al ser presionado, inicia un intent que lleva a la pantalla correspondiente (TestActivity, CalcularActivity, HistorialActivity o LegalActivity). 
En el caso de los botones que acceden a las pantallas de calcular inversión e historial, se verifica previamente que el usuario haya completado el test del inversor mediante SharedPreferences.
La actividad CalcularActivity permite al usuario ingresar los datos necesarios para calcular la inversión en dos distintas propuestas de inversión. 


### La pantalla TestActivity de la aplicación:
Este archivo TestActivity.kt define la funcionalidad para la actividad TestActivity de la aplicación.
La actividad se inicia al responder un cuestionario de tres preguntas para definir el perfil de inversión del usuario.  Se definen los EditTexts para los campos de nombre, apellido y email. Se obtienen los RadioGroups para las tres preguntas del cuestionario.
Se definen los botones de "VOLVER" y "EVALUAR". También se obtiene una instancia de SharedPreferences con el nombre de "loginPref", que se usará para almacenar la información del usuario y su perfil de inversión.
Se define el comportamiento del botón de "EVALUAR". Se valida la información ingresada por el usuario y se verifica que las tres preguntas del cuestionario estén respondidas. Se obtiene la respuesta de cada pregunta y se calcula el resultado, que indica el perfil de inversión del usuario. Se almacena la información en SharedPreferences.
Se define el comportamiento del botón de "VOLVER". Al hacer clic, se crea un Intent para volver a la actividad MainActivity y se llama al método finish() para cerrar la actividad actual.
Se define la función mostrarToast() para mostrar mensajes al usuario.
Se define la función obtenerValorRespuesta() para obtener el valor correspondiente a cada respuesta en el cuestionario.
El archivo test_activity.xml define la interfaz de la actividad TestActivity como un ScrollView que contiene un RelativeLayout. Dentro del RelativeLayout se definen los elementos de la interfaz:

### La pantalla CalcularActivity de la aplicación: 
Se define una clase CalcularActivity, la cual hereda de la clase AppCompatActivity. En el método onCreate se asigna el layout de la pantalla calcular y se acceden y definen los distintos elementos de la misma (botones, EditTexts).
Al presionar el botón "Ver resultados", se realiza el cálculo del monto total a obtener en cada propuesta de inversión y se comparan los rendimientos de ambas propuestas. Luego, se crea un intent que lleva a la pantalla ResultsActivity. En el intent se envían los datos del monto total a obtener en cada propuesta y una cadena que indica cuál propuesta es la más conveniente.
Al presionar el botón "Volver", se finaliza la actividad y se vuelve a la actividad anterior.
El layout de la pantalla resultados tiene dos TextViews que muestran el monto total a obtener en cada propuesta de inversión, cuál propuesta es la más conveniente y un botón que permite volver a la actividad anterior.

### La pantalla HistorialActivity de la aplicación: 
En la actividad HistorialActivity, se muestra un historial de los datos almacenados previamente mediante sharedpreferences. Se utilizan elementos de vista como TextView y Button para mostrar el histórico y un botón para volver a la actividad anterior.
El archivo se encuentra estructurado en un RelativeLayout que contiene un TextView (con id "titulo"), un LinearLayout (con id "historial") y un Button.
El TextView "titulo" muestra el texto "HISTORIA
El LinearLayout "historial" contiene una serie de TextViews que muestran información de cada elemento del historial
Dentro del LinearLayout "historial" se muestran cinco TextViews, cada uno con un texto correspondiente a un elemento del historial.
Finalmente, el Button que permite volver a la pantalla anterior

### La pantalla LegalActivity de la aplicación: 
El archivo se encuentra estructurado en un LinearLayout que contiene dos TextViews y un Button.
El TextView "Información legal" muestra el texto "Información legal.
El segundo TextView muestra el texto descriptivo
El Button que permite volver a la pantalla anterior
En el archivo LegalActivity.kt, se define el comportamiento del botón "VOLVER". En este caso, al hacer clic se llama al método finish() para cerrar la actividad actual y regresar a la pantalla anterior.
