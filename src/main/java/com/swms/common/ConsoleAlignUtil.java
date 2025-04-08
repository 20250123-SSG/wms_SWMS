package com.swms.common.util;

public class ConsoleAlignUtil {

    // 오른쪽으로 패딩해서 일정한 너비로 맞춰줌
    public static String padRight(String input, int targetLength) {
        if (input == null) input = "";
        int paddingLength = targetLength - getConsoleLength(input);
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < paddingLength; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    // 왼쪽으로 패딩해서 오른쪽 정렬
    public static String padLeft(String input, int targetLength) {
        if (input == null) input = "";
        int paddingLength = targetLength - getConsoleLength(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paddingLength; i++) {
            sb.append(" ");
        }
        sb.append(input);
        return sb.toString();
    }

    // 글자 수 계산 (한글 등 전각 문자는 2칸으로 계산)
    public static int getConsoleLength(String input) {
        int length = 0;
        for (char ch : input.toCharArray()) {
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ||
                    Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                    Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HIRAGANA ||
                    Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.KATAKANA) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length;
    }

    // 가운데 정렬도 필요하면 추가 가능
    public static String padCenter(String input, int targetLength) {
        if (input == null) input = "";
        int padding = targetLength - getConsoleLength(input);
        int padLeft = padding / 2;
        int padRight = padding - padLeft;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padLeft; i++) sb.append(" ");
        sb.append(input);
        for (int i = 0; i < padRight; i++) sb.append(" ");
        return sb.toString();
    }
}