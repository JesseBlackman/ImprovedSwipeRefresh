package com.swiperefreshlayoutdemo;

import android.os.Bundle;
import android.os.Handler;
import java.util.LinkedList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import com.swiperefreshlayout.R;
import com.swiperefreshlayout.SwipeRefreshLayout;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener,SwipeRefreshLayout.OnLoadListener{
	
	private SwipeRefreshLayout 			swipeLayout;  
	private boolean isRefresh 	= false;//是否刷新中 
	private boolean isLoad 	  	= false;//是否刷新中
	
	private ListView 					lv;  
	private ListViewAdapter 			lvadapter;
	private LinkedList<LetterItemInfo> 	lvdatalist; 

	
	
	@SuppressLint("ResourceAsColor")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		swipeLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_container);  
	    swipeLayout.setOnRefreshListener(this);  
	    swipeLayout.setOnLoadListener(this);
	    //加载颜色是循环播放的，只要没有完成刷新就会一直循环，color1>color2>color3>color4  
	    swipeLayout.setColor(android.R.color.holo_blue_light,  
	            android.R.color.holo_green_light,  
	            android.R.color.holo_orange_light, android.R.color.holo_red_light);  

	   
	    lv = (ListView)findViewById(R.id.read_listview);
	    lv.setDivider(null);
		lvdatalist = new LinkedList<LetterItemInfo>();		
		lvadapter = new ListViewAdapter(this, lvdatalist);
	
		
		initData();	
		lv.setAdapter(lvadapter);

	}

	private void initData() {
		
		
		for(int i=0;i< 10 ;i++){
			LetterItemInfo info = new LetterItemInfo();	
			info.setusernickname("互联网的那点事");	

			lvdatalist.add(info);
			info = null;
		}
		
			
	}
	
	
	public void onRefresh() { if(!isRefresh){ isRefresh = true;  
    new Handler().postDelayed(new Runnable() {  
        public void run() {  
            swipeLayout.setRefreshing(false);  
            for(int i=0;i< 2 ;i++){
				LetterItemInfo info = new LetterItemInfo();
		
				info.setusernickname("果壳网");	

				lvdatalist.addFirst(info);
				info = null;;
			}
			lvadapter.notifyDataSetChanged();
            
            isRefresh= false;  
        }  
    }, 3000); }  
	}  
	
	public void onLoad() { if(!isLoad){ isLoad = true;  
    new Handler().postDelayed(new Runnable() {  
        public void run() {  
            swipeLayout.setLoading(false);  
            for(int i=0;i< 2 ;i++){
				LetterItemInfo info = new LetterItemInfo();
		
				info.setusernickname("爱到极致是变态");	
				lvdatalist.addLast(info);
				info = null;
			}
			lvadapter.notifyDataSetChanged();
            
			isLoad= false;  
        }  
    }, 3000); }  
	}  
	
	
	

	

	
	
	
	private void showMsg(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

}
