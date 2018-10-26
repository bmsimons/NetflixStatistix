package presentation;

import domain.Movie;
import domain.Program;
import domain.Subscription;
import logic.ProgramManager;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class NavigationPanel extends JTabbedPane {
    UserInterface ui;
    SeriesPanel seriesPanel;
    SeriesPerSubscriptionPanel seriesPerSubscriptionPanel;
    MovieWatchedPanel movieWatchedPanel;
    MovieBelowSixteenPanel movieBelowSixteenPanel;
    MovieFullyWatchedPanel movieFullyWatchedPanel;
    ProfilePanel profilePanel;
    SubscriptionPanel subscriptionPanel;
    ProfileAddMoviesWatchedPanel profileAddMoviesWatchedPanel;
    ProfileAddSeriesWatchedPanel profileAddSeriesWatchedPanel;

    public NavigationPanel(Dimension size, UserInterface ui){
        // Top Panel | Navigation Bar | Tabbed Pane
        setPreferredSize(size);

        this.ui = ui;

        seriesPanel = new SeriesPanel(size, ui);
        seriesPerSubscriptionPanel = new SeriesPerSubscriptionPanel(size, ui);
        movieWatchedPanel = new MovieWatchedPanel(size, ui);
        movieBelowSixteenPanel = new MovieBelowSixteenPanel(size, ui);
        movieFullyWatchedPanel = new MovieFullyWatchedPanel(size, ui);
        profilePanel = new ProfilePanel(size, ui);
        subscriptionPanel = new SubscriptionPanel(size, ui);
        profileAddMoviesWatchedPanel = new ProfileAddMoviesWatchedPanel(size, ui);
        profileAddSeriesWatchedPanel = new ProfileAddSeriesWatchedPanel(size, ui);

        addTab("Series", null, seriesPanel, "Zoek de statistieken van series");
        addTab("Series Per Abonnee", null, seriesPerSubscriptionPanel, "Zoek de statistieken van series per abonnee");
        addTab("Gekeken Films", null, movieWatchedPanel, "Zoek welke films er zijn bekeken per abonnee");
        addTab("16- Film", null, movieBelowSixteenPanel, "Geef de film met de langste tijdsduur voor kijkers onder 16 jaar");
        addTab("Gehele Film", null, movieFullyWatchedPanel, "Geef aan hoe vaak een film volledig bekeken is");
        addTab("Profiel", null, profilePanel, "Geef een overzicht voor het gegeven profiel");
        addTab("Abonnee", null, subscriptionPanel, "Geef de abonnees met slechts 1 profiel");
        addTab("Abonnee toevoegen", null, new SubscriptionCreatePanel(size), "Voeg een abonnee toe");
        addTab("Profiel toevoegen", null, new ProfileCreatePanel(size), "Voeg een profiel aan een abonnee toe");
        addTab("Gekeken films toevoegen", null, profileAddMoviesWatchedPanel, "Voeg gekeken films toe aan een profiel");
        addTab("Gekeken series toevoegen",null,profileAddSeriesWatchedPanel,"Voeg gekeken afleveringen van een serie toe aan een profiel");

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

                        Movie longestMovieUnder16 = ui.getProgramManager().getLongestMovieUnder16();
                        movieBelowSixteenPanel.getLongestMovieLabel().setText("De langste film voor kinderen onder de 16 is " + longestMovieUnder16.getTitle());

                        break;
                    case 4:
                        ArrayList<Movie> movies = ui.getProgramManager().getMovies();

                        movieFullyWatchedPanel.getMovieComboBox().removeAllItems();

                        String movieStatistics = "";

                        for (Movie m : movies) {
                            movieFullyWatchedPanel.getMovieComboBox().addItem(m.getTitle());
                            if (movieStatistics.equals("")) {
                                movieStatistics += "Titel: " + m.getTitle() + "\nGenre: " + m.getGenre() + "\nSpeeltijd: " + m.getDuration() + " minuten\nLeeftijdsindicatie: " + m.getAgeIndication() + "\nTaal: " + m.getLanguage() + "\n\nAantal kijkers dat deze film volledig gezien heeft:  " + movieFullyWatchedPanel.getUi().getProgramManager().getMovieFullyWatchedCount(m);
                            }
                        }

                        movieFullyWatchedPanel.getMovieStatisticsTextArea().setText(movieStatistics);

                        break;
                    case 5:
                        Set<Subscription> subscriptions = ui.getSubscriptionManager().getSubscriptionsWithAtleastOneProfile();

                        String subscriptionPanelText = "";

                        for (Subscription s : subscriptions) {
                            subscriptionPanelText += s.getName() + "\n";
                        }

                        subscriptionPanel.getSubscriptionTextArea().setText(subscriptionPanelText);

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
