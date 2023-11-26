import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GestorIncidencia {

    public static void main(String[] args) {
		ConexionDB.conexionDB();
        Menu.menuPrincipal();



    }

}
	
