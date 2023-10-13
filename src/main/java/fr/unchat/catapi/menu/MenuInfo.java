package fr.unchat.catapi.menu;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuInfo {
    String title() default "&0Menu";
    int slots() default 27;
}
