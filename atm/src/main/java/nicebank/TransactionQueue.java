package nicebank;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TransactionQueue {
    private static String MESSAGES_FOLDER = "./messages";
    private static String MESSAGE_FILE_PATH = "%s/%03d";
    private int nextId = 1;

    public static void clear(){
        try {
            FileUtils.deleteDirectory(new File(MESSAGES_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(MESSAGES_FOLDER).mkdir();
    }

    public void write(String transaction){
        String messageFilePath
                = String.format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(messageFilePath, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        writer.println(transaction);
        writer.close();

        nextId++;
    }

    public String read(){
        File messagesFolder = new File(MESSAGES_FOLDER);
        File[] messages = messagesFolder.listFiles();

        String message = "";

        if(messages != null && messages.length > 1){
            Arrays.sort(messages, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Integer.parseInt(o1.getName())
                            - Integer.parseInt(o2.getName());
                }
            });
        }

        Scanner scanner = null;

        try {
            scanner = new Scanner(messages[0]);

            if (scanner.hasNextLine()){
                message = scanner.nextLine();
                scanner.close();

                messages[0].delete();
            } else {
                scanner.close();
            }


        } catch (FileNotFoundException f){
            f.printStackTrace();
        }

        return message;
    }

}
