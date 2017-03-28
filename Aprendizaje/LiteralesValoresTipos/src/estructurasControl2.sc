import java.io.File

val archivos = (new File(".")).listFiles()
for(archivo <- archivos
    if archivo.isFile
    if archivo.getName.contains("t")) yield archivo

// Si ponemos las llaves,
// evitamos usar el punto y coma
for {
  x <- 1 to 2
  y <- 1 to 3
} yield (x, y)