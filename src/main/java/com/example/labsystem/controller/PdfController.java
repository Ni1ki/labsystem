package com.example.labsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example.labsystem.service.AppointmentService;

@Controller
public class PdfController {

    @Autowired
    private AppointmentService service;

    /**
     * Endpoint to download a PDF by appointment ID.
     *
     * @param id The ID of the appointment.
     * @return ResponseEntity containing the PDF content.
     */
    @GetMapping("/downloadPdf/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        try {
            byte[] pdfContent = service.getPdfContentById(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);

            // Set a meaningful file name for download (you can customize this)
            String fileName = "appointment_" + id + ".pdf";
            headers.setContentDispositionFormData("attachment", fileName);

            headers.setContentLength(pdfContent.length);

            return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions more specifically based on your use case
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving PDF content", e);
        }
    }
}
