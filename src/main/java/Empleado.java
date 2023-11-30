import java.time.LocalDate;
import java.util.Scanner;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int idEmpleado;
	 String cuitEmpleado;
	 String nomEmpleado;
	 String apeEmpleado;
	 String direEmpleado;
	 String celEmpleado;
	 String mailEmpleado;
	 final LocalDate altaEmpleado = LocalDate.now();
	 String areaEmpleado; 

 public static Empleado altaEmpleado(){
		try (Scanner entrada = new Scanner(System.in)) {
			System.out.println();
			boolean validaEntrada = true;
			String cuit=" ", nom=" ",ape="",dire="",cel="",mail="",area="";
			
			System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL EMPLEADO*****");
			System.out.println("***********RESPETANDO LAS INDICACIONES*************");
			while (validaEntrada) {
			      System.out.println("Ingrese el CUIT/DNI del Empleado: ");
			      cuit = entrada.nextLine();
					System.out.println(cuit);
			      if (cuit.isEmpty())
			       validaEntrada=true;
			      else validaEntrada=false;
			}
			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese el NOMBRE del Empleado: ");
				nom = entrada.nextLine();
				if (nom.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}
			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese el APELLIDO del Empleado: ");
				ape = entrada.nextLine();
				if (ape.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}
			
			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese la DIRECCION del Empleado: ");
				dire = entrada.nextLine();
				if (dire.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}
			
			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese el CELULAR del Empleado: ");
				cel = entrada.nextLine();
				if (cel.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}
			
			
			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese el MAIL del Empleado: ");
				mail = entrada.nextLine();
				if (mail.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}

			validaEntrada=true;
			while (validaEntrada) {
				System.out.println("Ingrese el Area(RRHH-COMERCIAL-MATENIMIENTO-TECNICO) del Empleado: ");
				area = entrada.nextLine();
				if (area.isEmpty())
			       validaEntrada=true;
			    else validaEntrada=false;
			}
			
			
			Empleado emp1 = new Empleado(cuit,nom,ape,dire,cel,mail,area);
			
			//System.out.println(emp1.toString());
			
			return emp1;
		}
 	
 }

public Empleado(String cuit, String nom, String ape, String dire, String cel, String mail, String area) {
	
	cuitEmpleado = cuit;
	nomEmpleado = nom;
	apeEmpleado = ape;
	direEmpleado = dire;
	celEmpleado = cel;
	mailEmpleado = mail;
	areaEmpleado = area;
}

}
