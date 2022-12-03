package hu.krisz.foxandhounds;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.service.command.Exit;
import hu.krisz.foxandhounds.service.command.GameCommands;
import hu.krisz.foxandhounds.service.exception.ExitException;
import hu.krisz.foxandhounds.service.exception.MapBuildException;
//import hu.krisz.foxandhounds.service.player.Player;
import hu.krisz.foxandhounds.service.validator.MapValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MapBuildException, Exit, SQLException, ExitException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.krisz.foxandhounds");
        String inCommand = "";
        String username = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        username = input.nextLine();
        //int score = new Player(username).playerScore();
        GState gameState = applicationContext.getBean(GState.class);
        boolean win = false;
        boolean lose = false;
        while (gameState.isShouldExit() && !win && !lose) {
            System.out.print("Start?: ");
            inCommand = input.nextLine();
            gameState = new GameCommands(inCommand, gameState).checkCommand();
            if (gameState.isShouldExit()) {
                //System.out.println(username + "\t" + score);
                System.out.println(gameState.getMapVO().toString());
                win = new MapValidator(gameState).YouWin();
                if (win) {
                    System.out.println("You Won!");
                    //score = new Player(username).updateScore();
                    //System.out.println("+" + score + " score saved!");
                }
                lose = new MapValidator(gameState).YouLose();
                if (lose) {
                    System.out.println("You Lost!");
                }
            }
        }
    }
}