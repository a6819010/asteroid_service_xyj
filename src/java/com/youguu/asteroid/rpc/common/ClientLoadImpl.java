package com.youguu.asteroid.rpc.common;

import java.util.HashMap;
import java.util.Map;

import com.youguu.core.util.rpc.multipex.IClientLoad;

public class ClientLoadImpl implements IClientLoad {

	@Override
	public Map<String, Class<?>> loadClient() {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		for(ClientMultiplexProp client:ClientMultiplexProp.values()){
			map.put(client.getName(), client.getClient());
		}
		return map;
	}

}
