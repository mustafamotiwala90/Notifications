package com.example.notifications;

import java.io.BufferedInputStream;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;
import android.support.v4.app.NavUtils;

public class CreateNotification extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);
    }

	public void createNotification(View view) {
    	
//		NotificationManager notificationManager = (NotificationManager) 
//					getSystemService(NOTIFICATION_SERVICE);
//		Notification notification = new Notification(R.drawable.android,
//				"A new notification", System.currentTimeMillis());
//		Notification notification = new Notification.Builder(getApplicationContext()).setContentTitle("New Mail From : ").setContentText("HEllo 4.1").setSmallIcon(R.drawable.android).build();
		// Hide the notification after its selected
		
		Bitmap smallBitmap = null;
		Bitmap largeBitmap = null;
		BufferedInputStream buf = null;
		BufferedInputStream buf1 = null;
		try {
			buf = new BufferedInputStream(getAssets().open("apple.png"));
			largeBitmap = BitmapFactory.decodeStream(buf);
			buf.close();
			buf1 = new BufferedInputStream(getAssets().open("launcher.png"));
			smallBitmap = BitmapFactory.decodeStream(buf1);
			buf1.close();
			}
		catch(Exception er)
		{
			er.printStackTrace();
		}
		Builder builder = new Notification.Builder(this);
		builder.setContentTitle("New Mail From");
		builder.setContentText("Hello Android");
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setTicker("Android image downloaded");
		builder.setLargeIcon(smallBitmap);
		builder.setAutoCancel(true);
		//		builder.build();
		
		Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
		bigPictureStyle.bigLargeIcon(smallBitmap);
		bigPictureStyle.bigPicture(smallBitmap);
		bigPictureStyle.setBigContentTitle("Android Image Downloaded");
		bigPictureStyle.setSummaryText("Applico test 4.1");
		
		
		((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).notify(01, bigPictureStyle.build());
		
//		notification.flags |= Notification.FLAG_AUTO_CANCEL;
//		
//		RemoteViews contentView = new RemoteViews("com.example.notifications", R.layout.custom_notifications);
//		contentView.setImageViewResource(R.id.image, R.drawable.android);
//		contentView.setTextViewText(R.id.title, "Custom notification");
//		contentView.setTextViewText(R.id.text, "This is a custom layout");
//		notification.contentView = contentView;
////		
//		Intent intent = new Intent(this, NotificationReceiver.class);
//		PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
//		notificationManager.notify(0, bigPictureStyle.build());

	}
}
