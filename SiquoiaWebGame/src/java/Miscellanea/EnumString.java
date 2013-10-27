/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscellanea;

/**
 *
 * @author mr.nam
 */
public enum EnumString {

    MAIN("main"), START("Start New Quiz"), OPTION("Option"), TUTORIAL("Tutorial"), EXIT("Exit"), LOGIN("Log in"),
    LOGIN_C("l"), TUTORIAL_C("t"), EXIT_C("e"), OPTION_C("o"), BACK("Back"), BACK_C("b"),
    START_C("s"), A("a"), B("b"), C("c"), D("d"), TUTORIAL_TOPIC("Algebra");
    private String s;

    private EnumString(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }
}
