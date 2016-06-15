package br.com.fiveware.test.web.bean;

import java.io.Serializable;

public class ApiExceptionBean implements Serializable {
	
	private static final long serialVersionUID = -8526452495957543237L;
	
	private String mensagem;
	 
	public ApiExceptionBean() {}
	
    public ApiExceptionBean(String mensagem) {
      this.mensagem = mensagem;
    }

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
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
		ApiExceptionBean other = (ApiExceptionBean) obj;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApiExceptionJsonInfo [mensagem=" + mensagem + "]";
	}

}