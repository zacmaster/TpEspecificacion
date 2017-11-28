package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	private Long id;
	private String texto;
	private String fecha;
	private String nickUsuario;
	private Integer puntuacion;
	
	public Post() {
		fecha = LocalDate.now().toString()+" "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute();
		puntuacion = 0;
	}
	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNickUsuario() {
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Post(String texto) {
		this.texto = texto;
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
	
	@Override
	public String toString() {
		return "'"+texto +"' ("+fecha+")"+"@"+nickUsuario ;
	}

}
