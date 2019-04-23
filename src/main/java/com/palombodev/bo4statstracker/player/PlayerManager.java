package com.palombodev.bo4statstracker.player;

import com.palombodev.bo4statstracker.BO4StatsTracker;
import org.json.JSONObject;

public class PlayerManager {

    private Player player;

    public PlayerManager() {
        player = null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(String playerName, JSONObject jsonObject) {
        player = new Player(playerName
                , jsonObject.getJSONObject("stats").get("level").toString()
                , jsonObject.getJSONObject("stats").get("prestige").toString()
                , jsonObject.getJSONObject("stats").get("gamesplayed").toString()
                , jsonObject.getJSONObject("stats").get("wins").toString()
                , jsonObject.getJSONObject("stats").get("losses").toString()
                , jsonObject.getJSONObject("stats").get("ekia").toString()
                , jsonObject.getJSONObject("stats").get("kills").toString()
                , jsonObject.getJSONObject("stats").get("deaths").toString()
                , ""
                , jsonObject.getJSONObject("stats").get("hits").toString()
                , jsonObject.getJSONObject("stats").get("melee").toString()
                , jsonObject.getJSONObject("stats").get("longestkillstreak").toString()
                , jsonObject.getJSONObject("stats").get("curwinstreak").toString()
                , jsonObject.getJSONObject("stats").get("totalshots").toString()
                , jsonObject.getJSONObject("stats").get("teamkills").toString()
                , jsonObject.getJSONObject("stats").get("suicides").toString()
                , jsonObject.getJSONObject("stats").get("killsconfirmed").toString()
                , jsonObject.getJSONObject("stats").get("killsdenied").toString()
                , jsonObject.getJSONObject("stats").get("captures").toString()
                , jsonObject.getJSONObject("stats").get("defends").toString()
                , jsonObject.getJSONObject("stats").get("timeplayed").toString());

        BO4StatsTracker.getStatsForm().levelLabel.setText("Level: " + player.getLevel());
        BO4StatsTracker.getStatsForm().prestigeLabel.setText("Prestige: " + player.getPrestige());
        BO4StatsTracker.getStatsForm().gamesPlayedLabel.setText("Games Played: " + player.getGamesplayed());
        BO4StatsTracker.getStatsForm().winsLabel.setText("Wins: " + player.getWins());
        BO4StatsTracker.getStatsForm().lossesLabel.setText("Losses: " + player.getLosses());
        BO4StatsTracker.getStatsForm().ekiaLabel.setText("EKIA: " + player.getEkia());
        BO4StatsTracker.getStatsForm().killsLabel.setText("Kills: " + player.getKills());
        BO4StatsTracker.getStatsForm().deathsLabel.setText("Deaths: " + player.getDeaths());
        BO4StatsTracker.getStatsForm().kdLabel.setText("KD: " + player.getKd());
        BO4StatsTracker.getStatsForm().hitsLabel.setText("Hits: " + player.getHits());
        BO4StatsTracker.getStatsForm().meleesLabel.setText("Melees: " + player.getMelee());
        BO4StatsTracker.getStatsForm().longestKillStreakLabel.setText("Longest Kill Streak: " + player.getLongestkillstreak());
        BO4StatsTracker.getStatsForm().curWinStreakLael.setText("Current Win Streak: " + player.getCurwinstreak());
        BO4StatsTracker.getStatsForm().totalShotsLabel.setText("Total Shots: " + player.getTotalshots());
        BO4StatsTracker.getStatsForm().teamKillsLabel.setText("Team Kills: " + player.getTeamkills());
        BO4StatsTracker.getStatsForm().killsConfirmedLabel.setText("Kills Confirmed: " + player.getKillsconfirmed());
        BO4StatsTracker.getStatsForm().killsDeniedLabel.setText("Kills Denied: " + player.getKillsdenied());
        BO4StatsTracker.getStatsForm().capturesLabel.setText("Captures: " + player.getCaptures());
        BO4StatsTracker.getStatsForm().defendsLabel.setText("Defends: " + player.getDefends());
        BO4StatsTracker.getStatsForm().timePlayedLabel.setText("Time Played: " + player.getTimeplayed());
        BO4StatsTracker.getStatsForm().suicidesLabel.setText("Suicides: " + player.getSuicides());
        BO4StatsTracker.getStatsForm().playerLabel.setText("Player: " + player.getPlayerName());
    }

    public void removePlayer() {
        player = null;
    }

}
