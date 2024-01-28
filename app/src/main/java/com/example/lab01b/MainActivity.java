package com.example.lab01b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lab01b.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int playerScore = 0;
    int computerScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rockButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                playRound(Weapon.ROCK);
            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playRound(Weapon.PAPER);

            }
        });

        binding.scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playRound(Weapon.SCISSORS);
            }
        });
    }

    private void updateScores(int playerScore, int computerScore) {
        TextView t3 = binding.scoreOutput;
        String scoreText = "Player: " + playerScore + ", Computer: " + computerScore;
        t3.setText(scoreText);
    }
    private void playRound(Weapon playerGuess) {

        TextView t = binding.guessOutput;
        String text = "Player's Guess: " + playerGuess;
        t.setText(text);

        int randomNumber = (int) (Math.random() * 3);
        Enum[] weaponArray = Weapon.values();
        Enum computerGuess = weaponArray[randomNumber];
        TextView t2 = binding.computerOutput;
        String computer = "Computer's Guess: " + computerGuess;
        t2.setText(computer);

        TextView t3 = binding.scoreOutput;
        TextView t4 = binding.reasonOutput;

        if (playerGuess == computerGuess) {
            String scoreText = "Player: " + playerScore + ", Computer: " + computerScore;
            String reasonText = "Draw! " + playerGuess + " cannot beat " + playerGuess + "!";
            t3.setText(scoreText);
            t4.setText(reasonText);
        }
        else if ((playerGuess == Weapon.ROCK && computerGuess == Weapon.SCISSORS) ||
                (playerGuess == Weapon.PAPER && computerGuess == Weapon.ROCK) ||
                (playerGuess == Weapon.SCISSORS && computerGuess == Weapon.PAPER)) {
            playerScore++;
            updateScores(playerScore, computerScore);
            String reasonText = "Player wins: " + playerGuess + " beats " + computerGuess + "!";
            t4.setText(reasonText);
        }
        else {
            computerScore++;
            updateScores(playerScore, computerScore);
            String reasonText = "Computer wins: " + computerGuess + " beats " + playerGuess + "!";
            t4.setText(reasonText);
        }
    }


}