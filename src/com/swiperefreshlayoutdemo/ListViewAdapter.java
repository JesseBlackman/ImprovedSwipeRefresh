package com.swiperefreshlayoutdemo;

import java.util.LinkedList;

import com.swiperefreshlayout.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAdapter extends BaseAdapter {

	private final LinkedList<Boolean> selected = new LinkedList<Boolean>();  
	private Context context;
	private LayoutInflater inflater;  
	private LinkedList<LetterItemInfo> list;

	

	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				
				
				break;
			default:
				showMsg("wtf");
				break;		
			}
		};
	};

	
	
	public ListViewAdapter(Context context, LinkedList<LetterItemInfo> list) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);  
		this.list = list;
	}
	
	 
	public LinkedList<Boolean> getSelect() {  
	        return selected;  
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
	
		ViewHolder holder = null;  
		if (convertView == null) {
			
			holder=new ViewHolder();         
			
			convertView = LayoutInflater.from(context).inflate(R.layout.swiperefreshlayout_listview_item, null);
			
			
			holder.useravatar = (ImageView) convertView.findViewById(R.id.swiperefreshlayout_letterview_item_useravatar);
			holder.usernickname = (TextView) convertView.findViewById(R.id.swiperefreshlayout_listview_item_usernickname);
		
		
			
		
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		final LetterItemInfo LetterItemInfo = list.get(position); 
	
		holder.useravatar.setBackgroundResource(R.drawable.touxiang);
		holder.usernickname.setText(LetterItemInfo.getusernickname());		

		

        
		return convertView;
	}

	
 
     
	//holder
	public final class ViewHolder {  
		public ImageView useravatar;
		public TextView usernickname;

	}  	

	
	private void showMsg(String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
	
	
	
}
