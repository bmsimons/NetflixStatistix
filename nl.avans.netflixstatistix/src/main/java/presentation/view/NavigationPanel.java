package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JTabbedPane {
    public NavigationPanel(Dimension size){
        // Top Panel | Navigation Bar
        System.out.println(size.getHeight() + " "+ size.getWidth());
        setPreferredSize(size);
        addTab("Series", null, new SeriesPanel(new Dimension(getWidth(), getHeight())), "Zoek de statistieken van series");
        addTab("Series Per Account", null, null, "Zoek de statistieken van series per account");
        addTab("Gekeken Films", null, null, "Zoek welke films er zijn bekeken per account");
        addTab("16- Films", null, null, "Geef de film met de langste tijdsduur voor kijkers onder 16 jaar");
        addTab("Profiel", null, new ProfilePanel(new Dimension(getWidth(), getHeight())), "Geef de accounts met slechts 1 profiel");
        addTab("Gehele Film", null, null, "Geef aan hoe vaak een film volledig bekeken is");
        addTab("Abonnee toevoegen", null, null, "Voeg een abonnee toe");
        addTab("Profiel Toevoegen", null, null, "Voeg een profiel aan een abonnee toe");
    }
}
