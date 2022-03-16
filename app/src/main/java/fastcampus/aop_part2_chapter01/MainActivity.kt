package fastcampus.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText : EditText = findViewById(R.id.heightEditText) // 변수 타입 선언 시 findViewById의 타입을 선언 할 필요 X
        val weightEditText = findViewById<EditText>(R.id.weightEditText)// 변수 타입 미선언 시 findViewById의 타입을 선언 해줘야 함

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            if(heightEditText.text.isEmpty() || heightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 이 아래로는 절대 빈값이 올 수 없음
            val height = heightEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)// 다음 activity에 데이터 넘겨주기
            intent.putExtra("weight", weight)
            startActivity(intent)
        }

    }
}