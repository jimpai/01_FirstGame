package com.jimpai.firstgame;

import org.cocos2d.actions.instant.CCFlipX;
import org.cocos2d.actions.instant.CCFlipY;
import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

public class GameLayer extends CCLayer {
	CCSprite player;
	CCSprite pics;
	
	public GameLayer() {
		
		player = CCSprite.sprite("player.png");
		player.setPosition(100, 200);
		this.addChild(player);
		
		pics = CCSprite.sprite("pics.jpg");
		pics.setPosition(500,500);
		this.addChild(pics);
		
		CGPoint target = CGPoint.ccp(200, 200);
		CCJumpTo jumpTo = CCJumpTo.action(5, target, 200, 5);
		//player.runAction(jumpTo);
		CCFlipY flipY = CCFlipY.action(true);
		//player.runAction(flipY);
		CCSequence seq = CCSequence.actions(jumpTo, flipY);
		
		player.runAction(seq);
		
		CCFlipX flipX = CCFlipX.action(true);
		pics.runAction(flipX);
	}

}
