package com.molo.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import org.junit.Test;

public class BatteryInfoMonitor {

	private Runtime run = Runtime.getRuntime();
	long t0;
	long f0;
	Boolean flag=true;
	long baidu0;
	long baidu1;
	long j360;
	long t360;
	
	@Test
	public void test(){
		String dd = "var d = {\"data\":\"{\\\"com.tencent.tmgp.xxd\\\":\"{\\\"appName\\\":\\\"仙侠道\\\",\\\"install\\\":1,\\\"verName\\\":\\\"1.7.5.41111\\\",\\\"verCode\\\":41111,\\\"appId\\\":0,\\\"manifestMd5\\\":\\\"f19cda113900de65a9e3b7a1af30ce0a\\\",\\\"canUpdate\\\":0}\",\\\"com.tencent.Qfarm\\\":\"{\\\"install\\\":0}\",\\\"com.tencent.tmgp.szr\\\":\"{\\\"install\\\":0}\",\\\"com.yinhan.shenmo.tencent\\\":\"{\\\"install\\\":0}\",\\\"com.tencent.feiji\\\":\"{\\\"install\\\":0}\",\\\"com.tencent.tmgp.xxd\\\":\"{\\\"install\\\":0}\",\\\"com.yinhan.hunter.tx\\\":\"{\\\"install\\\":0}\",\\\"com.tencent.tmgp.monster\\\":\"{\\\"appName\\\":\\\"怪物弹珠\\\",\\\"install\\\":1,\\\"verName\\\":\\\"1.0.0\\\",\\\"verCode\\\":15,\\\"appId\\\":0,\\\"manifestMd5\\\":\\\"16d0a5772de106487ac8ce0a0923308c\\\",\\\"canUpdate\\\":1}\"}\",\"result\":0,\"seqid\":123,\"method\":\"getAppInfo\"}";
		System.out.println(dd);
		System.out.println(dd.replace("\\\\", ""));
	}
	
	@Test
	public  void isMonkeyOff() throws InterruptedException{
		String cmd = "adb shell ps";
		Boolean tag = false;
		while(true){
			System.out.println("running...");
			
			if(run(cmd, "com.android.commands.monkey")!=null && !run(cmd, "com.android.commands.monkey").equals("")){
				while(true){
					System.out.println("found!!");
					if(run(cmd, "com.android.commands.monkey") == null){
						System.out.println("out!!");
						tag = true;
						return;
					}
					Thread.sleep(1000);
				}
			}
			Thread.sleep(1000);
		}
		
	}
	
	@Test
	public void testCmd() throws InterruptedException, IOException{
		//run.exec("adb shell am start -n com.tencent.qqappmarket.hd/com.tencent.assistant.activity.MainFrameActivity");
		// home
		//Thread.sleep(10000);
		//run.exec("adb shell input keyevent 3");
		//Thread.sleep(5000);
		//WriteToFile("start_alarm");
		
		t0 = getJiffies("com.tencent.android.qqdownloader");
		f0 = getTraffic("com.tencent.android.qqdownloader");
		
		baidu0 = getJiffies("com.baidu.appsearch");
		baidu1 = getTraffic("com.baidu.appsearch");
		
		j360 = getJiffies("com.qihoo.appstore");
		t360 = getTraffic("com.qihoo.appstore");
 		
		TimerTask task =new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss");
				long t1 = getJiffies("com.tencent.qqappmarket.hd");
				long f1 = getTraffic("com.tencent.qqappmarket.hd");
				
//				long t2 = getJiffies("com.baidu.appsearch");
//				long f2 = getTraffic("com.baidu.appsearch");
//				
//				long t3 = getJiffies("com.qihoo.appstore");
//				long f3 = getTraffic("com.qihoo.appstore");
				
				try {
					//WriteToFile("end_alarm");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(getUid("com.tencent.qqappmarket.hd"));
				System.out.println("HD::"+t.format(new Date())+"-消耗CPU时间片（ms）"+(t1-t0)*10);
				System.out.println("HD::"+t.format(new Date())+"-消耗流量（KB）"+(f1-f0)/1024);
				
//				System.out.println("baidu::"+t.format(new Date())+"-消耗CPU时间片（ms）"+(t2-baidu0)*10);
//				System.out.println("baidu::"+t.format(new Date())+"-消耗流量（KB）"+(f2-baidu1)/1024);
//				
//				System.out.println("360::"+t.format(new Date())+"-消耗CPU时间片（ms）"+(t3-j360)*10);
//				System.out.println("360::"+t.format(new Date())+"-消耗流量（KB）"+(f3-t360)/1024);
				t0 = t1;
				f0 = f1;
				
//				baidu0=t2;
//				baidu1=f2;
//				
//				j360=t3;
//				t360=f3;
				}
			};

