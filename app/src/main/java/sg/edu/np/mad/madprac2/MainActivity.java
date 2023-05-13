package sg.edu.np.mad.madprac2;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";
    User myUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create");
        myUser = new User("Zach", "Lorem ipsum dolor sit amet, consectetur adipiscing elit,"+
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

        Intent receivingEnd = getIntent();

        TextView nameAndID = findViewById(R.id.textView);
        nameAndID.setText(myUser.name + " " + receivingEnd.getIntExtra("randint",0));
        TextView desc = findViewById(R.id.textView3);
        desc.setText(myUser.description);

    }

    @Override
    protected void onResume(){
        super.onResume();

        Button followButton = findViewById(R.id.followButton);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myUser.followed == false){
                    myUser.followed = true;
                    followButton.setText("Unfollow");
                    String Text = "Followed";
                    Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();

                }
                else{
                    myUser.followed = false;
                    followButton.setText("Follow");
                    String Text = "Unfollowed";
                    Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
                }
                Log.v(TITLE, "Button A is pressed");
            }
        });

        Button messageButton = findViewById(R.id.messageButton);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(myIntent);
            }
    });
}}