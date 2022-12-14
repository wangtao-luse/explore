package com.explore.common.tool;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJsonTool {
private FastJsonTool() {}
private final static String COMMON_KEY_RESULT ="result";
	/**
	 * Map 转JsonObject对象
	 * @param map Map
	 * @return JSONObject
	 */
	public static JSONObject mapToJson(Map map) {
		String text = JSON.toJSONString(map);
		JSONObject parseObject = JSONObject.parseObject(text);
		return parseObject;
	}
	/**
	 * Object转为JSONObject
	 * @param obj
	 * @return JSONObject
	 */

	public static JSONObject objToJSONObject(Object obj) {
		String text = JSON.toJSONString(obj);
		JSONObject parseObject = JSONObject.parseObject(text);
		return parseObject;
	}
	/**
	 * Map转为实体List
	 * @param <T>
	 * @param map  Map
	 * @param clazz  实体
	 * @param key   键
	 * @return  List
	 */
	public static <T> List<T> mapToList(Map<String,Object> map,Class<T> clazz,String key){
		  JSONObject mapToJson = FastJsonTool.mapToJson(map);
		 List<T> javaList = mapToJson.getJSONArray(key).toJavaList(clazz);
		return javaList;
	}
	/**
	 * Map转为实体List
	 * @param <T>
	 * @param map  Map
	 * @param clazz  实体
	 * @param key   键
	 * @return  List
	 */
	public static <T> List<T> mapToList(Map<String,Object> map,Class<T> clazz){
		  JSONObject mapToJson = FastJsonTool.mapToJson(map);
		 List<T> javaList = mapToJson.getJSONArray(FastJsonTool.COMMON_KEY_RESULT).toJavaList(clazz);
		return javaList;
	}
	/**
	 * Map 转实体类
	 * @param <T>
	 * @param map  map
	 * @param clazz 类
	 * @param key  键
	 * @return  实体类型对象
	 */
	public static <T> T mapToObject(Map<String,Object> map,Class<T> clazz,String key){
		JSONObject mapToJson = FastJsonTool.mapToJson(map);
		 T javaObject = mapToJson.getJSONObject(key).toJavaObject(clazz);
		return javaObject;
	}
	/**
	 * Map 转实体类
	 * @param <T>
	 * @param map  map
	 * @param clazz 类
	 * @param key  键
	 * @return  实体类型对象
	 */
	public static <T> T mapToObject(Map<String,Object> map,Class<T> clazz){
		JSONObject mapToJson = FastJsonTool.mapToJson(map);
		T javaObject = mapToJson.getJSONObject(FastJsonTool.COMMON_KEY_RESULT).toJavaObject(clazz);
		return javaObject;
	}
	/**
	 * map转字符串
	 * @param map
	 * @param key
	 * @return
	 */
	public static String mapTosStirng(Map<String,Object>map,String key) {
		JSONObject mapToJson = FastJsonTool.mapToJson(map);
		String string = mapToJson.getString(key);
		return string;
	}
	/**
	 * Map 转为JSONArray
	 * @param map
	 * @param key
	 * @return
	 */
	public static JSONArray mapToJSONArray(Map<String,Object>map,String key) {
		JSONObject json = new JSONObject(map);
		JSONArray jsonArray = json.getJSONArray(key);
		return jsonArray;
	}
	/***
	 * 将对象转为实体对象
	 * @param <T>
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> T toJavaBean(Object text,Class<T> clazz) {
		String jsonString = JSONObject.toJSONString(text);
		T parseObject = JSONObject.parseObject(jsonString, clazz);
		return parseObject;
		
	}

}
