package com.lunz.cpfw.web.config;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.context.request.RequestContextHolder;

import com.lunz.cpfw.web.config.ContextAwareCallable;

public class ContextAwarePoolExecutor extends ThreadPoolTaskExecutor {
    private static final long serialVersionUID = 1L;

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return (Future<T>) super.submit(new ContextAwareCallable<T>(task, RequestContextHolder.currentRequestAttributes()));
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        return super.submitListenable(new ContextAwareCallable<T>(task, RequestContextHolder.currentRequestAttributes()));
    }
}