package net.beny.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    //główne zmienne gry
    int ruch = 1;
    String[][] poleGry = new String[3][3];
    Boolean czyKoniec = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void klik(View view) {
        // Do something in response to button click
        // Log.i("TAG", view.toString());
        if (!czyKoniec) {

            //używane zmienne
            Button button = (Button) view;
            int pozycjaX = 0;
            int pozycjaY = 0;

            //idButton = button.getId();
            //Log.i("TAG", String.valueOf(idButton));

            // przypisanie pozycji przycisku do pola Gry.
            switch (button.getId()) {
                case R.id.button_0x0:
                    pozycjaX = 0;
                    pozycjaY = 0;
                    break;
                case R.id.button_0x1:
                    pozycjaX = 0;
                    pozycjaY = 1;
                    break;
                case R.id.button_0x2:
                    pozycjaX = 0;
                    pozycjaY = 2;
                    break;
                case R.id.button_1x0:
                    pozycjaX = 1;
                    pozycjaY = 0;
                    break;
                case R.id.button_1x1:
                    pozycjaX = 1;
                    pozycjaY = 1;
                    break;
                case R.id.button_1x2:
                    pozycjaX = 1;
                    pozycjaY = 2;
                    break;
                case R.id.button_2x0:
                    pozycjaX = 2;
                    pozycjaY = 0;
                    break;
                case R.id.button_2x1:
                    pozycjaX = 2;
                    pozycjaY = 1;
                    break;
                case R.id.button_2x2:
                    pozycjaX = 2;
                    pozycjaY = 2;
                    break;
            }

            // przypisanie wartości do ruchu i pola gry
            if (ruch % 2 != 0) {
                button.setText(R.string.x);
                button.setEnabled(false);
                poleGry[pozycjaX][pozycjaY] = "X";
                ruch++;

            } else {
                button.setText(R.string.o);
                button.setEnabled(false);
                poleGry[pozycjaX][pozycjaY] = "O";
                ruch++;
            }

            //wykrywanie wygranej
            String[] wybor = new String[2];
            wybor[0] = "X";
            wybor[1] = "O";


            for (int w = 0; w < 2; w++) {
                for (int x = 0; x < 3; x++) {
                    if ((poleGry[x][0] == wybor[w]) & (poleGry[x][1] == wybor[w]) & (poleGry[x][2] == wybor[w])) {
                        Log.i("MainActivity", "Wygrywa " + wybor[w]);
                        czyKoniec = true;
                    }
                }
                for (int y = 0; y < 3; y++) {
                    if ((poleGry[0][y] == wybor[w]) & (poleGry[1][y] == wybor[w]) & (poleGry[2][y] == wybor[w])) {
                        Log.i("MainActivity", "Wygrywa " + wybor[w]);
                        czyKoniec = true;
                    }
                }
                if ((poleGry[0][0] == wybor[w]) & (poleGry[1][1] == wybor[w]) & (poleGry[2][2] == wybor[w])) {
                    Log.i("MainActivity", "Wygrywa " + wybor[w]);
                    czyKoniec = true;
                }
                if ((poleGry[0][2] == wybor[w]) & (poleGry[1][1] == wybor[w]) & (poleGry[2][0] == wybor[w])) {
                    Log.i("MainActivity", "Wygrywa " + wybor[w]);
                    czyKoniec = true;
                }
            }

            if ((ruch == 10) & (!czyKoniec)) {
                Log.i("MainActivity", "REMIS");
                czyKoniec = true;
            }
        }
    }

}
