package com.jimpai.firstgame;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
    // Cocos2d 引擊將會把圖形繪制在該 view 對象上
	private CCGLSurfaceView view = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new CCGLSurfaceView(this);

		setContentView(view);

        // 得到 CCDirector 對象
		CCDirector director = CCDirector.sharedDirector();
        // 設置應用程序相關的屬性
        // 設置當前游戲程序當中所使用的 view 對象
		director.attachInView(view);
        // 設置游戲是否顯示 FPS 值
		director.setDisplayFPS(true);
        // 設置游戲渲染一幀數據所需要的時間
		director.setAnimationInterval(1 / 30.0);
        // 生成一個游戲場景對象
		CCScene scene = CCScene.node();
        // 生成布景層對象
		GameLayer gameLayer = new GameLayer();
		// 將布景層對象添加至游戲場景當中
		scene.addChild(gameLayer);
        // 運行游戲場景
		director.runWithScene(scene);
		//setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
