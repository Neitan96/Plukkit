package br.com.nathanalmeida.plukkit.message.binder;

import br.com.nathanalmeida.plukkit.message.message.PlukMessage;

import java.util.Map;

/**
 * Project: Plukkit
 * Author: Neitan96
 * Since: 06/09/2019 17:14
 */
public final class PlukBinder{

	public static final MessageBinder BINDER_DEFAULT = new MessageBinderDefault();

	public  static MessageBinder makeBinder(){
		return new MessageBinderDefault();
	}

	public static String bindValue(String msg, String key, String value){
		return BINDER_DEFAULT.bindValue(msg, key, value);
	}

	public static String bindDefaults(String msg){
		return BINDER_DEFAULT.bindDefaults(msg);
	}

	public static String[] bindDefaults(String[] msg){
		return BINDER_DEFAULT.bindDefaults(msg);
	}

	public static String bindValues(String msg, String... binds){
		return BINDER_DEFAULT.bindValues(msg, binds);
	}

	public static String[] bindValues(String[] msg, String... binds){
		return BINDER_DEFAULT.bindValues(msg, binds);
	}

	public static String bindValues(String msg, Map<String, String> binds){
		return BINDER_DEFAULT.bindValues(msg, binds);
	}

	public static String[] bindValues(String[] msgs, Map<String, String> binds){
		return BINDER_DEFAULT.bindValues(msgs, binds);
	}

}
