package negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Post {
	private Long id;
	private String texto;
	
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
