package br.com.fiveware.test.web.bean;

import java.io.Serializable;

import br.com.fiveware.test.model.persistence.entity.Person;

public class ApiResponseBean implements Serializable {

	private static final long serialVersionUID = 6718458261695562955L;
	
	private String mensagem;
	
	private Person person;
	
	public ApiResponseBean(){}
	
	public ApiResponseBean(String mensagem, Person person) {
		this.mensagem = mensagem;
		this.person = person;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiResponseBean other = (ApiResponseBean) obj;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiResponseBean [mensagem=" + mensagem + ", person=" + person + "]";
	}

}
