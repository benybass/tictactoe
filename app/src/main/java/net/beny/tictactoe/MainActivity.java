package net.beny.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    //główne zmienne gry
    int ruch = 1;
    String[][] poleGry = new String[3][3];
    String ktoWygral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //metoda komunikatu
    public void komunikat() {
        new AlertDialog.Builder(this)
                .setMessage(ktoWygral)
                .setTitle(R.string.koniec_gry)
                .setPositiveButton(R.string.ok, null)
                .setNegativeButton(R.string.info, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        komunikat_info();
                    }
                })
                .show();
    }

    //metoda komunikatu info
    public void komunikat_info() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.infoTitle)
                .setMessage(R.string.infoLine)
                .setPositiveButton(R.string.ok, null)
                .show();
    }

    //metoda do czyszczenia i resetowania gry
    public void resetGry() {
        //komunikat wyniku
        komunikat();

        //zmienne metody
        int[] buttonsId = new int[9];
        buttonsId[0] = R.id.button_0x0;
        buttonsId[1] = R.id.button_0x1;
        buttonsId[2] = R.id.button_0x2;
        buttonsId[3] = R.id.button_1x0;
        buttonsId[4] = R.id.button_1x1;
        buttonsId[5] = R.id.button_1x2;
        buttonsId[6] = R.id.button_2x0;
        buttonsId[7] = R.id.button_2x1;
        buttonsId[8] = R.id.button_2x2;
        ruch = 1;

        //czyszczenie tablicy poleGry
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                poleGry[x][y] = "";
            }
        }

        //czyszczenie przycisków
        for (int id = 0; id < 9; id++) {
            View view = findViewById(buttonsId[id]);
            Button button = (Button) view;
            button.setEnabled(true);
            button.setText("");
        }
    }

    //obsługa kliknięcia i główna logika gry
    public void klik(View view) {


        //używane metody
        Button button = (Button) view;
        int pozycjaX = 0;
        int pozycjaY = 0;

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
                if ((poleGry[x][0] == wybor[w]) & (poleGry[x][1] == wybor[w]) &
                        (poleGry[x][2] == wybor[w])) {
                    ktoWygral = "Wygrywa " + wybor[w];
                    resetGry();
                }
            }
            for (int y = 0; y < 3; y++) {
                if ((poleGry[0][y] == wybor[w]) & (poleGry[1][y] == wybor[w]) &
                        (poleGry[2][y] == wybor[w])) {
                    ktoWygral = "Wygrywa " + wybor[w];
                    resetGry();
                }
            }
            if ((poleGry[0][0] == wybor[w]) & (poleGry[1][1] == wybor[w]) &
                    (poleGry[2][2] == wybor[w])) {
                ktoWygral = "Wygrywa " + wybor[w];
                resetGry();
            }
            if ((poleGry[0][2] == wybor[w]) & (poleGry[1][1] == wybor[w]) &
                    (poleGry[2][0] == wybor[w])) {
                ktoWygral = "Wygrywa " + wybor[w];
                resetGry();
            }
        }

        if (ruch == 10) {
            ktoWygral = "REMIS!";
            resetGry();
        }

    }

}
