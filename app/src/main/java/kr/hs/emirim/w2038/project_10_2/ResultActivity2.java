package kr.hs.emirim.w2038.project_10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ResultActivity2 extends AppCompatActivity {
    int[] imgVIds = {R.id.imgv01};
    ViewFlipper viewFlip;
    ImageView[] imgv = new ImageView[imgVIds.length];
    int[] imgSrcIds = {R.drawable.booksmart, R.drawable.carol, R.drawable.halfofit, R.drawable.hummingbird, R.drawable.moonlit, R.drawable.perpectcare, R.drawable.portrait, R.drawable.thischangeseverything, R.drawable.favourite};
    int[] voteCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        Intent intent = getIntent();
        voteCount = intent.getIntArrayExtra("voteCount");

        viewFlip = findViewById(R.id.view_flip);
        viewFlip.setFlipInterval(500);
        sortDescImgSrc();
        for (int i = 0; i < imgv.length; i++) {
            imgv[i] = findViewById(imgVIds[i]);
            imgv[i].setImageResource(imgSrcIds[i]);
        }

        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    viewFlip.startFlipping();
                    break;
                case R.id.btn_stop:
                    viewFlip.stopFlipping();
                    break;
            }
        }
    };

    protected void sortDescImgSrc() {

        for (int i = 0; i < voteCount.length; i++) {
            for (int j = i + 1; j < voteCount.length; j++) {
                if (voteCount[i] < voteCount[j]) { //내림차순
                    int tmp = voteCount[i];
                    int tempSrc = imgSrcIds[i];
                    voteCount[i] = voteCount[j];
                    imgSrcIds[i] = imgSrcIds[j];
                    voteCount[j] = tmp;
                    imgSrcIds[j] = tempSrc;
                }
            }
        }
    }
}