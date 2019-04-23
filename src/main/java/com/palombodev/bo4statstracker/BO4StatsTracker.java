package com.palombodev.bo4statstracker;

import com.palombodev.bo4statstracker.statsform.StatsForm;
import com.palombodev.bo4statstracker.player.PlayerManager;
import com.palombodev.bo4statstracker.util.JReader;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class BO4StatsTracker {

    private static BO4StatsTracker bo4StatsTracker;
    private static StatsForm statsForm;
    private static JReader jReader;
    private static PlayerManager playerManager;
    private static JSONObject jsonObject;

    public static void main(String[] args) {
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");

        new BO4StatsTracker();
    }

    public BO4StatsTracker() {
        bo4StatsTracker = this;
        statsForm = new StatsForm();
        jReader = new JReader();
        playerManager = new PlayerManager();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                if (getPlayerManager().getPlayer() != null) {

                    try {
                        jsonObject = getjReader().readJsonFromUrl(
                                "https://cod-api.theapinetwork.com/api/stats/bo4/" + getPlayerManager().getPlayer().getPlayerName() + "/xbl?type=multiplayer"
                        );

                        getPlayerManager().setPlayer(getPlayerManager().getPlayer().getPlayerName(), jsonObject);

                        if (!getStatsForm().updatingLabel.isVisible())
                            getStatsForm().updatingLabel.setVisible(true);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 5000);
    }

    public static StatsForm getStatsForm() {
        return statsForm;
    }

    public static JReader getjReader() {
        return jReader;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static JSONObject getJsonObject() {
        return jsonObject;
    }

    public static BO4StatsTracker getBo4StatsTracker() {
        return bo4StatsTracker;
    }

}
