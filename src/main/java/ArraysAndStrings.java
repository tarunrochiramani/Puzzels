public class ArraysAndStrings {

    public boolean uniqueChars(String str) {
        if (str == null || str.length() == 0) {
            return false; // or throw exception
        }

        int checker = 0;
        for (char c : str.toCharArray()) {
            int rightShiftedValue = 1 << c;
            if ((checker & rightShiftedValue) > 0) {
                return false;
            }
            checker |= rightShiftedValue;

            System.out.println("Right shifted value: " + rightShiftedValue);
            System.out.println("Checker " + checker);

        }

        return true;
    }


    public String reverse(String str) throws Exception {
        if (str == null || str.isEmpty()) {
            throw new Exception("Empty String");
        }

        char[] chars = str.toCharArray();
        for (int start=0, end=chars.length-1; start < end; start++, end--) {
            if (chars[start] != chars[end]){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
            }
        }

        return new String(chars);
    }

    /**
     * Consider whitespace as a character
     * Consider case insensitive
     * @return
     */
    public boolean checkAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        try {
            if (bitManupilation(str1.toLowerCase()) == bitManupilation(str2.toUpperCase())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private int bitManupilation(String str) throws Exception {
        if (str.isEmpty()) {
            throw new Exception("Empty String");
        }

        int result = 0;
        for (char c : str.toCharArray()) {
            result |= (1 << c);
        }

        return result;
    }

    /**
     * assume the last char would be a non-whitespace
     * assume char array has space at the end for replacements i.e space to %20
     * @param characters
     */
    public void insert20AtWhiteSpace(char[] characters) {

        int nonSpaceCharacterIndex = 0;
        int spacesFound = 0;
        for (int count = 0; count < characters.length; count++) {
            if (characters[count] != ' ') {
                nonSpaceCharacterIndex = count;
            } else {
                spacesFound++;
            }
        }

        if (spacesFound == 0) {
            return;
        }

        int totalSize = characters.length -1;
        while (true) {
            if (totalSize == nonSpaceCharacterIndex) break;

            if (characters[nonSpaceCharacterIndex] != ' ') {
                characters[totalSize--] = characters[nonSpaceCharacterIndex];
            } else {
                characters[totalSize--] = '0';
                characters[totalSize--] = '2';
                characters[totalSize--] = '%';
            }

            nonSpaceCharacterIndex --;
        }
    }


    public String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        char lastChar = '\0';
        for (char c : input.toCharArray()) {
            if (c != lastChar) {
                if (count > 1) {
                    stringBuilder.append(count);
                }
                count = 1;
                stringBuilder.append(c);
            } else {
                count ++;
            }

            lastChar = c;
        }

        if (count > 1) {
            stringBuilder.append(count);
        }

        return stringBuilder.toString();
    }
}
