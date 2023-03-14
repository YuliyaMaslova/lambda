package org.example;

public class Worker {
    public static void main(String[] args) {
        OnTaskDoneListener listener = result -> System.out.println(result);
        OnTaskErrorListener listener1 = errorResult -> System.out.println(errorResult);
        Worker worker = new Worker(listener, listener1);
        worker.start();

    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;


    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Task " + i + " is failed");
                continue;
            }
            callback.onDone("Task " + i + " is done");

        }

    }
}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String errorResult);
}
