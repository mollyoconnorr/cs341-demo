package edu.carroll.cs341.util;

public class Pass {
    public static void main(String[] args) {
        final String hash = Integer.toString("supersecret".hashCode());
        System.out.println(hash);
    }
}
