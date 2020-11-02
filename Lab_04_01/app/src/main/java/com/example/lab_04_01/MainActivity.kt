package com.example.lab_04_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    val a= arrayOf(  "top", "com.cn", "com", "net", "cn", "cc", "gov", "cn", "hk");

    fun getCompleteUrl(text: String): Boolean {
        var sb = StringBuilder();
        sb.append("(");
        for (f in a) {
            sb.append(f);
            sb.append("|");
        }
        sb.deleteCharAt(sb.length - 1);
        sb.append(")");

        val p = Pattern.compile("((https?|s?ftp|irc[6s]?|git|afp|telnet|smb)://)((\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})|((www\\.|[a-zA-Z\\.\\-]+\\.)?[a-zA-Z0-9\\-]+\\." + sb.toString() + "(:[0-9]{1,5})?))((/[a-zA-Z0-9\\./,;\\?'\\+&%\\$#=~_\\-]*)|([^\\u4e00-\\u9fa5\\s0-9a-zA-Z\\./,;\\?'\\+&%\\$#=~_\\-]*))", Pattern.CASE_INSENSITIVE);
        val matcher = p.matcher(text);
        return matcher.matches()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_search.setOnClickListener(){
            val uri =Uri.text.toString()
            if (getCompleteUrl(uri)){
                val intent =Intent(Intent.ACTION_VIEW)
                intent.data = android.net.Uri.parse(uri)
                val choose =Intent.createChooser(intent,"选择一个浏览器")
                startActivity(choose)
            }else{
                Toast.makeText(this,"wrong URI,Please retry!",Toast.LENGTH_LONG).show()
                Uri.setText("")
            }

        }
    }
    
}