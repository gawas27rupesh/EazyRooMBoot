package com.springboot.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.Eazy;
import com.springboot.web.service.EazyRooMService;
import com.springboot.web.service.EazyRooMpdfService;
import com.springboot.web.utility.GeneratePdfReport;

@RestController
public class EazyRooMpdf {
	
	@Autowired
	private EazyRooMpdfService eazyRooMpdfService;
	
	@Autowired
	private EazyRooMService eazyRooMService;
	
	@GetMapping(value = "pdfowner/{city}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> ownerReport(@PathVariable("city") String city) throws IOException {
		String utype="owner";
		List<Eazy> user=this.eazyRooMService.getUserByCity(city, utype);
		ByteArrayInputStream pdf = GeneratePdfReport.ownerReport(user,utype);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=ownereport.pdf");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}
	
	@GetMapping(value = "pdftenant/{city}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> tenentReport(@PathVariable("city") String city) throws IOException {
		String utype="tenant";
		List<Eazy> user=this.eazyRooMService.getUserByCity(city, utype);
		System.out.println(user);
		ByteArrayInputStream pdf = GeneratePdfReport.tenantReport(user,utype);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=ownereport.pdf");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}
	
//	@GetMapping("/pdf")
//	public ResponseEntity<InputStreamResource> createPdf() {
//		
//		ByteArrayInputStream pdf=eazyRooMpdfService.createPdf();
//		
//		HttpHeaders httpHeaders=new HttpHeaders();
//		httpHeaders.add("Content-Disposition", "inline;file=lcwd.pdf");
//		
//		return ResponseEntity
//				.ok()
//				.headers(httpHeaders)
	
//				.contentType(MediaType.APPLICATION_PDF)
//				.body(new InputStreamResource(pdf));
//	}	
	
	
}
