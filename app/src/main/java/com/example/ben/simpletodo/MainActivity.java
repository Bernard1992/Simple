package com.example.ben.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//public class MainActivity extends AppCompatActivity {

   // @Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
    //}

 public class MainActivity extends AppCompatActivity {
     ArrayAdapter<String> item;
     ArrayAdapter<String> itemsAdapter;
     ListView lstview;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         lstview = (ListView) findViewById(R.id.lstview);
         items = new ArrayList<>();
         itemsAdapter = new ArrayAdapter<String>(this, android.R.Layout.simple_list_item_l, items);
         lstview.setAdapter(itemsAdapter);
         items.add("Firts item");
         items.add("Second item");
         setupListViewListener();
     }

     public void onAddItem(View v) {
         EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
         String itemText = etNewItem.getText().ToString();
         itemsAdapter.add(itemText);
         etNewItem.setText("");
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         lstview = (ListView) findViewById(R.id.lstview);
         items = new ArrayList<String>();
         itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
         lstview.setAdapter(itemsAdapter);
         items.add("First Item");
         items.add("Second Item");
         setupListViewListener();

     }

     private void setupListViewListener() {
         lstview.setOnItemLongClickListener(
                 new AdapterView.OnItemLongClickListener(){

             @Override
             public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                 item.remove(pos);
                 itemsAdapter.notifyDataSetChanged();
                 return true;
             }
         });
     }

     private void readItems() {
         File filesDir = getFilesDir();
         File todoFile = new File(filesDir, "todo.txt");
         try {
             items = new ArrayList<String>(FileUtils.readLines(todoFile));

         } catch (IOException e) {
             items = new ArrayList<String>();
         }
     }

     private void writeItems() {
         File filesDir = getFilesDir();
         File todoFile = new File(filesDir, "todo.txt");
         try {
             FileUtils.writeLines(todoFile, items);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         readItems();
         itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

     }

     public void onAddItem(View v) {
         EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
         String itemText = etNewItem.getText().toString();
         itemsAdapter.add(itemText);
         etNewItem.setText("");
         writeItems();
     }
    lstview.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener()

         @Override
         public boolean OnItemLongClick (AdapterView <?> adapter, View item,int pos, long id){
         items.remove(pos);
         itemsAdapter.notifyDataSetChanged();
         writeItems();
         return true;

     }
     });
 }




