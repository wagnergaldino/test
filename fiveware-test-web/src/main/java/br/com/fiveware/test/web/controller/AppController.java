package br.com.fiveware.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiveware.test.model.persistence.dao.PersonDao;
import br.com.fiveware.test.model.persistence.entity.Person;
import br.com.fiveware.test.service.PersonService;
import br.com.fiveware.test.web.bean.ApiExceptionBean;
import br.com.fiveware.test.web.bean.ApiResponseBean;
import br.com.fiveware.test.web.exception.ApiException;

@Controller
public class AppController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonDao personDao;
	
	@ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        return new ModelAndView("home");
    }
	
	@RequestMapping(value = "/newPerson", method = RequestMethod.POST)
	public @ResponseBody ApiResponseBean createPerson(@RequestBody Person person) throws Exception {
		
		if("".equals(person.getNome())) throw new ApiException("O campo NOME é obrigatório.");
		
		ApiResponseBean bean = new ApiResponseBean();
		
		try{
			personService.savePerson(person, personDao);
			bean.setMensagem("Usuário cadastrado com SUCESSO !!!");
			bean.setPerson(person);
		}catch(Exception e){
			throw new ApiException(e.getMessage());
		}	
		
		return bean;
		
	}
	
	@ExceptionHandler({ApiException.class}) 
	public @ResponseBody ApiExceptionBean handleApiException(Exception e){	     
	    return new ApiExceptionBean(e.getMessage());
	}
	
}
