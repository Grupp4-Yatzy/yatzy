package com.jensen.yatzy.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Class for holding the constant icons used for the menu buttons.
 *
 * @author Benjamin Rosman
 */
public class ButtonIcon {

  /** Yellow frame icon for menu buttons */
  public static final Icon FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/Frame.png"));
  /** Disabled frame icon for menu buttons */
  public static final Icon DISABLED_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/DisabledFrame.png"));
  /** Roll over frame icon for menu buttons */
  public static final Icon ROLL_OVER_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/RollOverFrame.png"));
  /** Pressed frame icon for menu buttons */
  public static final Icon PRESSED_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/PressedFrame.png"));

  /** Yellow frame icon for small menu buttons */
  public static final Icon SMALL_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/smallFrame.png"));
  /** Disabled frame icon for small menu buttons */
  public static final Icon SMALL_DISABLED_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/smallDisabledFrame.png"));
  /** Roll over frame icon for small menu buttons */
  public static final Icon SMALL_ROLL_OVER_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/smallRollOverFrame.png"));
  /** Pressed frame icon for small menu buttons */
  public static final Icon SMALL_PRESSED_FRAME = new ImageIcon(Constant.class.getResource("/images/menubuttons/smallPressedFrame.png"));

}
