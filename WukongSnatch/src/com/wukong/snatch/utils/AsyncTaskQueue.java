package com.wukong.snatch.utils;

import java.util.LinkedList;

public class AsyncTaskQueue {

	private final int mThreads;
	private final LinkedList mQueue;
	private final WorkerThreadPool[] threads;
	
	public AsyncTaskQueue(int mThreads){
		this.mThreads=mThreads;
		mQueue=new LinkedList();
		threads=new WorkerThreadPool[mThreads];
		
		for(int i=0;i<mThreads;i++){
			threads[i]=new WorkerThreadPool();
			threads[i].start();
		}
	}
	
	public void execute(Runnable r){
		synchronized(mQueue){
			mQueue.addLast(r);
			mQueue.notify();
		}
	}
	
	private class WorkerThreadPool extends Thread{

		public void run() {
			// TODO Auto-generated method stub
			Runnable r=null;
			while(true){
				synchronized(mQueue){
					while(mQueue.isEmpty()){
						try {
							mQueue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					r=(Runnable) mQueue.removeFirst();
				}
				try{
					r.run();
				}catch(Exception e){
					System.err.println("RunTimeException---"+e);
				}
			}
		}
	}
	
	private static class MyTask implements Runnable{

		
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--OOKK");
		}
		
	}
	
	public static void main(String[] args){
		AsyncTaskQueue taskQueue=new AsyncTaskQueue(5);
		MyTask task[]=new MyTask[20];
		
		for(int i=0;i<20;i++){
			task[i]=new MyTask();
			taskQueue.execute(task[i]);
		}
	}
}
