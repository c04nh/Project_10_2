package kr.hs.emirim.w2038.project_10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"북스마트", "캐롤", "반쪽의 이야기", "벌새", "윤희에게", "퍼펙트 케어", "타오르는 여인의 초상", "우먼 인 할리우드", "더 페이버릿"};
    int[] imgIds = {R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05, R.id.img06, R.id.img07, R.id.img08, R.id.img09};
    int[] voteCount = new int[imgIds.length];
    ImageView[] image = new ImageView[imgIds.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title);
        setContentView(R.layout.activity_main);

        for (int i=0; i<imgIds.length; i++){
            final int index;
            index = i;
            image[index] = findViewById(imgIds[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + " 총 "+ voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}