package presentation;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class FooterPanel extends JPanel {

    public FooterPanel(Dimension size){
        // Bottom Panel | Footer
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(size);
        setLayout(new BorderLayout());

        // Create the components
        JLabel projectNameLabel = new JLabel("Netflix Statistix");
        projectNameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel projectMembersLabel = new JLabel("Informatica 2018 23IVK1 - Bart, Floris en Thimo");
        projectMembersLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Adding components to panel
        add(projectNameLabel);
        add(projectMembersLabel, BorderLayout.LINE_END);

    }
}
