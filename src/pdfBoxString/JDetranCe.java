/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfBoxString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author rafael
 */
public class JDetranCe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        String resl = null;
        try {
            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("../detran1.pdf"), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());

            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            resl = pdfTextStripper.getText(pdDocument);
            pdDocument.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(""+resl);
        Scanner scan = new Scanner(resl);
        int num = 0;
        while (scan.hasNext()) {
            String result = scan.nextLine();

            if (result.contains("12-Agente de Transito e Transporte - 2a Regional (Itapipoca)")) {
                num = num + 1;

            }
        }
        System.out.println("" + num);
    }

    private JDetranCe() {
    }

}
