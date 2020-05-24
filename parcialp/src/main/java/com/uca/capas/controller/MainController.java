package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	@Autowired
	private ImportanciaService importanciaService;
	
	
	@RequestMapping("/index")
	public ModelAndView initMain()
	{
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancia = null;
		try
		{
			importancia = importanciaService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("importancia",importancia);
		mav.setViewName("index");
		return mav;
	}

}
