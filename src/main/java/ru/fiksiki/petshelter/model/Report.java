package ru.fiksiki.petshelter.model;

import lombok.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.telegram.telegrambots.meta.api.objects.File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;


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

    /**
     * Generates a report file for an adopter, containing information about the cat's behavior,
     * health, and dietary needs.
     *
     * @param adopterName the name of the adopter for whom the report file is being generated
     * @return a {@link Path} object representing the generated report file
     * @throws RuntimeException if an error occurs while creating the report file
     */
    public Path doReportFile(String adopterName) {
        try {
            Path path = Path.of("C:\\");
            Path file = Files.createTempFile(path, adopterName + LocalDate.now() + "_", ".docx");

            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Рацион:");
            run.addBreak();
            run.setText(ration);
            run.addBreak();
            run.setText("Общее самочувствие и привыкание к новому месту:");
            run.addBreak();
            run.setText(health);
            run.addBreak();
            run.setText("Изменение в поведении: отказ от старых привычек, приобретение новых");
            run.addBreak();
            run.setText(behavior);
            run.addBreak();
            FileOutputStream out = new FileOutputStream(file.toFile());
            document.write(out);
            out.close();
            return file;
            // Delete the file when done
            //  Files.delete(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while creating the report file: " + e.getMessage());
        }
    }

    /**
     * Inserts a photo from the specified file path into an existing Word document at the end of the
     * document.
     *
     * @param photoPath the path to the photo file to be inserted
     * @param docPath   the path to the existing Word document
     * @throws RuntimeException if an error occurs while inserting the photo
     */
    public void insertPhoto(Path photoPath, Path docPath) {
        try {
            // Open the existing document file
            FileInputStream fis = new FileInputStream(docPath.toFile());
            XWPFDocument document = new XWPFDocument(fis);
            fis.close();

            // read the photo file into a byte array
            InputStream photoStream = new FileInputStream(photoPath.toString());


            // add the photo to the end of the document
            XWPFParagraph paragraph = document.getLastParagraph();
            XWPFRun run = paragraph.createRun();
            int format = XWPFDocument.PICTURE_TYPE_PNG;
            run.addPicture(photoStream, format, photoPath.getFileName().toString(), 3000000, 2100000);
            photoStream.close();

            // Save the modified document file
            FileOutputStream fos = new FileOutputStream(docPath.toFile());
            document.write(fos);
            fos.close();
        } catch (IOException | InvalidFormatException e) {
            // If any errors occur while inserting the photo, throw a RuntimeException with the error message
            e.printStackTrace();
            throw new RuntimeException("Error occurred while inserting the photo: " + e.getMessage());
        }
    }

}
