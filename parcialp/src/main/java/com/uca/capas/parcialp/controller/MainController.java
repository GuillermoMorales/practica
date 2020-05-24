package com.uca.capas.parcialp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcialp.domain.Contribuyente;
import com.uca.capas.parcialp.domain.Importancia;
import com.uca.capas.parcialp.service.ContribuyenteService;
import com.uca.capas.parcialp.service.ImportanciaService;


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
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView guardarEstudiante(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			mav.setViewName("index");
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
		}
		else
		{			
			contribuyenteService.save(contribuyente);
			mav.setViewName("resultado");
		}
		
		return mav;
	}

}
