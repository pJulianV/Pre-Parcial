# Pre-Parcial

Informe Actividad Pre-Parcial 
 
Parte 1: Operaciones básicas con archivos 
 
Al empezar, el programa comprueba si hay un archivo llamado estudiantes.txt. Si no lo 
encuentra, lo crea con unos cuantos registros de ejemplo. Después abre el archivo y lee todo, 
mostrando cada línea; esto es justo como funciona el acceso secuencial. 
 
 
 
Parte 2: ¿Cuándo usar acceso secuencial y cuándo acceso directo? 
 
A la hora de manejar archivos, no es lo mismo leerlos de un extremo a otro que ir directo a una 
posición. Si nuestra idea es procesar todo el contenido —listar cada estudiante, sacar un 
promedio o buscar algo sin saber dónde está— lo natural es el acceso secuencial. 
 
Ahora bien, si ya sabemos cuál registro buscamos, el acceso directo nos evita leer el resto del 
archivo. Por ejemplo, si el usuario pide ver la línea 3, simplemente vamos allí y listo; muy útil 
cuando el archivo es grande y queremos respuestas puntuales. 
 
Resumen: secuencial para todo, directo para lo puntual. 
 
 
 
Parte 3: ¿En qué se diferencian la mezcla directa y la mezcla natural? 
 
Antes de ordenar datos de forma externa conviene entender dos aproximaciones. Las dos usan 
bloques ordenados, pero las tratan distinto. 
 
La mezcla directa toma el arreglo, lo corta en trozos de un mismo tamaño (1, 2, 4, 8,... 
elementos) y, par a par, los funde. Es sencilla y transparente, pero no le importa si los datos ya 
vienen casi ordenados: igual recorre todo, haciendo pasadas extra sin necesidad. 
 
La mezcla natural intenta ser más lista: no corta en bloques rígidos, sino que busca "corridas" 
que ya están ordenadas de por sí. Esas corridas se fusionan entre sí, y si la entrada ya tiene 
partes ordenadas, el proceso se hace más rápido porque hay menos mezclas que hacer. 
 
El programa incluye "mezclaDirecta" para fusionar dos bloques y `corridasNaturales` para 
detectar corridas en un arreglo, demostrando ambas ideas. 
 
 
 
 
Parte 4: Recursividad para contar estudiantes con nota >= 90 
 
La función "contarNotasAltas" mira el primer estudiante, suma uno si tiene nota ≥ 90 y luego se 
llama a sí misma con la lista restante. 
 
¿Por qué recurrir a la recursividad? Porque deja el código claro y directo: el conteo es 1 o 0 
según la nota del primer estudiante, más el conteo del resto. No hace falta manejar índices ni 
variables extra. 
 
En Java, cada llamada recursiva usa espacio en la pila. Si la lista fuese muy larga 
(miles o millones de entradas) podríamos quemar la pila y obtener un StackOverflowError. Java 
tampoco optimiza la recursión por cola, así que no hay truco para esquivar ese gasto. Para 
unos pocos estudiantes está bien, pero en escenarios reales quizá convenga un bucle sencillo. 
 