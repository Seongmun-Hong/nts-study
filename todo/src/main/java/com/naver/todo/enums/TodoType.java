package com.naver.todo.enums;

public enum TodoType {
	TODO {
		@Override
		public TodoType getNextType() {
			return DOING;
		}
	},
	DOING {
		@Override
		public TodoType getNextType() {
			return DONE;
		}
	},
	DONE {
		@Override
		public TodoType getNextType() {
			throw new IllegalStateException("Done Type cannot be updated");
		}
	};

	public abstract TodoType getNextType();
}
