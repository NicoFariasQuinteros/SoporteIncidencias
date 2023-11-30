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
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcli") 
	int idCliente;
	@Column(name = "cuit")
	String cuitCliente;
	@Column(name = "razonS")
	String razonSocial;
	@Column(name = "nom")
	String nomCliente;
	@Column(name = "ape")
	String apeCliente;
	@Column(name = "dire")
	String direCliente;
	@Column(name = "cel")
	 String celCliente;
	@Column(name = "mail")
	String mailCliente;
	@Column(name = "altaCliente")
	final LocalDate altaCliente = LocalDate.now();
	@Column(name = "contrato")
	String contratos;


	
public static Cliente altaCliente() {
	System.out.println("\n*****INGRESE LOS SIGUIENTES DATOS DEL CLIENTE*****");
    System.out.println("***********RESPETANDO LAS INDICACIONES*************");
		try (Scanner entrada = new Scanner(System.in)) {
			System.out.println("CUIT: ");
			String cuit = entrada.nextLine();
			System.out.println("RAZON SOCIAL: ");
			String razonS = entrada.nextLine();
			System.out.println("NOMBRE: ");
			String nom = entrada.nextLine();
			System.out.println("APELLIDO: ");
			String ape = entrada.nextLine();
			System.out.println("DIRECCION: ");
			String dire = entrada.nextLine();
			System.out.println("CELULAR: ");
			String cel = entrada.nextLine();
			System.out.println("MAIL: ");
			String mail = entrada.nextLine();
			System.out.println();
			System.out.println("CONTRATO (CODIGO DEL SOPORTE): ");
			String contrato = entrada.nextLine();
				
			Cliente cliente1 = new Cliente(cuit,razonS,nom,ape,dire,cel,mail,contrato);
				
			//System.out.println(cliente1.toString());

			entrada.close();
			return cliente1;
		}
		}



public Cliente(String cuit, String razonS, String nom, String ape, String dire, String cel, String mail,
		String contrato) {
	cuitCliente = cuit;
	razonSocial = razonS;
	nomCliente = nom;
	apeCliente = ape;
	direCliente = dire;
	celCliente = cel;
	mailCliente = mail;
	contratos = contrato;
}

}
