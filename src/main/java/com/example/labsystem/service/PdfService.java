package com.example.labsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xhtmlrenderer.pdf.ITextRenderer;


@Service
public class PdfService {

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] generatePdf(String template, Context context) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            String processedHtml = templateEngine.process(template, context);

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();

            renderer.createPDF(outputStream);

            return outputStream.toByteArray();
        }
    }
}
