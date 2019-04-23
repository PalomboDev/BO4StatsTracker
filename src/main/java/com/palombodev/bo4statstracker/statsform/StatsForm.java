/*
 * Created by JFormDesigner on Wed Dec 12 15:33:51 GMT-06:00 2018
 */

package com.palombodev.bo4statstracker.statsform;

import com.palombodev.bo4statstracker.BO4StatsTracker;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * @author PalomboDev
 */
public class StatsForm {

    public JFrame jFrame;

    public StatsForm() {
        initComponents();

        jFrame = new JFrame("BO4 Multiplayer Stats Tracker - By PalomboDev (XBOX)");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.panel3);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);

        this.updatingLabel.setVisible(false);
    }

    private void selectPlayerButtonActionPerformed(ActionEvent e) {
        String playerName = this.playerNameTextBox.getText();
        JSONObject jsonObject;

        try {
            jsonObject = BO4StatsTracker.getjReader().readJsonFromUrl(
                    "https://cod-api.theapinetwork.com/api/stats/bo4/" + playerName + "/xbl?type=multiplayer"
            );

            if (jsonObject.has("status") && jsonObject.get("status").toString().equalsIgnoreCase("error")) {
                JOptionPane.showMessageDialog(jFrame.getContentPane(), "This player could not be found.", "Error", JOptionPane.ERROR_MESSAGE);

                this.playerNameLabel.setText("Player: N/A");
                this.updatingLabel.setVisible(false);

                BO4StatsTracker.getPlayerManager().removePlayer();

                return;
            }

            JOptionPane.showMessageDialog(jFrame.getContentPane(), "You have connected with player " + playerName + ".", "Connected", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException exception) {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(jFrame.getContentPane(), "Something has happened. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BO4StatsTracker.getPlayerManager().setPlayer(playerName, jsonObject);
        this.playerNameLabel.setText("Player: " + playerName);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - PalomboDev
    public JPanel panel3;
    public JTabbedPane tabPane;
    public JPanel connectionTab;
    public JTextArea playerNameTextBox;
    JLabel playerNameLabel;
    public JLabel updatingLabel;
    public JLabel programNameLabel;
    public JButton selectPlayerButton;
    public JPanel statsTab;
    public JLabel playerLabel;
    public JLabel curWinStreakLael;
    public JLabel killsLabel;
    public JLabel meleesLabel;
    public JLabel ekiaLabel;
    public JLabel deathsLabel;
    public JLabel prestigeLabel;
    public JLabel levelLabel;
    public JLabel kdLabel;
    public JLabel longestKillStreakLabel;
    public JLabel hitsLabel;
    public JLabel winsLabel;
    public JLabel lossesLabel;
    public JLabel gamesPlayedLabel;
    public JLabel totalShotsLabel;
    public JLabel teamKillsLabel;
    public JLabel suicidesLabel;
    public JLabel killsConfirmedLabel;
    public JLabel killsDeniedLabel;
    public JLabel capturesLabel;
    public JLabel defendsLabel;
    public JLabel timePlayedLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - PalomboDev
        panel3 = new JPanel();
        tabPane = new JTabbedPane();
        connectionTab = new JPanel();
        playerNameTextBox = new JTextArea();
        playerNameLabel = new JLabel();
        updatingLabel = new JLabel();
        programNameLabel = new JLabel();
        selectPlayerButton = new JButton();
        statsTab = new JPanel();
        playerLabel = new JLabel();
        curWinStreakLael = new JLabel();
        killsLabel = new JLabel();
        meleesLabel = new JLabel();
        ekiaLabel = new JLabel();
        deathsLabel = new JLabel();
        prestigeLabel = new JLabel();
        levelLabel = new JLabel();
        kdLabel = new JLabel();
        longestKillStreakLabel = new JLabel();
        hitsLabel = new JLabel();
        winsLabel = new JLabel();
        lossesLabel = new JLabel();
        gamesPlayedLabel = new JLabel();
        totalShotsLabel = new JLabel();
        teamKillsLabel = new JLabel();
        suicidesLabel = new JLabel();
        killsConfirmedLabel = new JLabel();
        killsDeniedLabel = new JLabel();
        capturesLabel = new JLabel();
        defendsLabel = new JLabel();
        timePlayedLabel = new JLabel();

        //======== panel3 ========
        {

            // JFormDesigner evaluation mark

            panel3.setLayout(null);

            //======== tabPane ========
            {

                //======== connectionTab ========
                {
                    connectionTab.setLayout(null);

                    //---- playerNameTextBox ----
                    playerNameTextBox.setForeground(Color.gray);
                    playerNameTextBox.setToolTipText("Insert Player Name Here");
                    playerNameTextBox.setBackground(Color.white);
                    playerNameTextBox.setText("Insert player name here");
                    connectionTab.add(playerNameTextBox);
                    playerNameTextBox.setBounds(125, 85, 235, 22);

                    //---- playerNameLabel ----
                    playerNameLabel.setText("Player: N/A");
                    connectionTab.add(playerNameLabel);
                    playerNameLabel.setBounds(40, 195, 235, playerNameLabel.getPreferredSize().height);

                    //---- updatingLabel ----
                    updatingLabel.setText("Updates every 5 seconds");
                    connectionTab.add(updatingLabel);
                    updatingLabel.setBounds(315, 195, 175, updatingLabel.getPreferredSize().height);

                    //---- programNameLabel ----
                    programNameLabel.setText("BO4 Stats Tracker - By PalomboDev");
                    programNameLabel.setFont(new Font("Tarzan", Font.PLAIN, 12));
                    connectionTab.add(programNameLabel);
                    programNameLabel.setBounds(125, 40, 240, programNameLabel.getPreferredSize().height);

                    //---- selectPlayerButton ----
                    selectPlayerButton.setText("Select Player");
                    selectPlayerButton.addActionListener(e -> {
			selectPlayerButtonActionPerformed(e);
		});
                    connectionTab.add(selectPlayerButton);
                    selectPlayerButton.setBounds(175, 110, 140, selectPlayerButton.getPreferredSize().height);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < connectionTab.getComponentCount(); i++) {
                            Rectangle bounds = connectionTab.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = connectionTab.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        connectionTab.setMinimumSize(preferredSize);
                        connectionTab.setPreferredSize(preferredSize);
                    }
                }
                tabPane.addTab("Connection", connectionTab);

                //======== statsTab ========
                {
                    statsTab.setLayout(null);

                    //---- playerLabel ----
                    playerLabel.setText("Player: N/A");
                    statsTab.add(playerLabel);
                    playerLabel.setBounds(10, 15, 190, playerLabel.getPreferredSize().height);

                    //---- curWinStreakLael ----
                    curWinStreakLael.setText("Current Win Streak: N/A");
                    statsTab.add(curWinStreakLael);
                    curWinStreakLael.setBounds(210, 15, 200, curWinStreakLael.getPreferredSize().height);

                    //---- killsLabel ----
                    killsLabel.setText("Kills: N/A");
                    statsTab.add(killsLabel);
                    killsLabel.setBounds(10, 75, 140, 16);

                    //---- meleesLabel ----
                    meleesLabel.setText("Melees: N/A");
                    statsTab.add(meleesLabel);
                    meleesLabel.setBounds(210, 165, 150, 16);

                    //---- ekiaLabel ----
                    ekiaLabel.setText("EKIA: N/A");
                    statsTab.add(ekiaLabel);
                    ekiaLabel.setBounds(10, 60, 135, 16);

                    //---- deathsLabel ----
                    deathsLabel.setText("Deaths: N/A");
                    statsTab.add(deathsLabel);
                    deathsLabel.setBounds(10, 90, 140, 16);

                    //---- prestigeLabel ----
                    prestigeLabel.setText("Prestige: N/A");
                    statsTab.add(prestigeLabel);
                    prestigeLabel.setBounds(10, 45, 140, 16);

                    //---- levelLabel ----
                    levelLabel.setText("Level: N/A");
                    statsTab.add(levelLabel);
                    levelLabel.setBounds(10, 30, 120, 16);

                    //---- kdLabel ----
                    kdLabel.setText("KD: N/A");
                    statsTab.add(kdLabel);
                    kdLabel.setBounds(10, 105, 140, 16);

                    //---- longestKillStreakLabel ----
                    longestKillStreakLabel.setText("Longest Kill Streak: N/A");
                    statsTab.add(longestKillStreakLabel);
                    longestKillStreakLabel.setBounds(10, 165, 185, 16);

                    //---- hitsLabel ----
                    hitsLabel.setText("Hits: N/A");
                    statsTab.add(hitsLabel);
                    hitsLabel.setBounds(210, 150, 165, 16);

                    //---- winsLabel ----
                    winsLabel.setText("Wins: N/A");
                    statsTab.add(winsLabel);
                    winsLabel.setBounds(10, 120, 140, 16);

                    //---- lossesLabel ----
                    lossesLabel.setText("Losses: N/A");
                    statsTab.add(lossesLabel);
                    lossesLabel.setBounds(10, 135, 140, 16);

                    //---- gamesPlayedLabel ----
                    gamesPlayedLabel.setText("Games Played: N/A");
                    statsTab.add(gamesPlayedLabel);
                    gamesPlayedLabel.setBounds(10, 150, 165, 16);

                    //---- totalShotsLabel ----
                    totalShotsLabel.setText("Total Shots: N/A");
                    statsTab.add(totalShotsLabel);
                    totalShotsLabel.setBounds(210, 30, 140, totalShotsLabel.getPreferredSize().height);

                    //---- teamKillsLabel ----
                    teamKillsLabel.setText("Team Kills: N/A");
                    statsTab.add(teamKillsLabel);
                    teamKillsLabel.setBounds(210, 45, 130, teamKillsLabel.getPreferredSize().height);

                    //---- suicidesLabel ----
                    suicidesLabel.setText("Suicides: N/A");
                    statsTab.add(suicidesLabel);
                    suicidesLabel.setBounds(210, 60, 135, suicidesLabel.getPreferredSize().height);

                    //---- killsConfirmedLabel ----
                    killsConfirmedLabel.setText("Kills Confirmed: N/A");
                    statsTab.add(killsConfirmedLabel);
                    killsConfirmedLabel.setBounds(210, 75, 160, killsConfirmedLabel.getPreferredSize().height);

                    //---- killsDeniedLabel ----
                    killsDeniedLabel.setText("Kills: Denied: N/A");
                    statsTab.add(killsDeniedLabel);
                    killsDeniedLabel.setBounds(210, 90, 140, killsDeniedLabel.getPreferredSize().height);

                    //---- capturesLabel ----
                    capturesLabel.setText("Captures: N/A");
                    statsTab.add(capturesLabel);
                    capturesLabel.setBounds(210, 105, 175, capturesLabel.getPreferredSize().height);

                    //---- defendsLabel ----
                    defendsLabel.setText("Defends: N/A");
                    statsTab.add(defendsLabel);
                    defendsLabel.setBounds(210, 120, 135, defendsLabel.getPreferredSize().height);

                    //---- timePlayedLabel ----
                    timePlayedLabel.setText("Time Played: N/A");
                    statsTab.add(timePlayedLabel);
                    timePlayedLabel.setBounds(210, 135, 135, timePlayedLabel.getPreferredSize().height);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < statsTab.getComponentCount(); i++) {
                            Rectangle bounds = statsTab.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = statsTab.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        statsTab.setMinimumSize(preferredSize);
                        statsTab.setPreferredSize(preferredSize);
                    }
                }
                tabPane.addTab("Stats", statsTab);
            }
            panel3.add(tabPane);
            tabPane.setBounds(0, 0, 500, 250);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


}
