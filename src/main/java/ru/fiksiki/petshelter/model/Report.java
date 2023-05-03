package ru.fiksiki.petshelter.model;

import lombok.*;
import org.telegram.telegrambots.meta.api.objects.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xwpf.usermodel.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private String ration;
    private String health;
    private String behavior;
    private File file;

    public Path createTempDocFile(String adopterName) {
        try {
            Path path = Path.of("C:\\"+adopterName+LocalDate.now() +".docx");
            Path file = Files.createFile(path);

            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Рацион:");
            run.addBreak();
            run.setText(ration);

            FileOutputStream out = new FileOutputStream(file.toFile());
            document.write(out);
            out.close();
            return file;
            // Delete the file when done
            //  Files.delete(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
