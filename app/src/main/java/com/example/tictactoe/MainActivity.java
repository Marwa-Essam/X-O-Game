package com.example.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView player1ScoreView;
    TextView player2ScoreView;
    ConstraintLayout root;
    int counter = 0;
    int scoreplayer1 = 0;
    int scoreplayer2 = 0;
    ArrayList<String> boardState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1ScoreView = findViewById(R.id.tvp1);
        player2ScoreView = findViewById(R.id.tvp2);
        root = findViewById(R.id.rootLayout);
        initializeBordState();
    }

    public void onPlayClick(View view) {
        Button clickedButton = (Button) view;
        if (!clickedButton.getText().toString().isEmpty()) {
            return;
        }
        String playerSympol = counter % 2 == 0 ? "X" : "O";
        clickedButton.setText(playerSympol);
        writeplayerSympol(clickedButton.getId(), playerSympol);
        counter++;
        if (checkWinner(playerSympol)) {
            if (playerSympol.equals("X")) {
                scoreplayer1 = (int) Double.parseDouble(player1ScoreView.getText().toString());
                player1ScoreView.setText(++scoreplayer1 + "");
                resatBord();
                System.out.println("X win");
            } else {
                scoreplayer2 = (int) Double.parseDouble(player2ScoreView.getText().toString());
                player2ScoreView.setText(++scoreplayer2 + "");
                resatBord();
                System.out.println("O win");


            }
        }

        if (counter == 9) {
            resatBord();
        }
        Log.e("OnButtonClivked", "Board" + boardState);
    }

    boolean checkWinner(String playCode) {
        //check raws
        for (int i = 0; i < 9; i += 3) {
            if (boardState.get(i).equals(playCode) &&
                    boardState.get(i + 1).equals(playCode) &&
                    boardState.get(i + 2).equals(playCode)) {
                return true;
            }
        }
        //check colums

        for (int i = 0; i < 3; i += 1) {
            if (boardState.get(i).equals(playCode) &&
                    boardState.get(i + 3).equals(playCode) &&
                    boardState.get(i + 6).equals(playCode)) {
                return true;
            }
        }

        if (boardState.get(0).equals(playCode) &&
                boardState.get(4).equals(playCode) &&
                boardState.get(8).equals(playCode)) {
            return true;
        }
        if (boardState.get(2).equals(playCode) &&
                boardState.get(4).equals(playCode) &&
                boardState.get(6).equals(playCode)) {
            return true;
        }
        return false;
    }

    void writeplayerSympol(int id, String playerSympol) {
        if (id == R.id.btn1) {
            boardState.set(0, playerSympol);

        } else if (id == R.id.btn2) {
            boardState.set(1, playerSympol);

        } else if (id == R.id.btn3) {
            boardState.set(2, playerSympol);

        } else if (id == R.id.btn4) {
            boardState.set(3, playerSympol);

        } else if (id == R.id.btn5) {
            boardState.set(4, playerSympol);

        } else if (id == R.id.btn6) {
            boardState.set(5, playerSympol);

        } else if (id == R.id.btn7) {
            boardState.set(6, playerSympol);

        } else if (id == R.id.btn8) {
            boardState.set(7, playerSympol);

        } else if (id == R.id.btn9) {
            boardState.set(8, playerSympol);
        }
    }

    void initializeBordState() {
        boardState = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }
    }

    void resatBord() {
        counter = 0;
        initializeBordState();
        for (int i = 0; i < root.getChildCount(); i++) {
            if (root.getChildAt(i) instanceof LinearLayout) {
                LinearLayout linearLayout = ((LinearLayout) root.getChildAt(i));
                for (int j = 0; j < linearLayout.getChildCount(); j++)
                    if (linearLayout.getChildAt(j) instanceof Button) {
                        ((Button) linearLayout.getChildAt(j)).setText("");
                    }

            }
        }
    }

}