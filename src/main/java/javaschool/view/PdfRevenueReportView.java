package javaschool.view;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import javaschool.entities.Client;
import javaschool.entities.Orders;
import javaschool.entities.Product;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PdfRevenueReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        BaseFont times =
                BaseFont.createFont("c:/windows/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);

        Map<Product, Long> productLongMap = (Map<Product, Long>) model.get("productLongMap");
        Map<Client, Long> clientLongMap = (Map<Client, Long>) model.get("clientLongMap");
        List<Orders> ordersList = (List<Orders>) model.get("ordersListDate");

        Table tableProducts = new Table(3);
        tableProducts.setPadding(2);
        tableProducts.setOffset(0.5f);
        tableProducts.addCell("Id");
        tableProducts.addCell("Product");
        tableProducts.addCell("Total sale");

        for (Map.Entry entry : productLongMap.entrySet()) {
            tableProducts.addCell("" + ((Product) entry.getKey()).getId());
            tableProducts.addCell("" + ((Product) entry.getKey()).getName());
            tableProducts.addCell("" + entry.getValue());
        }

        Table tableClients = new Table(3);
        tableClients.setPadding(2);
        tableClients.setOffset(0.5f);

        tableClients.addCell("Id");
        tableClients.addCell("Client");
        tableClients.addCell("Total Orders");

        for (Map.Entry entry : clientLongMap.entrySet()) {
            tableClients.addCell("" + ((Client) entry.getKey()).getClientId());
            Cell cell = new Cell(new Phrase(((Client) entry.getKey()).getName() + " " + ((Client) entry.getKey()).getSurname(), new Font(times, 14)));
            tableClients.addCell(cell);
            tableClients.addCell("" + entry.getValue());
        }

        document.addTitle("Statistic");
        document.addCreationDate();

        Phrase productPhrase = new Phrase("Top 10 Products.");
        Paragraph productParagraph = new Paragraph(productPhrase);
        productParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(productParagraph);
        document.add(Chunk.NEWLINE);
        document.add(tableProducts);

        Phrase clientPhrase = new Phrase("Top 10 Clients.");
        Paragraph clientParagraph = new Paragraph(clientPhrase);
        clientParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(clientParagraph);
        document.add(Chunk.NEWLINE);
        document.add(tableClients);

        document.newPage();
        Table orderTable = new Table(3);
        orderTable.setPadding(2);
        orderTable.setOffset(0.5f);
        orderTable.addCell("Id");
        orderTable.addCell("Client");
        orderTable.addCell("Date");
        for (Orders order : ordersList) {
            orderTable.addCell("" + order.getId());
            Cell cell = new Cell(new Phrase(order.getClient().getName() + " " + order.getClient().getSurname(), new Font(times, 14)));
            orderTable.addCell(cell);
            orderTable.addCell("" + order.getOrderDate());
        }

        Paragraph ordersParagraph = new Paragraph("Orders For A Week.");
        ordersParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(ordersParagraph);
        document.add(Chunk.NEWLINE);
        document.add(orderTable);
    }
}