package presentation;

import domain.*;
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
    ProfileCreatePanel profileCreatePanel;
    ProfileAddMoviesWatchedPanel profileAddMoviesWatchedPanel;
    ProfileAddSeriesWatchedPanel profileAddSeriesWatchedPanel;
    SubscriptionCreatePanel subscriptionCreatePanel;

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
        subscriptionCreatePanel = new SubscriptionCreatePanel(size, ui);

        profileCreatePanel = new ProfileCreatePanel(size, ui);
        profileAddMoviesWatchedPanel = new ProfileAddMoviesWatchedPanel(size, ui);
        profileAddSeriesWatchedPanel = new ProfileAddSeriesWatchedPanel(size, ui);

        addTab("Series", null, seriesPanel, "Zoek de statistieken van series");
        addTab("Series Per Abonnee", null, seriesPerSubscriptionPanel, "Zoek de statistieken van series per abonnee");
        addTab("Gekeken Films", null, movieWatchedPanel, "Zoek welke films er zijn bekeken per abonnee");
        addTab("16- Film", null, movieBelowSixteenPanel, "Geef de film met de langste tijdsduur voor kijkers onder 16 jaar");
        addTab("Gehele Film", null, movieFullyWatchedPanel, "Geef aan hoe vaak een film volledig bekeken is");
        addTab("Profiel", null, profilePanel, "Geef een overzicht voor het gegeven profiel");
        addTab("Abonnee", null, subscriptionPanel, "Geef de abonnees met slechts 1 profiel");
        addTab("Abonnee toevoegen", null, subscriptionCreatePanel, "Voeg een abonnee toe");
        addTab("Profiel toevoegen", null, profileCreatePanel, "Voeg een profiel aan een abonnee toe");
        addTab("Gekeken films toevoegen", null, profileAddMoviesWatchedPanel, "Voeg gekeken films toe aan een profiel");
        addTab("Gekeken series toevoegen",null,profileAddSeriesWatchedPanel,"Voeg gekeken afleveringen van een serie toe aan een profiel");

        this.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                switch (NavigationPanel.super.getSelectedIndex()) {
                    case 0:

                        //this case is for Series panel

                        seriesPanel.clearSeriesComboBox();
                        JComboBox<String> seriesBox = seriesPanel.getSeriesComboBox();
                        for (Program p : ui.getProgramManager().getSeries()) {
                            seriesBox.addItem(p.getTitle());
                        }

                        break;
                    case 1:

                        //this case is for Series per subscription panel

                        JComboBox<String> seriesComboBox = seriesPerSubscriptionPanel.getSeriesComboBox();
                        ArrayList<Series> seriesList = ui.getProgramManager().getSeries();
                        for (Series s : seriesList){
                            seriesComboBox.addItem(s.getTitle());
                        }
                        break;
                    case 2:

                        //this case is for Watched movies panel

                        break;
                    case 3:

                        //this case is for Movies below 16 panel


                        Movie longestMovieUnder16 = ui.getProgramManager().getLongestMovieUnder16();
                        movieBelowSixteenPanel.getLongestMovieLabel().setText("De langste film voor kinderen onder de 16 is " + longestMovieUnder16.getTitle());

                        break;
                    case 4:

                        //this case is for Fully watched movies panel

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

                        //this case is for the profile panel

                        break;
                    case 6:

                        //this case is for Single profile per subscription panel

                        Set<Subscription> subscriptions = ui.getSubscriptionManager().getSubscriptionsWithOnlyOneProfile();

                        String subscriptionPanelText = "";

                        for (Subscription s : subscriptions) {
                            subscriptionPanelText += s.getName() + "\n";
                        }

                        subscriptionPanel.getSubscriptionTextArea().setText(subscriptionPanelText);
                        break;
                    case 7:

                        //this case is for Add Subscription panel

                        break;
                    case 8:

                        //this case is for Add Profile panel

                        JComboBox<Subscription> subscriptionComboBox = profileCreatePanel.getSubscriptionComboBox();
                        ArrayList<Subscription> subscriptionArrayList = ui.getSubscriptionManager().getSubscriptions();
                        for (Subscription s : subscriptionArrayList){
                            subscriptionComboBox.addItem(s);
                        }
                        break;
                    case 9:

                        //this case is for Add watched movies panel

                        JComboBox<Movie> movieComboBox = profileAddMoviesWatchedPanel.getMovieComboBox();
                        ArrayList<Movie> moviesList = ui.getProgramManager().getMovies();

                        profileAddMoviesWatchedPanel.clearMovieComboBox();

                        for (Movie m : moviesList){
                            movieComboBox.addItem(m);
                        }
                        break;
                    case 10:

                        //this case is for Add watched series panel

                        JComboBox<Series> seriesCBox = profileAddSeriesWatchedPanel.getSeriesComboBox();
                        ArrayList<Series> seriesArrayList = ui.getProgramManager().getSeries();


                        for (Series s : seriesArrayList){
                            seriesCBox.addItem(s);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        // Call the changeListener, fixes empty comboBox on launch
        changeListener.stateChanged(null);
    }
}
