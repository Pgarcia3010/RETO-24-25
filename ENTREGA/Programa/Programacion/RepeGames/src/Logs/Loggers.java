package Logs;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loggers implements AutoCloseable{
    private static final String ERROR_LOG_FILE = "logs/error.log";
    private PrintWriter sesionLogger;

    // Constructor: crea un nuevo archivo de log por sesión
    public Loggers() {
        try {
            String tiempo = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdirs(); // Crear directorio si no existe
            }
            String sesionLogFile = "logs/log_" + tiempo + ".txt";
            sesionLogger = new PrintWriter(new FileWriter(sesionLogFile, true), true);
            logSesion("=== Nueva sesión iniciada: " + tiempo + " ===");
        } catch (IOException e) {
            logError("Error al crear el archivo de log de sesión", e);
        }
    }

    // Método para registrar operaciones del usuario
    public void logSesion(String mensaje) {
        String tiempo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        sesionLogger.println("[" + tiempo + "] INFO: " + mensaje);
    }

    // Método para registrar errores globales
    public static void logError(String mensaje, Exception e) {
        try (PrintWriter errorLogger = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true), true)) {
            String tiempo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            errorLogger.println("[" + tiempo + "] ERROR: " + mensaje);
            if (e != null) {
                e.printStackTrace(errorLogger);
            }
        } catch (IOException ioEx) {
            System.err.println("No se pudo escribir en el archivo de errores: " + ioEx.getMessage());
        }
    }

    // Cierra el logger de sesión
    public void close() {
        if (sesionLogger != null) {
            logSesion("=== Sesión finalizada ===");
            sesionLogger.close();
        }
    }
}
