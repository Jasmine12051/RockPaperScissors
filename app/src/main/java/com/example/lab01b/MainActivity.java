package com.example.lab01b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lab01b.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int playerScore = 0;
                int computerScore = 0;
                Weapon playerGuess = Weapon.ROCK;
                TextView t = binding.guessOutput;
                String text = "Player's Guess: " + playerGuess;
                t.setText(text);
                int randomNumber = (int)(Math.random() * 3);
                Enum[] weaponArray = Weapon.values();
                Enum computerGuess = weaponArray[randomNumber];
                TextView t2 = binding.computerOutput;
                String computer = "Computer's Guess: " + computerGuess;
                t2.setText(computer);

                TextView t3 = binding.scoreOutput;
                TextView t4 = binding.reasonOutput;

                if(computerGuess == Weapon.PAPER){
                    computerScore++;
                    String scoreText = "Player: " + playerScore + ", Computer: " + computerScore;
                    String reasonText = "Computer win: Paper covers rock!";
                    t3.setText(scoreText);
                    t4.setText(reasonText);
                }
                else if(computerGuess == Weapon.SCISSORS){
                    playerScore++;
                    String scoreText = "Player: " + playerScore + ", Computer: " + computerScore;
                    String reasonText = "Player win: Rock smashes Scissors!";
                    t3.setText(scoreText);
                    t4.setText(reasonText);
                }
                else{
                    String scoreText = "Player: " + playerScore + ", Computer: " + computerScore;
                    String reasonText = "Draw! Rock cannot beat Rock!";
                    t3.setText(scoreText);
                    t4.setText(reasonText);
                }
            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Weapon paper = Weapon.PAPER;
                TextView t = binding.guessOutput;
                String text = "Player's Guess: " + paper;
                t.setText(text);
                Log.d("WEAPON", "This is the weapon:" + paper);
            }
        });

        binding.scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Weapon scissors = Weapon.SCISSORS;
                TextView t = binding.guessOutput;
                String text = "Player's Guess: " + scissors;
                t.setText(text);
                Log.d("WEAPON", "This is the weapon:" + scissors);
            }
        });

    }
}