

import DataRetriever;
import Team;
import Player;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataRetriever retriever = new DataRetriever();

        Team team = retriever.findTeamById(1);
        if (team != null) {
            System.out.println(team.getName());
            System.out.println(team.getPlayersCount());
        }

        List<Player> players = retriever.findPlayers(0, 10);
        System.out.println(players.size());
    }
}
