package com.example.a2olage06.fileio;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.PrintWriterPrinter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        String dir_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        EditText et = (EditText) findViewById(R.id.text1);

        if (item.getItemId() == R.id.Save) {

            try {
                FileWriter fw = new FileWriter(dir_path + "/notes.txt");
                PrintWriter pw = new PrintWriter(fw);

                pw.println(et.getText());

                pw.flush();
                pw.close();
            } catch (IOException e) {
                System.out.println("Error! " + e.getMessage());
            }
            return true;
        }

       else if (item.getItemId() == R.id.Load) {
                try
                {
                    FileReader fr = new FileReader(dir_path + "/notes.txt");
                    BufferedReader br = new BufferedReader(fr);
                    et.setText(br.readLine());
                    br.close();
                }
                catch (IOException e)
                {
                    System.out.println("Error! " + e.getMessage());
                }
                return true;

            }

            return false;
        }
    }



