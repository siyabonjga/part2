/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.message.java;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Student
 */
public class MessageJava {

    public static void main(String[] args) {
      
// Message class
final class Message {

    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String message;
    private final String messageHash;

    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();

    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random 10 digit message ID
    // Generate random message ID
    private String generateMessageID() {

        Random random = new Random();
        long number = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    // Ensure message ID is not more than 10 characters
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Recipient must start with international code and max 10 chars after +
    public String checkRecipientCell() {

        if (recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // Create message hash using:
    // First 2 digits of ID
    // Message number
    // First and last words of message
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    // Message length check
    public String checkMessageLength() {

        if (message.length() <= 250) {
            return "Message ready to send.";
        }

        int exceeded = message.length() - 250;

        return "Message exceeds 250 characters by " + exceeded +
                ", please reduce the size.";
    }

    // Send, store or discard
    public String sentMessage(String choice) {

        switch (choice.toLowerCase()) {

            case "send" -> {
                sentMessages.add(this);
                return "Message successfully sent.";
            }

            case "store" -> {
                storedMessages.add(this);
                storeMessage();
                return "Message successfully stored.";
            }

            case "discard" -> {
                return "Press 0 to delete the message.";
            }

            default -> {
                return "Invalid option.";
            }
        }
    }

    // Print messages
    // Print all sent messages
    public static String printMessages() {

        if (sentMessages.isEmpty()) {
            return "No messages sent.";
        }

        String result = "\nSENT MESSAGES\n";

        for (Message msg : sentMessages) {

            result += "------------------------------\n";
            result += "Message ID: " + msg.messageID + "\n";
            result += "Message Hash: " + msg.messageHash + "\n";
            result += "Recipient: " + msg.recipient + "\n";
            result += "Message: " + msg.message + "\n";
        }

        return result;
    }

    // Total messages
    // Return total sent messages
    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    // Store in JSON format
    public void storeMessage() {

        String json = "{\n"+
                "  \"messageID\": \"" + messageID + "\",\n" +
                "  \"messageHash\": \"" + messageHash + "\",\n" +
                "  \"recipient\": \"" + recipient + "\",\n" +
                "  \"message\": \"" + message + "\"\n" +
                "}";

        System.out.println("\nJSON STORED MESSAGE:");
        System.out.println(json);
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    

