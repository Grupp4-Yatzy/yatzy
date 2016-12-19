/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jensen.yatzy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author benjamin
 */
public class MenuView extends JPanel {

	JPanel centerPanel;

	public MenuView() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.getHSBColor(0.3305556f, 1.0f, 0.74f));

		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(300, 200));
		northPanel.setOpaque(false);

		Icon frame = new ImageIcon(getClass().getResource("/images/menubuttons/Frame.png"));
		Icon disabledFrame = new ImageIcon(getClass().getResource("/images/menubuttons/DisabledFrame.png"));
		Icon rollOverFrame = new ImageIcon(getClass().getResource("/images/menubuttons/RollOverFrame.png"));
		Icon pressedFrame = new ImageIcon(getClass().getResource("/images/menubuttons/PressedFrame.png"));
		Dimension bigButtonD = new Dimension(frame.getIconWidth(), frame.getIconHeight());

		Icon smallFrame = new ImageIcon(getClass().getResource("/images/menubuttons/smallFrame.png"));
		Icon smallDisabledFrame = new ImageIcon(getClass().getResource("/images/menubuttons/smallDisabledFrame.png"));
		Icon smallRollOverFrame = new ImageIcon(getClass().getResource("/images/menubuttons/smallRollOverFrame.png"));
		Icon smallPressedFrame = new ImageIcon(getClass().getResource("/images/menubuttons/smallPressedFrame.png"));
		Dimension smallButtonD = new Dimension(smallFrame.getIconWidth(), smallFrame.getIconHeight());

		String[] bigButtonTexts = {"Continue", "New Game", "Options", "Rules", "Quit"};
		String[] smallButtonTexts = {"Menu", "Roll (3)", "Done"};

		centerPanel = new JPanel();
		centerPanel.setPreferredSize(new Dimension(300, 600));
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		for (String buttonText : bigButtonTexts) {
			JButton bigButton = new JButton(buttonText);

			if (buttonText.equalsIgnoreCase("options"))
				bigButton.setEnabled(false);

			bigButton.setIcon(frame);
			bigButton.setDisabledIcon(disabledFrame);
			bigButton.setRolloverIcon(rollOverFrame);
			bigButton.setPressedIcon(pressedFrame);

			bigButton.setPreferredSize(bigButtonD);
			bigButton.setMaximumSize(bigButtonD);

			bigButton.setHorizontalTextPosition(JButton.CENTER);
			bigButton.setAlignmentX(CENTER_ALIGNMENT);

			bigButton.setBorderPainted(false);
			bigButton.setContentAreaFilled(false);

			bigButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			bigButton.setForeground(Color.getHSBColor(0.152778f, 0.91f, 0.92f));

			centerPanel.add(bigButton);

			Component filler = Box.createRigidArea(new Dimension(15, 5));
			centerPanel.add(filler);
		}

		for (String smallButtonText : smallButtonTexts) {
			JButton smallButton = new JButton(smallButtonText);

			smallButton.setIcon(smallFrame);
			smallButton.setDisabledIcon(smallDisabledFrame);
			smallButton.setRolloverIcon(smallRollOverFrame);
			smallButton.setPressedIcon(smallPressedFrame);

			smallButton.setPreferredSize(smallButtonD);
			smallButton.setMaximumSize(smallButtonD);

			smallButton.setHorizontalTextPosition(JButton.CENTER);
			smallButton.setAlignmentX(CENTER_ALIGNMENT);

			smallButton.setBorderPainted(false);
			smallButton.setContentAreaFilled(false);

			smallButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
			smallButton.setForeground(Color.getHSBColor(0.152778f, 0.91f, 0.92f));

			centerPanel.add(smallButton);
		}

		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
