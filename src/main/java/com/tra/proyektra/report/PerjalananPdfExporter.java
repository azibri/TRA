/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.report;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tra.proyektra.entities.Perjalanan;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class PerjalananPdfExporter {
    
    private List<Perjalanan> listperjalanan;
    
    public PerjalananPdfExporter(List<Perjalanan> listperjalanan) {
        this.listperjalanan = listperjalanan;
    }
    
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(5);
//        cell.setPhrase(new Phrase("Perjalanan Id"));        
//        table.addCell(cell);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);
        cell.setPhrase(new Phrase("Nama Karyawan", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Tujuan Dinas", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Kendaraan", font));
        table.addCell(cell);
        
//        cell.setPhrase(new Phrase("Approval Id"));
//        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Kota Asal", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Kota Tujuan", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Waktu Berangkat", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Waktu Pulang", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Tanggal Berangkat", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Tanggal Pulang", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Hotel", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Total Diem", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Perjalanan perjalanan : listperjalanan) {
//            table.addCell(perjalanan.getPerjalananId().toString());
            table.addCell(perjalanan.getPerjalananKaryawan());
            table.addCell(perjalanan.getPerjalananTujuanDinas());
            table.addCell(perjalanan.getPerjalananKendaraan());
            table.addCell(perjalanan.getPerjalananKotaAsal());
            table.addCell(perjalanan.getPerjalananKotaTujuan());
            table.addCell(perjalanan.getPerjalananWaktuBerangkat().toString());
            table.addCell(perjalanan.getPerjalananWaktuPulang().toString());
            table.addCell(perjalanan.getPerjalananTanggalBerangkat().toString());
            table.addCell(perjalanan.getPerjalananTanggalPulang().toString());
            table.addCell(perjalanan.getPerjalananHotel());
            table.addCell(String.valueOf(perjalanan.getPerjalananTotalDiem()));
            
        }
    }
    
    public void export(HttpServletResponse httpServletResponse) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());
        
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.BLUE);
        font.setSize(24);
        
        Paragraph p = new Paragraph("Report Perjalanan", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        document.add(p);
        
        PdfPTable table = new PdfPTable(11);
        table.setWidthPercentage(100);
//        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f});
        table.setSpacingBefore(10);
        
        writeTableHeader(table);
        writeTableData(table);
        
        document.add(table);
        
        document.close();
    }
    
}
