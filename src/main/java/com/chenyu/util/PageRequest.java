package com.chenyu.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageRequest extends org.springframework.data.domain.PageRequest {
	private static final long serialVersionUID = 1L;

	public PageRequest(int page, int size) {
		super(--page, size);
	}

	public PageRequest(int page, int size, Direction direction, String[] properties) {
		super(--page, size, direction, properties);
	}

	public PageRequest(int page, int size, Sort sort) {
		super(--page, size, sort);
	}

}
