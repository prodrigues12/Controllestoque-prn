package com.controlestoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.controlestoque.Repository.Pedidos;
import com.controlestoque.Repository.Produtos;

@Controller
public class DashboardController {
	
	@Autowired
	private Pedidos pedRepository;
	@Autowired
	private Produtos proRepository;
	
	
	@GetMapping("/")
	public ModelAndView layout() {
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("pedidosNovos", pedRepository.statusIgualNovo());
		mv.addObject("pedidosPendentes", pedRepository.statusIgualPendente());
		mv.addObject("pedidosCancelados", pedRepository.statusIgualCancelado());
		mv.addObject("pedidosFinalizados", pedRepository.statusIgualFinalizado());
		mv.addObject("pedidosSeparados", pedRepository.statusIgualSeparando());
		mv.addObject("totalItensEstoque", proRepository.totalItensEstoque());
		mv.addObject("estoqueBaixo", proRepository.estoqueBaixo());
		
		return mv;
		
	}

	@GetMapping("/menu")
	public ModelAndView menu() {
		ModelAndView mv = new ModelAndView("fragmentos/fragmentos2");
		return mv;
		
	}
}
