# Desarrollo de Aplicaciones Móviles.

# Grupo: 
Díaz Mateo
Martín Diego
Nieves Abrahams
Spindler Daniel
Vera José 


## TPNro.1 Parcial Nro. 1 Documentación APP “Financiera”:

La aplicación consta de una pantalla principal, en donde se puede acceder a distintas funciones de la app a través de cuatro botones: "Test del inversor", "Calcular inversión", "Historial" y "Aclaración legal". 
La pantalla también muestra un bloque de texto de bienvenida y un bloque de texto que indica que el usuario debe realizar el test del inversor para empezar a calcular su inversión.
A través de SharedPreferences, se verifica que el usuario haya completado el test del inversor antes de acceder a las funciones de calcular inversión e historial. En caso de que no haya completado el test, se muestra un mensaje de alerta.
En cuanto a la estructura del código, se define una clase MainActivity, la cual hereda de la clase AppCompatActivity. En el método onCreate se asigna el layout de la pantalla principal y se acceden y definen los distintos elementos de la misma (botones, textviews).
Luego, se define una función mostrarToast, la cual se encarga de mostrar un mensaje en forma de toast en la pantalla.

Cada botón tiene asignado un evento onClickListener, que al ser presionado, inicia un intent que lleva a la pantalla correspondiente (TestActivity, CalcularActivity, HistorialActivity o LegalActivity). 
En el caso de los botones que acceden a las pantallas de calcular inversión e historial, se verifica previamente que el usuario haya completado el test del inversor mediante SharedPreferences.
La actividad CalcularActivity permite al usuario ingresar los datos necesarios para calcular la inversión en dos distintas propuestas de inversión. 

### La pantalla InvestActivity de la aplicación: 
Se define una clase InvestActivity, la cual hereda de la clase AppCompatActivity. En el método onCreate se asigna el layout de la pantalla calcular y se acceden y definen los distintos elementos de la misma (botones, EditTexts).
Al presionar el botón "Ver resultados", se realiza el cálculo del monto total a obtener en cada propuesta de inversión y se comparan los rendimientos de ambas propuestas. Luego, se crea un intent que lleva a la pantalla ResultsActivity. En el intent se envían los datos del monto total a obtener en cada propuesta y una cadena que indica cuál propuesta es la más conveniente.
Al presionar el botón "Volver", se finaliza la actividad y se vuelve a la actividad anterior.
El layout de la pantalla resultados tiene dos TextViews que muestran el monto total a obtener en cada propuesta de inversión, cuál propuesta es la más conveniente y un botón que permite volver a la actividad anterior.

### La pantalla HistorialActivity de la aplicación: 
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
