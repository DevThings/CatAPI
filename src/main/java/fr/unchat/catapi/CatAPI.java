package fr.unchat.catapi;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CatAPI {
    public boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }
}
