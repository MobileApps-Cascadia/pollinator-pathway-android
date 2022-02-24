package edu.cascadia.mobas.pollinatorpathway;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    public final Executor mDiskIO;
    public final Executor mNetworkIO;
    public final Executor mMainThread;

    private AppExecutors(Executor mDiskIO, Executor mNetworkIO, Executor mMainThread) {
        this.mDiskIO = mDiskIO;
        this.mNetworkIO = mNetworkIO;
        this.mMainThread = mMainThread;
    }

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3),
                new MainThreadExecutor());
    }

    public Executor mDiskIO() {
        return mDiskIO;
    }

    public Executor mNetworkIO() {
        return mNetworkIO;
    }

    public Executor mMainThread() {
        return mMainThread;
    }

    public static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}