		while(true){
			// 通宵每2小时采样一次  最后取平均值
			Thread.sleep(1000);
			task.run();
		}
		
	}
	
	
	public void WriteToFile(String fliename) throws IOException, InterruptedException{
		SimpleDateFormat t = new SimpleDateFormat("HH-mm-ss");
		//run.exec("adb shell am instrument -w -e class com.molo.androidtest.test.mainTest com.molo.androidtest.test/com.zutubi.android.junitreport.JUnitReportTestRunner");
		Process proc = run.exec("adb shell dumpsys alarm ");
		InputStream  is = proc.getInputStream();
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String line = null;
		File f = new File("F:/BatteryInfoMonitor/"+fliename+"-"+t.format(new Date())+".txt");
        f.createNewFile(); // 创建新文件  
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        
        while((line = buf.readLine())!=null){
        	out.write(line+"\r\n");// \r\n即为换行 
        }
        out.flush(); // 把缓存区内容压入文件  
        out.close();
	}
	
	public  static Long getUid(String pkg){
		String cmd = "adb shell ps";
		String line = run(cmd,pkg);
		String[] aa = null;
		String re = "";
		long bb = 0;
		if(null != line){
			aa = line.split(" ");
			re = aa[0];
			aa = re.split("_");
			re = aa[1].replaceFirst("a", "");
			bb = Long.parseLong(re);
		}
		return bb+10000;
	}
	// 得到cpu时间片（用户态+核心态）
	public static long getJiffies(String pkg){
		String pid = getPid(pkg);
		long total = 0;
		if(!pid.equals("")){
			String cmd = "adb shell cat /proc/"+getPid(pkg)+"/stat";
			String line = run(cmd);
			String aa[] = line.split(" ");
			long utime = Long.parseLong(aa[13]);
			long stime = Long.parseLong(aa[14]);
			total = utime+stime;
		}
		return total;
		
	}
	// 获取流量Byte（上行+下行）
		public static long getTraffic(String pkg){
			long uid = getUid(pkg);
			String rcvPath = "adb shell cat /proc/uid_stat/" + uid + "/tcp_rcv";
			String sndPath = "adb shell cat /proc/uid_stat/" + uid + "/tcp_snd";
			long rcvTraffic = -1;
			long sndTraffic = -1;
			String rcvline = run(rcvPath);
			String sndline = run(sndPath);
			rcvTraffic = Long.parseLong(rcvline);
			sndTraffic = Long.parseLong(sndline);
			if (rcvTraffic == -1 || sndTraffic == -1) {
				return -1;
			} else {
				return rcvTraffic + sndTraffic;
			}	
		}
		
	// 得到进程号
	public static String getPid(String pkg){
		String cmd = "adb shell ps";
		String line = run(cmd,pkg);
		String[] aa = null;
		String re = "";
		if(null != line){
			aa = line.split(" ");
			re = aa[4];
		}
		return re;
		
	}

	
	public static String run(String cmd){
		String line = null;
		String re ="";
	    InputStream is = null; 
	    try { 
	        Runtime runtime = Runtime.getRuntime(); 
	        Process proc = runtime.exec(cmd); 
	        is = proc.getInputStream(); 
	 
	        // 换成BufferedReader 
	        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
	        while((line = buf.readLine())!=null){
	        	re += line;
	        }
	        
	 
	        if (is != null) { 
	            buf.close(); 
	            is.close(); 
	        } 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	    return re; 
	} 
	
	public static  String run(String cmd, String pkgName) { 
	    String line = null; 
	    InputStream is = null; 
	    try { 
	        Runtime runtime = Runtime.getRuntime(); 
	        Process proc = runtime.exec(cmd); 
	        is = proc.getInputStream(); 
	 
	        // 换成BufferedReader 
	        BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
	        do { 
	            line = buf.readLine(); 
	            // 读取到相应pkgName跳出循环（或者未找到） 
	          
	            if (null == line || line.endsWith(pkgName)) { 
	            	break; 
	            }
	            
	        } while (true); 
	 
	        if (is != null) { 
	            buf.close(); 
	            is.close(); 
	        } 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	    return line; 
	}
}
