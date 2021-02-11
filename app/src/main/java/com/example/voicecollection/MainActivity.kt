package com.example.voicecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.AudioAttributes
import android.media.SoundPool
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val voice=arrayOf("お楽しみはここからだ",
        "ここで消えろ!",
        "こっ...小賢しい真似をしやがって",
        "これで...終わりだ！",
        "これは僕の力だ",
        "な...何?",
        "まだまだ足りないよ",
        "まるで話にならない",
        "俺は魔族の王だ",
        "下らない",
    "勘違いするなよ",
    "見つけたぞ",
    "邪魔はさせない",
    "全力でかかってきなさい",
    "駄目だ、もう戦えない...",
    "目障りだ",
    "遊びは終わりだ!",
    "お姉さん!大好き♡",
    "おやすみなさい",
    "邪魔をするな",
    "もがく者ともよ、その程度か...","魔族の力を思い知るがいい...","喰らいやがれ!")
    val file=arrayOf(R.raw.a,
        R.raw.b,
        R.raw.c,
        R.raw.d,
        R.raw.e,
        R.raw.f,
        R.raw.g,
        R.raw.h,
        R.raw.i,
        R.raw.j,
        R.raw.k,
        R.raw.l,
        R.raw.m,
        R.raw.n,
        R.raw.o,
        R.raw.p,
        R.raw.q,
        R.raw.r,
        R.raw.s, R.raw.t,
                R.raw.u,R.raw.v,R.raw.w)

    var voicefile= arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    lateinit var soundPool:SoundPool
    var voice0=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list_of_voice= ArrayAdapter(this,android.R.layout.simple_list_item_1,voice)
        voice_list.setAdapter(list_of_voice)
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(2)
            .build()
        for(x in 0..22){
            voicefile[x]=soundPool.load(this,file[x],1)
        }
        voice_list.setOnItemClickListener{parent, view, position,id ->
            soundPool.play(voicefile[position],1.0f,1.0f,0,0,1.0f)
        }
    }
}