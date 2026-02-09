
public class Alumno {

	private String nombre;
	private String apellidos;
	private int NRE;
	private String email;
	private String direccion;
	
	public Alumno(){
		
	}
	public Alumno(String nombre,String apellidos,int NRE,String email,String direccion) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setNRE(NRE);
		this.setEmail(email);
		this.setDireccion(direccion);
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getNRE() {
		return NRE;
	}

	public void setNRE(int nRE) {
		NRE = nRE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String info() {
		return "Nombre: " + nombre + "\n" +
				"Apellidos: " + apellidos + "\n" + 
				"NRE: " + NRE + "\n" + 
				"Email: " + email + "\n" + 
				"Direccion: " + direccion ;
				
				
	}
	
}
