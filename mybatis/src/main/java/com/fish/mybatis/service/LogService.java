package com.fish.mybatis.service;

import com.fish.mybatis.entity.Log;
import com.fish.mybatis.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author fish
 */
@Slf4j
@Service
public class LogService {
    @Autowired
    LogMapper logMapper;

    public Log getById(int id) {
        return logMapper.getById(id);
    }
    public String getByAll() {
//    public List<Log> getByAll() {
//        List<Log> logList=logMapper.getByAll();
//        return LogList;
        //优化分批次查询
//        List<Log> logList=new ArrayList<Log>();
        /*int size = 5000;
        int count=logMapper.getCount();
        int threadNum = count / size + 1;

        for (int i = 0; i < threadNum; i++) {
            Map<String, Object> data = new HashMap();
            //分批查询
            data.put("currIndex", i*size);
            data.put("pageSize", size);
            //用 data 去分页查询数据库
            List<Log> logs=logMapper.queryLogsBySql(data);
//            logList.addAll(logs);
        }*/
        //charGPT优化的代码
//        这段代码的目的是从数据库中分批次查询日志数据，可以考虑以下优化：
//
//        使用线程池并行处理多个查询任务，提高查询效率。可以使用Java的Executor框架实现。
//
//        将每个查询任务的结果存入一个List<Log>中，并在所有任务完成后将这些List合并成一个大List。
//
//        调整分页大小（size），使得每个查询任务所处理的数据量适中，既能减小内存消耗，又能提高查询效率。
        int batchSize = 5000; // 每个查询任务处理的数据量
        int count = logMapper.getCount();
        int taskNum = (count + batchSize - 1) / batchSize; // 计算查询任务数

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(taskNum);

        List<Future<List<Log>>> futures = new ArrayList<>();

        for (int i = 0; i < taskNum; i++) {
            final int currIndex = i * batchSize;
            final int pageSize = Math.min(batchSize, count - currIndex); // 处理剩余部分的数据
            Callable<List<Log>> task = () -> {
                Map<String, Object> data = new HashMap<>();
                data.put("currIndex", currIndex);
                data.put("pageSize", pageSize);
                return logMapper.queryLogsBySql(data);
            };
            Future<List<Log>> future = executor.submit(task);
            futures.add(future);
        }

        // 等待所有查询任务完成
        executor.shutdown();
         /*try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 合并所有结果
       List<Log> logList = new ArrayList<>();
        for (Future<List<Log>> future : futures) {
            List<Log> logs = null; // 获取查询结果
            try {
                logs = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            logList.addAll(logs);
        }*/

        return "ok";
    }
    public List<Log> queryLogsBySql(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return logMapper.queryLogsBySql(data);
    }
}