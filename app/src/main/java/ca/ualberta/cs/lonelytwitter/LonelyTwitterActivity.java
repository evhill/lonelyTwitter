package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav"; // Model
	private EditText bodyText; // View and Controller
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); // Model
	private ListView oldTweetsList; // View
	private ArrayAdapter<Tweet> adapter; // Controller

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { // View

		super.onCreate(savedInstanceState); // View
		setContentView(R.layout.main); // View

		bodyText = (EditText) findViewById(R.id.body); // View
		Button saveButton = (Button) findViewById(R.id.save); // View
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //View

		saveButton.setOnClickListener(new View.OnClickListener() {  // Controller

			public void onClick(View v) { //Controller
				setResult(RESULT_OK); // Controller
				String text = bodyText.getText().toString(); // Controller
				tweets.add(new NormalTweet(text)); // Controller
				//ex: dataObject.saveInFile is a controller
				saveInFile(); // Model
				adapter.notifyDataSetChanged(); // View

			}
		});
	}

	@Override
	protected void onStart() { // View
		super.onStart(); // Controller
		loadFromFile(); // Model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);  // View
		oldTweetsList.setAdapter(adapter); // View
		adapter.notifyDataSetChanged(); // View
	}

	private void loadFromFile() { //Model
		try {
			FileInputStream fis = openFileInput(FILENAME); // Model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); // Model
			Gson gson = new Gson(); // Model
			// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
			Type arraylistType = new TypeToken<ArrayList<NormalTweet>>() {}.getType(); // Model
			tweets = gson.fromJson(in, arraylistType); // Model

		} catch (FileNotFoundException e) {
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void saveInFile() { //Model
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0); // Model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos)); // Model
			Gson gson = new Gson(); // Model
			gson.toJson(tweets, out); // Model
			out.flush(); // Model
			fos.close(); // Model
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}