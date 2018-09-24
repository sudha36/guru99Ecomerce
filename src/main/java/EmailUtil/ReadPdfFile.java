package EmailUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.Assert;

public class ReadPdfFile {

	public static void ReadPdfFiles(String Number) throws IOException {

		File file = new File("C:\\Guru99Invoice\\CompleteOrderInvoice.pdf");
		FileInputStream fis = new FileInputStream(file);

		PDFParser Parser = new PDFParser(fis);
		Parser.parse();
		COSDocument cosDoc = Parser.getDocument();
		PDDocument pdDoc = new PDDocument(cosDoc);
		PDFTextStripper Strip = new PDFTextStripper();
		String Data = Strip.getText(pdDoc);
		System.out.println(Data);
		Assert.assertTrue(Data.contains(Number));
		cosDoc.close();
		pdDoc.close();
		System.out.println("Found the Order Number");
	}

}
