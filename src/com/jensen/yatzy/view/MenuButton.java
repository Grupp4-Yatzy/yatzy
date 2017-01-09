package com.jensen.yatzy.view;

import com.jensen.yatzy.model.ButtonIcon;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Definition of the menu buttons, so they all look the same.
 *
 * @author Benjamin Rosman
 * @see JButton
 * @see ButtonIcon
 */
public class MenuButton extends JButton {

  /**
   * Creates a menu button. With a predefined text color, font and horizontal text position. Without
   * a border and content area. The preferre size and maximum size is set to match the icon size.
   * Uses ButtonIcon.
   *
   * @param txt   The text to be displayed on the button.
   * @param small If true the button will be small otherwise large. Small and large uses different
   *              sized icons.
   *
   * @see ButtonIcon
   */
  public MenuButton(String txt, boolean small) {
    super(txt);
    if (small) {
      initSmallButton();
    } else {
      initLargeButton();
    }
    Dimension d = new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight());
    setPreferredSize(d);
    setMaximumSize(d);
    
    setHorizontalTextPosition(JButton.CENTER);
    setAlignmentX(CENTER_ALIGNMENT);

    setBorderPainted(false);
    setContentAreaFilled(false);
    // set text color to match the frame
    setForeground(Color.getHSBColor(0.152778f, 0.91f, 0.92f));
  }

  private void initSmallButton() {
    setIcon(ButtonIcon.SMALL_FRAME);
    setDisabledIcon(ButtonIcon.SMALL_DISABLED_FRAME);
    setRolloverIcon(ButtonIcon.SMALL_ROLL_OVER_FRAME);
    setPressedIcon(ButtonIcon.SMALL_PRESSED_FRAME);

    setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
  }

  private void initLargeButton() {
    setIcon(ButtonIcon.FRAME);
    setDisabledIcon(ButtonIcon.DISABLED_FRAME);
    setRolloverIcon(ButtonIcon.ROLL_OVER_FRAME);
    setPressedIcon(ButtonIcon.PRESSED_FRAME);

    setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
  }

}
