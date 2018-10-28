package presentation;

import presentation.events.ChooseSeriesItemListener;
import presentation.events.SearchSubscriberActionListener;

import javax.swing.*;
import java.awt.*;

// Panel that will display information about which episodes were watched by profiles associated with given subscription

public class SeriesPerSubscriptionPanel extends JPanel {
    private UserInterface ui;
    private JTextField subscriptionTextField;
    private JTextArea watchedEpisodesTextArea;
    private JComboBox<String> seriesComboBox;
    private int selectedSubscriptionID;

    public SeriesPerSubscriptionPanel(Dimension size, UserInterface ui){
        this.ui = ui;

        setPreferredSize(size);
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        subscriptionTextField = new JTextField();
        subscriptionTextField.setMinimumSize(new Dimension(150, 24));
        subscriptionTextField.setPreferredSize(new Dimension(220, 24));

        JButton searchButton = new JButton("Zoek Abonnee");
        searchButton.setMinimumSize(new Dimension(50,24));

        searchButton.addActionListener(new SearchSubscriberActionListener(this));

        JLabel seriesLabel = new JLabel("Selecteer een serie");
        seriesComboBox = new JComboBox<String>();
        seriesComboBox.addItemListener(new ChooseSeriesItemListener(this));

        watchedEpisodesTextArea = new JTextArea(13, 35);
        watchedEpisodesTextArea.setText("Selecteer een abonnee & serie.");
        watchedEpisodesTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(watchedEpisodesTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the constraints, add the components to the panel
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,0);
        add(subscriptionTextField, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        add(searchButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(seriesLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(seriesComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;

        add(scrollPane, constraints);
    }

    public UserInterface getUi() {
        return this.ui;
    }

    public JTextField getSubscriptionTextField() {
        return this.subscriptionTextField;
    }

    public JTextArea getWatchedEpisodesTextArea() {
        return this.watchedEpisodesTextArea;
    }

    public JComboBox<String> getSeriesComboBox() { return this.seriesComboBox; }

    public int getSelectedSubscriptionID() {
        return this.selectedSubscriptionID;
    }

    public void setSelectedSubscriptionID(int subscriptionID) {
        this.selectedSubscriptionID = subscriptionID;
    }
}
