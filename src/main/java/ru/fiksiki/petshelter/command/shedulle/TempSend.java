package ru.fiksiki.petshelter.command.shedulle;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.io.*;

@Component
public class TempSend extends Command {

    private final SendMessageService sendMessageService;
    public TempSend(SendMessageService sendMessageService) {
        super(CommandName.CHECK);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        long id = getId(update);
        InputFile inFile = new InputFile();
        inFile.setMedia(new File("C:\\Igor.txt"));

        sendMessageService.sendDocument(1207017951L,inFile);
    }
}
