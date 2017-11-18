package negocio;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

 import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

@Entity
public class Usuario {
	private Long id;
	private String nombre;
	private String apellido;
	private String nick;
	private String password;
	private String mail;
	
	public Usuario() {
	}
	@Id
	@GeneratedValue
    public Long getId() {
		return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
