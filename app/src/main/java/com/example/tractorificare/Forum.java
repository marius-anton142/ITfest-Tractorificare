package com.example.tractorificare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Forum extends AppCompatActivity {
    String mesajInceput="Top questions from the top users:           \n" +
            "1)Q: Where and at what time of year can you buy proper nice tomatoes? ;\n" +
            "2)Q: Places to go in London on Christmas day?\n" +
            "3)Q: Where in london can you buy drug test kits or reagents?\n" +
            "4)Q: Where to find cheap books in London?\n" +
            "5)Q: Buying a Duplex in London - worth it?\n" +
            "6)Q: Where is the best place in London for a VR gaming experience with your mates?\n" +
            "7)Q: What are the most beautiful parks in London?\" +\n"+
            "Type answer to find out the most upvoted replies:";
    String mesajFinal="1)A: Check Turkish, Bulgarian shops. Shops from countries that have warm climate. They often bring those in. I even buy there during summer, because what they're selling in Tesco's is some plastic tomatoes only.\n 2)A:The centre of London will be absolutely dead on Christmas Day. That's a good & bad thing. The regualr attractions will all be closed, but the Bikes & Scooters (where they are active) will be working. I have some friends who do a bike ride through London on Christmas Day; there is no traffic at all and it's the perfect time to do it. Some restaurants will be open, but be prepared to pay a LOT for a Christmas Lunch or dinner. \n 3)A: I dont know of any physical head shop left anywhere tbh, other than the ones specialised in vaping/smoking. Theresa May’s RC blanket ban finished them. But you can easily get reagents and test kits online if you can wait a couple of days for the delivery \n 4)A: Charity shops have reasonably priced second hand books. Cheaper in the suburbs but there’s an Oxfam bookshop at 12 Bloomsbury Street and I think Oxfam Covent Garden sells books too. \n 5)A: No. Londoners need more homes and less empty investment flats \n 6)A: I work at Escape Hunt in Kingston and we have a pretty sexy VR suite with a huge range of beautifully developed puzzle games. Got a fun spoopy seasonal one at the moment based on a Call of Cthulhu kinda setting which is really good fun! \n 7)A: Any of the Royal Parks are always a good value. Other worthy considerations Hampstead Heath, Holland Park, Hyde Park, Regents Park and Primrose Hill \n Type question if you you want to go back to most upvoted questions:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum);

        TextView chatText=(TextView) findViewById(R.id.bot_text);
        chatText.setText(mesajInceput);


    }

    public void modifyAnswer(View view){

        EditText mesajUser= (EditText) findViewById(R.id.mesajUser);
        String raspuns= mesajUser.getText().toString();

        TextView mesajDeveloper= (TextView) findViewById(R.id.bot_text);

        if(raspuns.equals("answer") || mesajUser.equals("Answer")){
            mesajDeveloper.setText(mesajFinal);
            System.out.println("answer");
        }
        else if(raspuns.equals("question") || raspuns.equals("Question")){
            mesajDeveloper.setText(mesajInceput);
            System.out.println("question");

        }

    }
}












