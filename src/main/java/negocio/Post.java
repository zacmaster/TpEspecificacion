package negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	private Long id;
	private String texto;
	private String fecha;
	private String nombreUsuario;
	private String puntuacion;
	
	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Post(String texto) {
		this.texto = texto;
	}
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
    public Long getId() {
		return id;
    }

    public void setId(Long id) {
		this.id = id;
    }

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
