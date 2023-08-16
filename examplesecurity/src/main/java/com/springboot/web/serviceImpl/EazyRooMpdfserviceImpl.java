package com.springboot.web.serviceImpl;



import java.io.ByteArrayInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springboot.web.service.EazyRooMpdfService;

@Service
public class EazyRooMpdfserviceImpl implements EazyRooMpdfService{
	
	private Logger logger=LoggerFactory.getLogger(EazyRooMpdfService.class);

	@Override
	public ByteArrayInputStream createPdf() {
		
		return null;
	}

	
	
//	@Override
//	public ByteArrayInputStream createPdf() {
//		
//		logger.info("Create PDF started: ");
//		String title="EazyRooM";
//		
//		ByteArrayOutputStream out=new ByteArrayOutputStream();	
//		Document document=new Document();	
//		PdfWriter.getInstance(document, out);			
//		HeaderFooter footer=new HeaderFooter(true,new Phrase(" page"));
//		footer.setAlignment(Element.ALIGN_CENTER);
//		footer.setBorderWidthBottom(0);
//		document.setFooter(footer);
//		
//		//start
//		document.open();		
//		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
//		Paragraph titleparagraph=new Paragraph(title,titleFont);
//		titleparagraph.setAlignment(Element.ALIGN_CENTER);	
//		document.add(titleparagraph);
//		
//		//Paragraph paragraph=new Paragraph(content);
//		//paragraph.add(new Chunk("this is good massage"));
//		//document.add(paragraph);			
//		document.close();		
//		return new ByteArrayInputStream(out.toByteArray());	
//	}
	

}
