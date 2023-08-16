package com.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springboot.web.entities.Eazy;
import com.springboot.web.service.EazyRooMService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class EazyRooMtanant {
	
	@Autowired
	private EazyRooMService eazyRooMService;
	
	@RequestMapping("/tenant")
	public String  tenant() 
	{
		return "tenant";
	}
	
	@RequestMapping("/tenantadd")
	public String  tenantadd() 
	{
		return "tenantadd";
	}
		
	@RequestMapping("/tenantdelete")
	public String  tenantdelete() 
	{
		return "tenantdelete";
	}	
	
	@RequestMapping("/seealltenant")
	public String  seealltenant() 
	{
		return "seealltenant";
	}
	
	@PostMapping("/donetenant")
	public String donetenant(@ModelAttribute Eazy eazy) {
		this.eazyRooMService.CreateAcnt(eazy);
		return "donetenant";	
	}
	
	
	@GetMapping("/seetenant")
	public String  seetenant(@RequestParam("city") String city,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMService.getUserByCity(city,utype);
		m.addAttribute("eazy",eazy);
		m.addAttribute("city",city);
		return "seetenant";
	}
	
	
	@GetMapping("/all")
	public List<Eazy> all(){
		List<Eazy> all = eazyRooMService.getAll();
		return all;
	}
	
	@GetMapping("/postdeletetenant")
	public String postdeletetenant(@RequestParam("contno") long contno,@RequestParam("pswd") int pswd,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMService.seeyourpost(contno,pswd,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid Contact Number and Password...!");
			return "tenantdelete";
		}
		m.addAttribute("eazy",eazy);
		return "postdeletetenant";
	}
	
	@RequestMapping("/deletetenant/{eazyId}")
	public RedirectView deletetenant(@PathVariable("eazyId") int eazyId,HttpServletRequest request) 
	{
		System.out.println(eazyId);
		this.eazyRooMService.deleteEazy(eazyId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/tenantdelete");
		return redirectView;	
	}
	
	@RequestMapping("/updatetenant/{eid}")
	public String updateForm2(@PathVariable("eid") int eid,Model m) 
	{
		System.out.println(eid);
		Eazy eazy = this.eazyRooMService.getEazy(eid);
		m.addAttribute(eazy);
		return "updateown";		
	}
	
	
}
