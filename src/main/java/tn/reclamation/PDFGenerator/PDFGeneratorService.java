package tn.reclamation.PDFGenerator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import tn.reclamation.entities.Reclamation;
import tn.reclamation.repository.ReclamationRepository;
import tn.reclamation.service.ReclamationService;








public class PDFGeneratorService {
	@Autowired
	ReclamationService RecServ;
	@Autowired
	public static ReclamationRepository RecRepo;
	

	
	
	
	

	
	
	
	public static  ByteArrayInputStream customerPDFReport(List<Reclamation> listp) {
		

		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	PdfWriter.getInstance(document, out);
            document.open();
         
			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED);
			Paragraph para = new Paragraph( "Les Reclamation d'aujourdhui", font);
			
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);
			
			
			Font font2 = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.RED);
			
			Paragraph para2 = new Paragraph( "Les Reclamation D'aujourd'hui", font2);
			para.setAlignment(Element.ALIGN_LEFT);
			document.add(para2);
			document.add(Chunk.NEWLINE);
			
			
			
        	PdfPTable table = new PdfPTable(5);
        	// Add PDF Table Header ->
			Stream.of("Date", "contenu_rec", "type","etat","user")
			    .forEach(headerTitle -> {
			          PdfPCell header = new PdfPCell();
			          Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			          header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			          header.setHorizontalAlignment(Element.ALIGN_CENTER);
			          header.setBorderWidth(2);
			          header.setPhrase(new Phrase(headerTitle, headFont));
			          table.addCell(header);
			    });
						
			
			   Date currentSqlDate = new Date(System.currentTimeMillis());
			 for (Reclamation pub: listp	) {
				
	            if(pub.getSendingDate().getDay()==(currentSqlDate.getDay())  && pub.getSendingDate().getMonth()==(currentSqlDate.getMonth())
	            		
	            		 && pub.getSendingDate().getYear()==(currentSqlDate.getYear())	)
	            		 {
	            	
	           
	            
	            	PdfPCell date = new PdfPCell(new Phrase(String.valueOf(pub.getSendingDate())));
	            
	            	date.setPaddingLeft(4);
	            	date.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            	date.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(date);

	                PdfPCell content = new PdfPCell(new Phrase(pub.getContenuRec()));
	                content.setPaddingLeft(4);
	                content.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                content.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(content);

	                
	                PdfPCell nblikes = new PdfPCell(new Phrase(String.valueOf(pub.getType())));
	                nblikes.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                nblikes.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                nblikes.setPaddingRight(4);
	                table.addCell(nblikes);
	                
	                
	                PdfPCell nbdislike = new PdfPCell(new Phrase(String.valueOf(pub.getEtat())   ));
	                nbdislike.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                nbdislike.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                nbdislike.setPaddingRight(4);
	                table.addCell(nbdislike);
	                
	                PdfPCell user = new PdfPCell(new Phrase(String.valueOf(pub.getUser().getEmailUser()   )));
	                user.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                user.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                user.setPaddingRight(4);
	                table.addCell(user);
	                
	            }
	                
	                
	            }
            
            
            
            
            
            document.add(table);
            
            document.close();
            
            
          
            
            
        }catch(DocumentException e) {
        }
        
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
	
	
	
}
