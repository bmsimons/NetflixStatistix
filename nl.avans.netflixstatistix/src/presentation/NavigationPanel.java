package presentation;

import domain.Program;
import domain.Subscription;
import logic.ProgramManager;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class NavigationPanel extends JTabbedPane {
    UserInterface ui;
    SeriesPanel seriesPanel;

    public NavigationPanel(Dimension size, UserInterface ui){
        // Top Panel | Navigation Bar | Tabbed Pane
        setPreferredSize(size);

        this.ui = ui;

        seriesPanel = new SeriesPanel(size, ui);

        addTab("Series", null, seriesPanel, "Zoek de statistieken van series");
        addTab("Series Per Abonnee", null, new SeriesPerSubscriptionPanel(size), "Zoek de statistieken van series per abonnee");
        addTab("Gekeken Films", null, new MovieWatchedPanel(size), "Zoek welke films er zijn bekeken per abonnee");
        addTab("16- Film", null, new MovieBelowSixteenPanel(size), "Geef de film met de langste tijdsduur voor kijkers onder 16 jaar");
        addTab("Gehele Film", null, new MovieFullyWatchedPanel(size), "Geef aan hoe vaak een film volledig bekeken is");
        addTab("Profiel", null, new ProfilePanel(size), "Geef een overzicht voor het gegeven profiel");
        addTab("Abonnee", null, new SubscriptionPanel(size), "Geef de abonnees met slechts 1 profiel");
        addTab("Abonnee toevoegen", null, new SubscriptionCreatePanel(size), "Voeg een abonnee toe");
        addTab("Profiel toevoegen", null, new ProfileCreatePanel(size), "Voeg een profiel aan een abonnee toe");

        this.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println("Tab: " + NavigationPanel.super.getSelectedIndex());

                switch (NavigationPanel.super.getSelectedIndex()) {
                    case 0:
                        seriesPanel.seriesComboBox.removeAllItems();

                        for (Program p : ui.getProgramManager().getSeries()) {
                            seriesPanel.seriesComboBox.addItem(p.getTitle());
                        }

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
