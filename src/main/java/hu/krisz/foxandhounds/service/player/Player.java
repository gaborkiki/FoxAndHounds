package hu.krisz.foxandhounds.service.player;

import java.sql.SQLException;

public class Player {
    private String username;

    /*
    private Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost", "gaborkiki", "admin");
    private String insertQuery = "INSERT INTO PLAYERS (NAME, SCORE) VALUES (?, ?)";
    private String updateQuery = "UPDATE PLAYERS SET SCORE = ? WHERE NAME = ?";
*/
    public Player(String username) throws SQLException {
        this.username = username;
    }
/*
    public int playerScore() throws SQLException {
        int score = 0;
        String checkUsername = "";
        boolean usernameNotExist = true;
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PLAYERS");
        while (resultSet.next()) {
            checkUsername = resultSet.getString("NAME");
            if (username.equals(checkUsername)) {
                score = resultSet.getInt("SCORE");
                usernameNotExist = false;
            }
        }
        if (usernameNotExist) {
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, score);

            int changes = preparedStatement.executeUpdate();
            System.out.println(changes + " user created!");
        }
        resultSet.close();
        statement.close();
        preparedStatement.close();
        connection.close();
        return score;
    }
    public int updateScore() throws SQLException {
        int score = 0;
        String checkUsername = "";
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM PLAYERS");
        while (resultSet.next()) {
            checkUsername = resultSet.getString("NAME");
            if (username.equals(checkUsername)) {
                score = resultSet.getInt("SCORE");
            }
        }
        score++;
        preparedStatement.setInt(1, score);
        preparedStatement.setString(2, username);

        int changes = 0;
        changes = preparedStatement.executeUpdate();
        resultSet.close();
        statement.close();
        preparedStatement.close();
        connection.close();
        return changes;
    }

 */
}
