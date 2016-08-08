package javat.lang;

public class StringTest {

    public static void main(String[] args) {
        String str = "abc";
        str += 1;

        // 生成一个字符串："This is only a simple test"
        String str2 = "This is only a" + " simple" + " test";

        String emoji = "Jason#\uD83D\uDC4AM.H.UU@我やめて가운뎃소리";
        char[] chars = emoji.toCharArray();
        System.out.println(chars.length);
        for (char c : chars) {
            if (CharacterTest.isAscii(c)) {
                System.out.println("letterOrDigit=" + c);
            } else if (CharacterTest.isChinese(c)) {
                System.out.println("chinese=" + c);
            } else if (CharacterTest.isJanpanese(c)) {
                System.out.println("janpanese=" + c);
            } else if (CharacterTest.isHangul(c)) {
                System.out.println("hangul=" + c);
            } else {
                System.out.println("emoji=" + c);
            }
        }
    }

}
