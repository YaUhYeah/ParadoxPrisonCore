package com.paradox.core.ces.tasks;

import com.paradox.core.Loader;

import cn.nukkit.scheduler.PluginTask;

public class FormOpenTask extends PluginTask<Loader> {

	public FormOpenTask(Loader owner) {
		super(owner);
		this.num = 3;
	}
	private int num;

	@Override
	public void onRun(int paramInt) {
		this.num -=1;
		if (num <=0) {
			cancel();
		}
	}

}
