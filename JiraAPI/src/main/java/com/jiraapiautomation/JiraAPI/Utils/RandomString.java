package com.jiraapiautomation.JiraAPI.Utils;

import java.util.Random;

public class RandomString {
	private static final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int length = 15; // Desired length of the random string

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(character.length());
            char randomChar = character.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }	
	}

