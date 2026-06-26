package MutableString;

import java.util.Arrays;

public class MutableString {
    private char[] chars;
    private int nextFreeIndex;

    public MutableString(String s) {
        synchronized (this) {
            chars = s.toCharArray();
            nextFreeIndex = s.length();
        }
    }

    public synchronized MutableString append(String s) {
        for (int i = 0; i < s.length(); i++) {
            append(s.charAt(i));
            // try {
            // Thread.sleep(1000);
            // } catch (InterruptedException e) {
            // }
        }
        return this;
    }

    private synchronized void append(char c) {
        if (chars.length == nextFreeIndex) {
            if (chars.length == 0) {
                chars = new char[1];
            } else {
                chars = Arrays.copyOf(chars, chars.length * 2);
            }
        }
        chars[nextFreeIndex] = c;
        nextFreeIndex++;
    }

    public synchronized int length() {
        return nextFreeIndex;
    }

    @Override
    public synchronized String toString() {
        return new String(Arrays.copyOfRange(chars, 0, nextFreeIndex));
    }
}