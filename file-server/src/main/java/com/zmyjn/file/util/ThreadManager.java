package com.zmyjn.file.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
    private static ThreadManager instance;
    private ExecutorService dealFileExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10000), new ThreadPoolExecutor.CallerRunsPolicy());

    private ExecutorService dealPicExecutor = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10000), new ThreadPoolExecutor.CallerRunsPolicy());

    public static ThreadManager getInstance() {
        if (null == instance) {
            instance = new ThreadManager();
        }
        return instance;
    }

    public void executeThread(Runnable thread) {
        this.dealFileExecutor.execute(thread);
    }

    public void excuteDealPicThread(Runnable thread) {
        this.dealPicExecutor.execute(thread);
    }
}
