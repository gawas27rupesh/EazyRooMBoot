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

import com.springboot.web.constants.AppConstants;
import com.springboot.web.entities.Eazy;
import com.springboot.web.service.EazyRooMService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EazyRooMowner {

	@Autowired
	private EazyRooMService eazyRooMService;
	
	@RequestMapping(AppConstants.OWNER)
	public String  owner() 
	{
		return AppConstants.OWN;
	}
	
	@RequestMapping(AppConstants.OWNERADD)
	public String  owneradd() 
	{
		return AppConstants.OWNADD;
	}
	
	@RequestMapping(AppConstants.OWNERDELETE)
	public String  ownerdelete() 
	{
		return AppConstants.OWNDELETE;
	}
	
	@RequestMapping(AppConstants.SEEALLOWNER)
	public String  seeallowner() 
	{
		return AppConstants.SEEALLOWN;
	}
	
	@PostMapping(AppConstants.DONEOWNER)
	public String doneowner(@ModelAttribute Eazy eazy)
	{
		this.eazyRooMService.CreateAcnt(eazy);
		return AppConstants.DONEOWN;	
	}
	
	@GetMapping("/seeowner")
	public String  seeowner(@RequestParam("city") String city,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMService.getUserByCity(city,utype);
		m.addAttribute("eazy",eazy);
		m.addAttribute("city",city);
		return "seeowner";
	}
	
	@GetMapping("/postdeleteown")
	public String postdeleteown(@RequestParam("contno") long contno,@RequestParam("pswd") int pswd,@RequestParam("utype") String utype,Model m) 
	{
		List<Eazy> eazy =eazyRooMService.seeyourpost(contno,pswd,utype);
		if(eazy.isEmpty())
		{
			m.addAttribute("msg","Invalid Contact Number and Password...!");
			return "ownerdelete";
		}
		m.addAttribute("eazy",eazy);
		return "postdeleteown";	
	}
	
	@RequestMapping("/deleteown/{eazyId}")
	public RedirectView deleteown(@PathVariable("eazyId") int eazyId,HttpServletRequest request) 
	{
		System.out.println("delete");
		this.eazyRooMService.deleteEazy(eazyId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/ownerdelete");
		return redirectView;	
	}
	
	@RequestMapping("/updateown/{eid}")
	public String updateForm1(@PathVariable("eid") int eid,Model m) 
	{
		System.out.println(eid);
		Eazy eazy = this.eazyRooMService.getEazy(eid);
		m.addAttribute(eazy);
		return "updatetenant";		
	}
	
	
	
	
	
	
}
