
package com.jensen.yatzy.model;

/**
 *
 * @author RobertoBlanco
 */
public enum YatzyMode {
    FORCED_YATZY("Forced"), NORMAL_YATZY("Normal"), WILD_YATZY("Wild");
    
    private String mode;
   
    private YatzyMode(String s){
            mode = s;
   
    }
    
    public String getMode(){
        return mode;
    }
}
