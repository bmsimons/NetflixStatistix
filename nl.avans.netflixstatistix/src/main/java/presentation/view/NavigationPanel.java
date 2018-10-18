package main.java.presentation.view;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JTabbedPane {
    public NavigationPanel(Dimension size){
        // Top Panel | Navigation Bar | Tabbed Pane
        setPreferredSize(size);
        addTab("Series", null, new SeriesPanel(size), "Zoek de statistieken van series");
        addTab("Series Per Account", null, new SeriesPerSubscriptionPanel(size), "Zoek de statistieken van series per account");
        addTab("Gekeken Films", null, new MovieWatchedPanel(size), "Zoek welke films er zijn bekeken per account");
        addTab("16- Film", null, new MovieBelowSixteenPanel(size), "Geef de film met de langste tijdsduur voor kijkers onder 16 jaar");
        addTab("Gehele Film", null, new MovieFullyWatchedPanel(size), "Geef aan hoe vaak een film volledig bekeken is");
        addTab("Profiel", null, new ProfilePanel(size), "Geef een overzicht voor het gegeven profiel");
        addTab("Accounts", null, new SubscriptionPanel(size), "Geef de accounts met slechts 1 profiel");
        addTab("Abonnee toevoegen", null, new SubscriptionCreatePanel(size), "Voeg een abonnee toe");
        addTab("Profiel toevoegen", null, new ProfileCreatePanel(size), "Voeg een profiel aan een abonnee toe");
    }
}
