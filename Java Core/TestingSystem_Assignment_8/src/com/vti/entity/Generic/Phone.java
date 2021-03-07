package com.vti.entity.Generic;

public class Phone<K, V> extends MyMap<K, V> {

	public Phone(K key, V value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}
	public V getPhoneNumber() {
		return super.getValue();
	}

}
