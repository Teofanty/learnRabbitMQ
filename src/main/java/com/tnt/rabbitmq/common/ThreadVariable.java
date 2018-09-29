package com.tnt.rabbitmq.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ThreadVariable {
	
	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
	private final static String ID = "ID";
	private final static String QUEUE_NAME = "QUEUE_NAME";
	private final static String EXCHANGE_NAME = "EXCHANGE_NAME";
	private final static String PAYLOAD =  "PAYLOAD";
	
	public static void clearThreadVariable() {
        threadLocal.remove();
    }

	public static void setID(String id) {
        setObject(ID, id);
    }

    public static void setQueueName(String queueName) {
        setObject(QUEUE_NAME, queueName);
    }
    
    public static void setExchangeName(String exchangeName) {
        setObject(EXCHANGE_NAME, exchangeName);
    }
    
    public static void setPayload(String payload) {
        setObject(PAYLOAD, payload);
    }

    public static String getID() {
        Map map = (Map) threadLocal.get();
        return Objects.isNull(map) ? null : (String) map.get(ID);
    }

    public static String getQueueName() {
    	Map map = (Map) threadLocal.get();
        return Objects.isNull(map) ? null : (String) map.get(QUEUE_NAME);
    }
    public static String getExchangeName() {
    	Map map = (Map) threadLocal.get();
        return Objects.isNull(map) ? null : (String) map.get(EXCHANGE_NAME);
    }
    public static String getPayload() {
    	Map map = (Map) threadLocal.get();
        return Objects.isNull(map) ? null : (String) map.get(PAYLOAD);
    }

    private static void setObject(String key, Object value) {
        Map map = (Map) threadLocal.get();
        map = Objects.isNull(map) ? new HashMap() : map;
        map.put(key, value);
        threadLocal.set(map);
    }
}
